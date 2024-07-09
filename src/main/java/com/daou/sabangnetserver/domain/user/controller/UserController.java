package com.daou.sabangnetserver.domain.user.controller;

import com.daou.sabangnetserver.domain.user.dto.UserDto;
import com.daou.sabangnetserver.domain.user.dto.UserSearchRequestDto;
import com.daou.sabangnetserver.domain.user.dto.UserSearchResponseDto;
import com.daou.sabangnetserver.domain.user.entity.User;
import com.daou.sabangnetserver.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/search")
    public ResponseEntity<UserSearchResponseDto> searchUsers(@Valid @RequestBody UserSearchRequestDto requestDto) {
        return ResponseEntity.ok(userService.searchUsers(requestDto));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(
            @Valid @RequestBody UserDto userDto
            ) {
        return ResponseEntity.ok(userService.signup(userDto));
    }

    //권한에 따른 유저 가져오기
    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<User> getMyUserInfo() {
        return ResponseEntity.ok(userService.getMyUserWithAuthorities().get());
    }

    @GetMapping("/user/{username}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<User> getUserInfo(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserWithAuthorities(username).get());
    }

}
