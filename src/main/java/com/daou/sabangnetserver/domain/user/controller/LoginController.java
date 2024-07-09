package com.daou.sabangnetserver.domain.user.controller;


import com.daou.sabangnetserver.domain.user.dto.HistoryDto;
import com.daou.sabangnetserver.domain.user.dto.LoginDto;
import com.daou.sabangnetserver.domain.user.repository.UserRepository;
import com.daou.sabangnetserver.domain.user.service.HistoryService;
import com.daou.sabangnetserver.domain.user.service.LoginService;
import com.daou.sabangnetserver.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RequestMapping(value="/")
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final HistoryService historyService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        String res = "FALSE";

        if(loginService.validateLoginInfo(loginDto)) {
            // SimpleDateFormat 사용 고려
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            loginService.updateLastLoginInfo(loginDto, timestamp);
            historyService.updateHistory(loginDto, timestamp);
            res = "TRUE";
        }

        return ResponseEntity.ok(res);
    }
}
