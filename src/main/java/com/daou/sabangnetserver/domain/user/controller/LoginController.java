package com.daou.sabangnetserver.domain.user.controller;


import com.daou.sabangnetserver.domain.user.dto.HistoryDto;
import com.daou.sabangnetserver.domain.user.dto.LoginDto;
import com.daou.sabangnetserver.domain.user.dto.TokenDto;
import com.daou.sabangnetserver.domain.user.repository.UserRepository;
import com.daou.sabangnetserver.domain.user.service.HistoryService;
import com.daou.sabangnetserver.domain.user.service.LoginService;
import com.daou.sabangnetserver.domain.user.service.UserService;
import com.daou.sabangnetserver.global.jwt.JwtFilter;
import com.daou.sabangnetserver.global.jwt.TokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RequestMapping(value="/")
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final HistoryService historyService;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(HttpServletRequest request, @Valid @RequestBody LoginDto loginDto){

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getId(),
                        loginDto.getPassword());

        // authenticate 메소드 실행시 CustomDetailsService 클래스의 loadByUsername 메소드 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(usernamePasswordAuthenticationToken);
        //해당 객체를 SecurityContextHolder에 저장
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //authentication 객체를 generateToken 메소드를 통해 JWT 토큰 생성
        String jwt = tokenProvider.generateToken(authentication);

        HttpHeaders httpHeaders = new HttpHeaders();
        //response header에 jwt token 넣어줌
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer" + jwt);

        loginDto.setLoginDevice(loginService.getLoginDeviceInfo(request));
        loginDto.setLoginIp(loginService.getIpAddress(request));
        loginDto.setLoginTime(LocalDateTime.now().withNano(0));

        loginService.updateLastLoginInfo(loginDto);
        historyService.updateHistory(loginDto);

        return new ResponseEntity<>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);
    }
}
