package com.daou.sabangnetserver.controller;

import com.daou.sabangnetserver.dto.UserSearchRequestDto;
import com.daou.sabangnetserver.dto.UserSearchResponseDto;
import com.daou.sabangnetserver.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/users", method = RequestMethod.POST)
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/search")
    public ResponseEntity<UserSearchResponseDto> searchUsers(@Valid @RequestBody UserSearchRequestDto requestDto) {
        return ResponseEntity.ok(userService.searchUsers(requestDto));
    }
}
