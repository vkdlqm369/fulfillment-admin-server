package com.daou.sabangnetserver.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import netscape.javascript.JSObject;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long userId;
    private String permission;
    private String id;
    private String name;
    private String email;
    private String department;
    private String memo;
    private Timestamp registrationDate;
    private Timestamp lastLoginTime;
    private String lastLoginIp;
    private Boolean isUsed;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    private String password;

}
