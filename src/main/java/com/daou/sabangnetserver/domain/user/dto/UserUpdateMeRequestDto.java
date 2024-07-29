package com.daou.sabangnetserver.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserUpdateMeRequestDto {
    @NotBlank(message = "이름은 필수적으로 입력해주세요.")
    private String name;

    @NotBlank(message = "이메일은 필수적으로 입력해주세요.")
    @Email(message = "이메일이 유효하지 않습니다.")
    private String email;

    String department;
    String memo;
}
