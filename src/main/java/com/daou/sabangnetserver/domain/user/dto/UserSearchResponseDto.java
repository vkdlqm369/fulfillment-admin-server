package com.daou.sabangnetserver.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class UserSearchResponseDto {
    private int page;
    private int totalLists;
    private int totalPages;
    private List<UserDto> users;

    public static UserSearchResponseDto of(int page, int totalLists, int totalPages, List<UserDto> users) {
        UserSearchResponseDto dto = UserSearchResponseDto.builder()
                .page(page)
                .totalLists(totalLists)
                .totalPages(totalPages)
                .users(users)
                .build();
        return dto;
    }

}
