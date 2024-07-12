package com.daou.sabangnetserver.dto;


public class TokenRequestDto {

    private String sltnCd;
    private String apiKey;

    // Constructors, getters, and setters
    public TokenRequestDto(String apiKey, String sltnCd) { // 두 개의 매개변수를 받는 생성자
        this.apiKey = apiKey; // 전달된 값을 클래스의 apiKey 저장
        this.sltnCd = sltnCd; // 전달된 값을 클래스의 sltnCd 저장
    }

    // Getters and setters
    public String getSltnCd() {
        return sltnCd;
    } // sltnCd 값을 반환하는 getter 메소드

    public void setSltnCd(String sltnCd) {
        this.sltnCd = sltnCd;
    } // sltnCd 값을 설정하는 setter 메소드

    public String getApiKey() {
        return apiKey;
    } // apiKey 값을 반환하는 getter 메소드

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    } // apiKey 값을 설정하는 setter 메소드




}