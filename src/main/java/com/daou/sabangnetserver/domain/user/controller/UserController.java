package com.daou.sabangnetserver.domain.user.controller;

import com.daou.sabangnetserver.domain.user.dto.UserSearchRequestDto;
import com.daou.sabangnetserver.domain.user.dto.UserSearchResponseDto;
import com.daou.sabangnetserver.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/search")
    public ResponseEntity<UserSearchResponseDto> searchUsersTest(@ModelAttribute UserSearchRequestDto requestDto) {
        return ResponseEntity.ok(userService.searchUsers(requestDto));
    }
}
