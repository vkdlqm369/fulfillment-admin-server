package com.daou.sabangnetserver.domain.user.service;

import com.daou.sabangnetserver.domain.user.dto.*;
import com.daou.sabangnetserver.domain.user.repository.HistoryRepository;
import com.daou.sabangnetserver.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepo;

    private HistorySearchDto buildHistoryEntity(Object[] result){
        return HistorySearchDto.builder()
                .loginTime((LocalDateTime) result[0])
                .name((String) result[1])
                .id((String) result[2])
                .loginDevice((String) result[3])
                .loginIp((String) result[4])
                .build();
    }

    public HistorySearchResponseDto searchHistory(HistorySearchRequestDto requestDto){
        Pageable pageable = PageRequest.of(requestDto.getPage() - 1, requestDto.getShowList(), Sort.by("loginTime").descending());

        Page<Object[]> historyPage = historyRepo.searchHistorys(requestDto.getId(), requestDto.getName(), pageable);

        List<HistorySearchDto> historyDtos = historyPage.getContent().stream().map(this::buildHistoryEntity).collect(Collectors.toList());

        return HistorySearchResponseDto.builder()
                .totalLists((int) historyPage.getTotalElements())
                .histories(historyDtos)
                .build();
    }

}
