package com.daou.sabangnetserver.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserUpdateMeRequestDto {
    String name;
    String email;
    String department;
    String memo;
}
