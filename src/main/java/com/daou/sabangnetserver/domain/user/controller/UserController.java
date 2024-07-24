package com.daou.sabangnetserver.domain.user.controller;

import com.daou.sabangnetserver.domain.user.dto.UserRegisterRequestDto;
import com.daou.sabangnetserver.domain.user.dto.UserSearchRequestDto;
import com.daou.sabangnetserver.domain.user.dto.*;
import com.daou.sabangnetserver.domain.user.service.UserService;
import com.daou.sabangnetserver.global.common.SuccessResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/search")
    public ResponseEntity<SuccessResponse> searchUsers(@Valid @ModelAttribute UserSearchRequestDto requestDto) {
        return ResponseEntity.ok(SuccessResponse.builder()
                .code(HttpStatus.OK.value())
                .message("유저를 성공적으로 조회했습니다.")
                .data(userService.searchUsers(requestDto))
                .build());
    }

    @PostMapping("/register")
    public ResponseEntity<SuccessResponse> registerUser(@Valid @RequestBody UserRegisterRequestDto requestDto) {
        userService.registerUser(requestDto);
        return ResponseEntity.ok(SuccessResponse.builder()
                .code(HttpStatus.OK.value())
                .message("관리자가 정상적으로 등록되었습니다.")
                .build());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<SuccessResponse> deleteUsers(@RequestBody UserDeleteRequestDto requestDto){
        userService.deleteUser(requestDto);
        return ResponseEntity.ok(SuccessResponse.builder()
                .code(HttpStatus.OK.value())
                .message("관리자가 정상적으로 삭제되었습니다.")
                .build());
    }

    // 수정해야함
    @PatchMapping("/update/others")
    public ResponseEntity<SuccessResponse> updateOtherUser(@RequestBody UserUpdateOthersRequestDto requestDto){
        userService.updateOtherUser(requestDto);
        return ResponseEntity.ok(SuccessResponse.builder()
                .code(HttpStatus.OK.value())
                .message("관리자가 정상적으로 수정되었습니다.")
                .build());

    }
}
