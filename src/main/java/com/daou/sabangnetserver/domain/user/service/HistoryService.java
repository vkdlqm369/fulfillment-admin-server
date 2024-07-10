package com.daou.sabangnetserver.domain.user.service;

import com.daou.sabangnetserver.domain.user.dto.HistoryDto;
import com.daou.sabangnetserver.domain.user.dto.LoginDto;
import com.daou.sabangnetserver.domain.user.entity.History;
import com.daou.sabangnetserver.domain.user.entity.User;
import com.daou.sabangnetserver.domain.user.repository.HistoryRepository;
import com.daou.sabangnetserver.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HistoryService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private HistoryRepository historyRepo;

    private History toEntity(LoginDto loginDto){
        Optional<User> user = userRepo.findById(loginDto.getId());
        History history = new History();
        history.setUserId(user.get().getUserId());
        history.setLoginDevice(loginDto.getLoginDevice());
        history.setLoginIp(loginDto.getLoginIp());
        history.setLoginTime(loginDto.getLoginTime());
        return history;
    }

    public void updateHistory(LoginDto loginDto){
        History history = toEntity(loginDto);
        historyRepo.save(history);
    }
}
