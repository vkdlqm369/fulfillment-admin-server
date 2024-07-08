package com.daou.sabangnetserver.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearchRequestDto {
    private String id;
    private String name;
    private String email;
    private String isUsed;
    private int page;
    private int showList;
}
