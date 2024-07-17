package com.daou.sabangnetserver.domain.user.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
public class HistorySearchDto {
    private LocalDateTime loginTime;
    private String name;
    private String id;
    private String loginDevice;
    private String loginIp;
}
