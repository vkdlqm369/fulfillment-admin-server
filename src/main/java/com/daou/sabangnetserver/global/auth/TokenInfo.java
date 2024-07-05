/*클라이언트에 토큰 전송을 위한 DTO*/
package com.daou.sabangnetserver.global.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class TokenInfo {
    private String grantType; //JWT 인증 타입,Bearer 사용
    private String accessToken;
}
