package com.daou.sabangnetserver.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    @NotBlank
    @Size(min = 3, max = 60)
    private String id; //아이디

    @NotBlank
    @Size(min = 3, max = 100)
    private String password; //비밀번호

}
