package com.daou.sabangnetserver.domain.auth.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ApproveRequestDto {
    private List<String> ids;
}
