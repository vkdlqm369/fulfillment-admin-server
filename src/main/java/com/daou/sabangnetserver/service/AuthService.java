package com.daou.sabangnetserver.service;

import com.daou.sabangnetserver.dto.TokenRequestDto;
import com.daou.sabangnetserver.dto.TokenResponseDto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class AuthService {
    @Value("${external.api.base-url}") // application properties에서 값을 읽어와
    private String baseUrl; // baseUrl에 저장

    @Value("${seller.no}") // application properties에서 값을 읽어와
    private String sellerNo; // sellerNo에 저장

    private final RestTemplate restTemplate = new RestTemplate(); // RestTemplate 객체를 생성, restTemplate 필드에 저장

    // RestTemplate을 사용해 외부 API와 통신하고, 응답을 TokenResponseDto로 반환
    public TokenResponseDto createTokens(TokenRequestDto request) { // request를 createTokens의 인자로 전달
        String url = String.format("%s/%s/account/tokens/create", baseUrl, sellerNo); // URL 생성
        HttpHeaders headers = new HttpHeaders(); // HttpHeader 객체 생성
        headers.setContentType(MediaType.APPLICATION_JSON); // JSON 형식의 데이터

        HttpEntity<TokenRequestDto> entity = new HttpEntity<>(request, headers); //HttpEntity 객체 생성

        //응답을 저장할 ResponseEntity 객체 선언 및 RestTemplate을 사용하여 외부 API와 통신
        ResponseEntity<TokenResponseDto> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, TokenResponseDto.class);
        return responseEntity.getBody(); //ResponseEntity 객체에서 응답 본문 추출
    }
}

