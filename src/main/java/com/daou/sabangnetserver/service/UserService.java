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
        Boolean isUsed = requestDto.getIs_used() != null && !requestDto.getIs_used().isEmpty() ? Boolean.parseBoolean(requestDto.getIs_used()) : null;

        Pageable pageable = PageRequest.of(requestDto.getPage() - 1, requestDto.getShow_list());

        Page<User> userPage = userRepository.searchUsers(
                requestDto.getId(),
                requestDto.getName(),
                requestDto.getEmail(),
                isUsed,
                pageable
        );

        List<UserDto> userDtos = userPage.getContent().stream().map(this::convertToDto).collect(Collectors.toList());

        UserSearchResponseDto responseDto = new UserSearchResponseDto();
        responseDto.setPage(responseDto.getPage());
        responseDto.setTotalLists((int) userPage.getTotalElements());
        responseDto.setUsers(userDtos);

        // TODO 1안
        // 유저 ID를 가지고 히스토리를 조회하는데 유저별 가장 최근의 히스토리를 가져오는 쿼리
        // 를 별도로 작성해서 히스토리를 조회
        // 유저 ID를 키값으로 유저 리스트와 히스토리 리스트를 합치는 방식

        // TODO 2안
        // searchUsers 쿼리를 수정
        // 서브쿼리를 이용해서 최종로그인, 최종로그인IP를 포함한 유저 리스트 정보를 한번에 조회하는 방식

        return responseDto;
    }

}
