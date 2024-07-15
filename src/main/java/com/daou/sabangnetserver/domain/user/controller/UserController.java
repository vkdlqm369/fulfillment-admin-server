package com.daou.sabangnetserver.domain.user.controller;

import com.daou.sabangnetserver.domain.user.dto.UserRegisterRequestDto;
import com.daou.sabangnetserver.domain.user.dto.UserSearchRequestDto;
import com.daou.sabangnetserver.domain.user.dto.UserSearchResponseDto;
import com.daou.sabangnetserver.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/search")
    public ResponseEntity<UserSearchResponseDto> searchUsers(@Valid @ModelAttribute UserSearchRequestDto requestDto) {
        return ResponseEntity.ok(userService.searchUsers(requestDto));
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRegisterRequestDto requestDto) {
        userService.registerUser(requestDto);
        return ResponseEntity.ok("정상적으로 관리자가 등록되었습니다.");
    }

}
