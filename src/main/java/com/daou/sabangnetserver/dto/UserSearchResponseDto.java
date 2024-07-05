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

}
