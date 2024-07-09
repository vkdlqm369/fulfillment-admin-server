package com.daou.sabangnetserver.domain.user.service;

import com.daou.sabangnetserver.domain.user.dto.HistoryDto;
import com.daou.sabangnetserver.domain.user.dto.LoginDto;
import com.daou.sabangnetserver.domain.user.entity.History;
import com.daou.sabangnetserver.domain.user.entity.User;
import com.daou.sabangnetserver.domain.user.repository.HistoryRepository;
import com.daou.sabangnetserver.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class HistoryService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private HistoryRepository historyRepo;

    private History toEntity(LoginDto loginDto, Timestamp timestamp){
        Optional<User> user = userRepo.findById(loginDto.getId());
        History history = new History();
        history.setUserId(user.get().getUserId());
        history.setLoginDevice(loginDto.getLoginDevice());
        history.setLoginIp(loginDto.getLoginIp());
        history.setLoginTime(timestamp);
        return history;
    }

    public void updateHistory(LoginDto loginDto, Timestamp timestamp){
        History history = toEntity(loginDto, timestamp);
        historyRepo.save(history);
    }
}
