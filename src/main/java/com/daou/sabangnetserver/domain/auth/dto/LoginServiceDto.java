package com.daou.sabangnetserver.domain.auth.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class LoginServiceDto {
    private String id;
    private String password;
    private String loginDevice;
    private String loginIp;
    private LocalDateTime loginTime;
}
