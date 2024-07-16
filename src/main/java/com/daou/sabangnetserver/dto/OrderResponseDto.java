package com.daou.sabangnetserver.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {
    private int code;
    private String message;
    private Object response;
    private boolean status;
}
