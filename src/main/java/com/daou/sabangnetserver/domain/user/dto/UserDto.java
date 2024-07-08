package com.daou.sabangnetserver.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class UserDto {
    private Long userId;
    private String permission;
    private String id;
    private String name;
    private String email;
    private String department;
    private String memo;
    private Timestamp registrationDate;
    private Timestamp lastLoginTime;
    private String lastLoginIp;
    private Boolean isUsed;

}
