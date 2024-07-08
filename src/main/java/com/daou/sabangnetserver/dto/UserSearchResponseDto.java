package com.daou.sabangnetserver.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserSearchResponseDto {
    private int page;
    private int totalLists;
    private int totalPages;
    private List<UserDto> users;

    public static UserSearchResponseDto of(int page, int totalLists, List<UserDto> users) {
        UserSearchResponseDto dto = new UserSearchResponseDto();
        dto.setPage(page);
        dto.setTotalLists(totalLists);
        dto.setUsers(users);
        return dto;
    }

}
