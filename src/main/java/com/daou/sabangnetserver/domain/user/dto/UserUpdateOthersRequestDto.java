package com.daou.sabangnetserver.domain.user.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserUpdateOthersRequestDto {
    String id;
    String name;
    String permission;
    String email;
    String department;
    String memo;
}

