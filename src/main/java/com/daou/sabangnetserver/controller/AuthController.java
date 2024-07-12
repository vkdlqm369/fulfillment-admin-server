package com.daou.sabangnetserver.controller;

import com.daou.sabangnetserver.dto.ProjectInfo;
import com.daou.sabangnetserver.dto.TokenRequestDto;
import com.daou.sabangnetserver.dto.TokenResponseDto;
import com.daou.sabangnetserver.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth") // 이 클래스의 모든 method가 /auth 경로를 기본으로 갖음
public class AuthController {

    @Autowired
    private AuthService authService;

    @Value("${apiKey.no}") // application.properties 에서 apiKey.no를 읽어와
    private String apiKey; // apuKey 필드에 저장

    @Value("${sltnCd.no}") // application.properties 에서 sltnCd.no를 읽어와
    private String sltnCd; // sltnCd 필드에 저장


    @PostMapping("/tokens/create") // /auth/tokens/create 경로로 들어오는 POST Request 처리 ...
    public ResponseEntity<TokenResponseDto> createTokens() { //TokenResponseDto 타입의 응답을 ResponseEntity 객체에 반환
        TokenRequestDto request = new TokenRequestDto(apiKey, sltnCd); // apiKey와 sltnCd를 이용하여 TokenRequestDto 객체를 생성
        TokenResponseDto tokenResponse = authService.createTokens(request); // 이를 AuthService의 createTokens 메소드에 전달
        return ResponseEntity.ok(tokenResponse); // HTTP 응답으로 상태코드와 함께 tokenResponse 객체 반환
    }
}
