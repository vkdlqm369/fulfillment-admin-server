package com.daou.sabangnetserver.domain.auth.controller;


import com.daou.sabangnetserver.domain.auth.dto.LoginRequestDto;
import com.daou.sabangnetserver.domain.user.service.HistoryService;
import com.daou.sabangnetserver.domain.auth.service.LoginService;
import com.daou.sabangnetserver.global.jwt.TokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value="/")
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final HistoryService historyService;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    // test data 수정하고 @Valid 넣어야함.
    @PostMapping("/login")
    public ResponseEntity<String> login(HttpServletRequest request, @RequestBody LoginRequestDto loginRequestDto) {
            return new ResponseEntity<>(loginService.validateLogin(request, loginRequestDto), HttpStatus.OK);
    }
}
