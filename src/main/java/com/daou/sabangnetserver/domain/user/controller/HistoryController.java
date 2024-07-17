package com.daou.sabangnetserver.domain.user.controller;

import com.daou.sabangnetserver.domain.user.dto.HistorySearchRequestDto;
import com.daou.sabangnetserver.domain.user.dto.HistorySearchResponseDto;
import com.daou.sabangnetserver.domain.user.service.HistoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value="/")
@RestController
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryService historyService;

    @GetMapping("/history")
    public ResponseEntity<HistorySearchResponseDto> searchHistory(@Valid @ModelAttribute HistorySearchRequestDto requestDto) {
        return ResponseEntity.ok(historyService.searchHistory(requestDto));
    }
}