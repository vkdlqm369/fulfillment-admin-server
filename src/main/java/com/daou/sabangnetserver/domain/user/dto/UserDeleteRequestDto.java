package com.daou.sabangnetserver.domain.user.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class UserDeleteRequestDto {
    private List<String> ids;
}
