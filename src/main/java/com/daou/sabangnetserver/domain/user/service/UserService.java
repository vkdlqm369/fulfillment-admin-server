package com.daou.sabangnetserver.domain.user.service;

import com.daou.sabangnetserver.domain.user.dto.UserDto;
import com.daou.sabangnetserver.domain.user.dto.UserRegisterRequestDto;
import com.daou.sabangnetserver.domain.user.dto.UserSearchRequestDto;
import com.daou.sabangnetserver.domain.user.dto.UserSearchResponseDto;
import com.daou.sabangnetserver.domain.user.entity.User;
import com.daou.sabangnetserver.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserDto convertToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setPermission(user.getPermission());
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setMemo(user.getMemo());
        userDto.setDepartment(user.getDepartment());
        userDto.setRegistrationDate(user.getRegistrationDate());
        userDto.setLastLoginTime(user.getLastLoginTime());
        userDto.setLastLoginIp(user.getLastLoginIp());
        userDto.setIsUsed(user.getIsUsed());

        return userDto;
    }


    public UserSearchResponseDto searchUsers(UserSearchRequestDto requestDto){

        Pageable pageable = PageRequest.of(requestDto.getPage() - 1, requestDto.getShowList());

        Page<User> userPage = userRepository.searchUsers(
                requestDto.getId(),
                requestDto.getName(),
                requestDto.getEmail(),
                requestDto.getIsUsed(),
                pageable
        );


        List<UserDto> userDtos = userPage.getContent().stream().map(this::convertToDto).collect(Collectors.toList());

        UserSearchResponseDto responseDto = UserSearchResponseDto.of(userPage.getNumber(), (int) userPage.getTotalElements(), userDtos);

        return responseDto;
    }

    @Transactional
    public void registerUser(UserRegisterRequestDto requestDto){

        if (userRepository.existsById(requestDto.getId())) {
            throw new RuntimeException("이미 존재하는 아이디입니다.");
        }

        if (userRepository.existsByEmail(requestDto.getEmail())) {
            throw new RuntimeException("이미 존재하는 이메일입니다.");
        }

        LocalDateTime registrationDate = LocalDateTime.now().withNano(0);


        User user = new User();
        user.setId(requestDto.getId());
        user.setPw(passwordEncoder.encode(requestDto.getPw()));
        user.setPermission(requestDto.getPermission());
        user.setName(requestDto.getName());
        user.setEmail(requestDto.getEmail());
        user.setDepartment(requestDto.getDepartment());
        user.setMemo(requestDto.getMemo());
        user.setRegistrationDate(registrationDate);
        user.setIsUsed("FALSE");
        userRepository.save(user);




    }

}
