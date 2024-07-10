package com.daou.sabangnetserver.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {
    private Long userId;
    private String permission;
    private String id;
    private String pw;
    private String name;
    private String email;
    private String department;
    private String memo;
    private LocalDateTime registrationDate;
    private LocalDateTime lastLoginTime;
    private String lastLoginIp;
    private String isUsed;

}
