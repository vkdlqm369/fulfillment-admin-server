/*사용자 체크 및 토큰 발급 컨트롤러*/
package com.daou.sabangnetserver.domain.user.controller;

import com.daou.sabangnetserver.domain.user.dto.LoginDto;
import com.daou.sabangnetserver.domain.user.dto.TokenDto;
import com.daou.sabangnetserver.global.jwt.JwtFilter;
import com.daou.sabangnetserver.global.jwt.TokenProvider;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.Token;
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

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthController {
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping("/authenticate")
    public ResponseEntity<TokenDto> authorize(@Valid @RequestBody LoginDto loginDto) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getId(),
                        loginDto.getPassword());

        //authenticate 메소드 실행시 CustomDetailsService 클래스의 loadByUsername 메소드 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(usernamePasswordAuthenticationToken);
        //해당 객체를 SecurityContextHolder에 저장
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //authentication 객체를 generateToken 메소드를 통해 JWT 토큰 생성
        String jwt = tokenProvider.generateToken(authentication);

        HttpHeaders httpHeaders = new HttpHeaders();
        //response header에 jwt token 넣어줌
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer" + jwt);

        return new ResponseEntity<>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);
    }
}
