package com.daou.sabangnetserver.domain.auth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Builder
public class LoginRequestDto {
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]{3,60}$")
    private String id; //아이디
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*])[a-z\\d!@#$%^&*]{10,100}$")
    private String password;

}
