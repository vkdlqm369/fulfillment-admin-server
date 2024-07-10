package com.daou.sabangnetserver.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import netscape.javascript.JSObject;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long userId;
    private String permission;
    private String id;
    private String pw;
    private String name;
    private String email;
    private String department;
    private String memo;
    private LocalDateTime registrationDate;
    private LocalDateTime lastLoginTime;
    private String lastLoginIp;
    private String isUsed;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    private String password;

}
