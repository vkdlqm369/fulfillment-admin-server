package com.daou.sabangnetserver.service;

import com.daou.sabangnetserver.dto.UserDto;
import com.daou.sabangnetserver.dto.UserSearchRequestDto;
import com.daou.sabangnetserver.dto.UserSearchResponseDto;
import com.daou.sabangnetserver.entity.User;
import com.daou.sabangnetserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {



    @Autowired
    private UserRepository userRepository;

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
        Boolean isUsed = requestDto.getIsUsed() != null && !requestDto.getIsUsed().isEmpty() ? Boolean.parseBoolean(requestDto.getIsUsed()) : null;

        Pageable pageable = PageRequest.of(requestDto.getPage() - 1, requestDto.getShowList());

        Page<User> userPage = userRepository.searchUsers(
                requestDto.getId(),
                requestDto.getName(),
                requestDto.getEmail(),
                isUsed,
                pageable
        );


        List<UserDto> userDtos = userPage.getContent().stream().map(this::convertToDto).collect(Collectors.toList());

        UserSearchResponseDto responseDto = UserSearchResponseDto.of(userPage.getNumber(), (int) userPage.getTotalElements(), userDtos);

        return responseDto;
    }

}
