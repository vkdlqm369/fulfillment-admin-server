package com.daou.sabangnetserver.domain.user.dto;
import lombok.*;

import java.util.List;

@Getter
@Builder
public class HistorySearchResponseDto {
    private int totalLists;
    private int totalPages;
    private List<HistorySearchDto> histories;
}
