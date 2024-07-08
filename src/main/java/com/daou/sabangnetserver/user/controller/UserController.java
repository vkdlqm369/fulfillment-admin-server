package com.daou.sabangnetserver.user.controller;

import com.daou.sabangnetserver.user.dto.UserSearchRequestDto;
import com.daou.sabangnetserver.user.dto.UserSearchResponseDto;
import com.daou.sabangnetserver.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/search")
    public ResponseEntity<UserSearchResponseDto> searchUsers(@Valid @RequestBody UserSearchRequestDto requestDto) {
        return ResponseEntity.ok(userService.searchUsers(requestDto));
    }
}
