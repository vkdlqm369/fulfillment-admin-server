package com.daou.sabangnetserver.domain.user.service;

import com.daou.sabangnetserver.domain.user.dto.LoginDto;
import com.daou.sabangnetserver.domain.user.entity.User;
import com.daou.sabangnetserver.domain.user.repository.HistoryRepository;
import com.daou.sabangnetserver.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private HistoryRepository historyRepo;
    @Autowired
    private UserRepository userRepo;

    public boolean validateLoginInfo(LoginDto loginDto) {
        Optional<User> user = userRepo.findById(loginDto.getId());
        if(!user.isPresent())
            return false;
        return user.get().getPw().equals(loginDto.getPassword());
    }

    public void updateLastLoginInfo(LoginDto loginDto, Timestamp timestamp){
        Optional<User> user = userRepo.findById(loginDto.getId());

        user.get().setLastLoginIp(loginDto.getLoginIp());
        user.get().setLastLoginTime(timestamp);
        userRepo.save(user.get());
    }
}
