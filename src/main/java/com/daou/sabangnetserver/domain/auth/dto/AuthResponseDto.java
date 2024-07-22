package com.daou.sabangnetserver.domain.auth.dto;

import lombok.Builder;

@Builder
public class AuthResponseDto {
    private String id;
    private String authority;
}
