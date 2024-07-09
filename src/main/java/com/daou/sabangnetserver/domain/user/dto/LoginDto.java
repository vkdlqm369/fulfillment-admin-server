package com.daou.sabangnetserver.domain.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class LoginDto {
    private String id;
    private String password;
    private String loginIp;
    private String loginDevice;
}
