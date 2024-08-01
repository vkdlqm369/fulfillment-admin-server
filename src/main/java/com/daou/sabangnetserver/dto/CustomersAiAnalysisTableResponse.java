package com.daou.sabangnetserver.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomersAiAnalysisTableResponse {
    private Long id;
    private String name;
    private String phoneNumber;
    private List<String> personalizedRecommendations;
    private int orderCount;
    private LocalDateTime analyzedTime;

}
