package com.daou.sabangnetserver.domain.auth.controller;

import com.daou.sabangnetserver.domain.auth.dto.ApproveRequestDto;
import com.daou.sabangnetserver.domain.auth.dto.AuthResponseDto;
import com.daou.sabangnetserver.domain.auth.service.AuthService;
import com.daou.sabangnetserver.domain.user.service.UserService;
import com.daou.sabangnetserver.global.common.SuccessResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @GetMapping("/authority")
    public ResponseEntity<SuccessResponse> getAuthorityAndId(@RequestHeader("Authorization") String authorizationHeader) {

        String token = authorizationHeader.substring(7); // "Bearer " 부분 제거
        System.out.println(token);

        String authority = authService.extractAuthorities(token).substring(5);;
        String id = authService.extractId(token);

        AuthResponseDto authResponseDto = AuthResponseDto.builder()
                                            .id(id)
                                            .authority(authority)
                                            .build();

        return ResponseEntity.ok(
                SuccessResponse.builder()
                        .code(HttpStatus.OK.value())
                        .message("토큰에서 권한과 아이디 추출을 성공했습니다.")
                        .data(authResponseDto)
                        .build()
        );
    }

    @PatchMapping("/update/approve")
    public ResponseEntity<SuccessResponse> approveByMaster(@Valid @RequestBody ApproveRequestDto requestDto) {
        userService.updateIsUsed(requestDto);
        return ResponseEntity.ok(SuccessResponse.builder()
                .code(HttpStatus.OK.value())
                .message("승인이 정상적으로 완료되었습니다.")
                .build());
    }

}
