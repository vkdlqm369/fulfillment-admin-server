package com.daou.sabangnetserver.domain.user.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class HistoryDto {
    private Long historyId;
    private long userId;
    private LocalDateTime loginTime;
    private String loginDevice;
    private String loginIp;
}
