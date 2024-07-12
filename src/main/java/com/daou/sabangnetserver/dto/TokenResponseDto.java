package com.daou.sabangnetserver.dto;

public class TokenResponseDto {

    private String accessToken;
    private String refreshToken;


    public String getAccessToken() {
        return accessToken;
    } // accessToken 값을 반환하는 getter 메소드

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    } // accessToken 값을 설정하는 setter 메소드

    public String getRefreshToken() {
        return refreshToken;
    } // refresh 값을 반환하는 getter 메소드

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    } // refresh 값을 반환하는 setter 메소드


}