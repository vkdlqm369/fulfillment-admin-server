package com.daou.sabangnetserver.service;

import com.daou.sabangnetserver.dto.OrderRequestDto;
import com.daou.sabangnetserver.dto.OrderResponseDto;
import com.daou.sabangnetserver.dto.TokenRequestDto;
import com.daou.sabangnetserver.dto.TokenResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Value("${external.api.base-url}")
    private String baseUrl;

    @Value("${apiKey.no}")
    private String apiKey;

    @Value("${sltnCd.no}")
    private String sltnCd;

    @Autowired
    private AuthService authService;

    private final RestTemplate restTemplate = new RestTemplate();

    public OrderResponseDto getOrders(String sellerNo, OrderRequestDto requestDto) {
        String url = String.format("%s/openapi/v2/seller/%s/order/orders", baseUrl, sellerNo);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + getAccessToken(sellerNo));

        HttpEntity<OrderRequestDto> entity = new HttpEntity<>(requestDto, headers);

        ResponseEntity<OrderResponseDto> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, OrderResponseDto.class);

        return responseEntity.getBody();
    }

    private String getAccessToken(String sellerNo) {
        TokenRequestDto tokenRequest = new TokenRequestDto(apiKey, sltnCd);
        TokenResponseDto tokenResponse = authService.validateAndRefreshTokens(tokenRequest, sellerNo);
        return tokenResponse.getAccessToken();
    }
}
