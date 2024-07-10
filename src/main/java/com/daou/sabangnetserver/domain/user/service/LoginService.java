package com.daou.sabangnetserver.domain.user.service;

import com.daou.sabangnetserver.domain.user.dto.LoginDto;
import com.daou.sabangnetserver.domain.user.entity.User;
import com.daou.sabangnetserver.domain.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;



@Service
public class LoginService {

    @Autowired
    private UserRepository userRepo;

    public String getIpAddress(HttpServletRequest request){

        String ip = request.getHeader("X-Forwarded-For");

        if (ip == null)
            ip = request.getHeader("Proxy-Client-IP");
        if (ip == null)
            ip = request.getHeader("WL-Proxy-Client-IP");
        if (ip == null)
            ip = request.getHeader("HTTP_CLIENT_IP");
        if (ip == null)
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        if (ip == null)
            ip = request.getRemoteAddr();

        return ip;
    }

    public String getLoginDeviceInfo(HttpServletRequest request){
        String agent = request.getHeader("User-Agent");
        String browser = null;
        if (agent != null) {
            if (agent.contains("Trident")) {
                browser = "MSIE";
            } else if (agent.contains("Chrome")) {
                browser = "Chrome";
            } else if (agent.contains("Opera")) {
                browser = "Opera";
            } else if (agent.contains("iPhone") && agent.contains("Mobile")) {
                browser = "iPhone";
            } else if (agent.contains("Android") && agent.contains("Mobile")) {
                browser = "Android";
            }
            else
                browser = "";
        }
    return agent + " " + browser;

    }

    public void updateLastLoginInfo(LoginDto loginDto){
        Optional<User> user = userRepo.findById(loginDto.getId());
        user.get().setLastLoginIp(loginDto.getLoginIp());
        user.get().setLastLoginTime(loginDto.getLoginTime());
        userRepo.save(user.get());
    }
}
