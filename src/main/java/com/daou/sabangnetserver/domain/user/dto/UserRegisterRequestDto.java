package com.daou.sabangnetserver.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequestDto {
    @NotBlank(message = "아이디는 필수적으로 입력해주세요.")
    @Pattern(regexp = "^[a-zA-Z0-9]{3,}$", message = "아이디는 최소 3자리 이상의 영문 혹은 영문과 숫자를 조합해주세요.")
    private String id;

    @NotBlank(message = "비밀번호는 필수적으로 입력해주세요.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*]).{10,}$", message = "비밀번호는 10자리 이상의 영소문자/숫자/특수문자를 조합해주세요.")
    private String pw;

    @NotBlank(message = "관리자 권한은 필수적으로 입력해주세요.")
    private String permission;

    @NotBlank(message = "이름은 필수적으로 입력해주세요.")
    private String name;

    @NotBlank(message = "이메일은 필수적으로 입력해주세요.")
    @Email(message = "이메일이 유효하지 않습니다.")
    private String email;

    private String department;
    private String memo;
}
