package com.daou.sabangnetserver.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderRequestDto {
    private String ordDtFrom;
    private String ordDtTo;
    private String siteCd;
    private String status;
    private int page;
    private int rowsPerPage;
}
