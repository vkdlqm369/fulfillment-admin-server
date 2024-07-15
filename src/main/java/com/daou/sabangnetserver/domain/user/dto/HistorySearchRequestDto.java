package com.daou.sabangnetserver.domain.user.dto;

import lombok.*;

@Getter
@Builder
public class HistorySearchRequestDto {
    private String id;
    private String name;
    private int page;
    private int showList;
}
