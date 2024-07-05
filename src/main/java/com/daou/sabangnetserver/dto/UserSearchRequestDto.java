package com.daou.sabangnetserver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearchRequestDto {
    private String id;
    private String name;
    private String email;
    private String is_used;
    private int page;
    private int show_list;
}
