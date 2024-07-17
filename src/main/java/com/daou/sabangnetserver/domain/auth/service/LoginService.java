package com.daou.sabangnetserver.domain.auth.service;

import com.daou.sabangnetserver.domain.auth.dto.LoginRequestDto;
import com.daou.sabangnetserver.domain.auth.dto.LoginServiceDto;
import com.daou.sabangnetserver.domain.auth.utils.LookUpHttpHearder;
import com.daou.sabangnetserver.domain.user.entity.History;
import com.daou.sabangnetserver.domain.user.entity.User;
import com.daou.sabangnetserver.domain.user.repository.HistoryRepository;
import com.daou.sabangnetserver.domain.user.repository.UserRepository;
import com.daou.sabangnetserver.global.jwt.JwtFilter;
import com.daou.sabangnetserver.global.jwt.TokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class LoginService {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserRepository userRepo;
    private final HistoryRepository historyRepo;

    public HttpHeaders validateLogin(HttpServletRequest request, LoginRequestDto loginRequestDto){

        LookUpHttpHearder lookUpHttpHearder = new LookUpHttpHearder();

        LoginServiceDto loginServiceDto = LoginServiceDto.builder()
                .id(loginRequestDto.getId())
                .password(loginRequestDto.getPassword())
                .loginIp(lookUpHttpHearder.getIpAddress(request))
                .loginDevice(lookUpHttpHearder.getLoginDeviceInfo(request))
                .loginTime(LocalDateTime.now().withNano(0))
                .build();

        HttpHeaders httpHeaders = makeHttpHearderWithJwt(loginServiceDto);
        Long userId = updateUserInfoAndReturnUserId(loginServiceDto);
        insertHistory(loginServiceDto, userId);

        return httpHeaders;
    }

    private HttpHeaders makeHttpHearderWithJwt(LoginServiceDto loginServiceDto){

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginServiceDto.getId(),
                        loginServiceDto.getPassword());
        // authenticate 메소드 실행시 CustomDetailsService 클래스의 loadByUsername 메소드 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(usernamePasswordAuthenticationToken);
        //해당 객체를 SecurityContextHolder에 저장
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //authentication 객체를 generateToken 메소드를 통해 JWT 토큰 생성
        String jwt = tokenProvider.generateToken(authentication);
        HttpHeaders httpHeaders = new HttpHeaders();
        //response header에 jwt token 넣어줌
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer" + jwt);

        return httpHeaders;
    }

    @Transactional
    private Long updateUserInfoAndReturnUserId(LoginServiceDto loginServiceDto){
        User user = userRepo.findById(loginServiceDto.getId()).orElseThrow(
                ()->new RuntimeException("해당 사용자가 없습니다.")
        );
        user.updateLastLoginInfo(loginServiceDto.getLoginIp(), loginServiceDto.getLoginTime());
        userRepo.save(user);
        return user.getUserId();
    }

    @Transactional
    private void insertHistory(LoginServiceDto loginServiceDto, Long userId){
        historyRepo.save(History.builder()
                .loginIp(loginServiceDto.getLoginIp())
                .loginDevice(loginServiceDto.getLoginDevice())
                .userId(userId)
                .loginTime(loginServiceDto.getLoginTime())
                .build()
        );
    }
}
