package com.daou.sabangnetserver.domain.user.service;

import com.daou.sabangnetserver.domain.user.dto.UserDto;
import com.daou.sabangnetserver.domain.user.dto.UserRegisterRequestDto;
import com.daou.sabangnetserver.domain.user.dto.UserSearchRequestDto;
import com.daou.sabangnetserver.domain.user.dto.UserSearchResponseDto;
import com.daou.sabangnetserver.domain.user.entity.Authority;
import com.daou.sabangnetserver.domain.user.entity.User;
import com.daou.sabangnetserver.domain.user.repository.UserRepository;
import com.daou.sabangnetserver.domain.user.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    //유저 및 권한 정보를 가져오는 메소드
    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities(String username) {
        return userRepository.findOneWithAuthoritiesById(username);
    }

    //현재 securityContext에 저장된 유저 정보만 가져옴
    @Transactional(readOnly = true)
    public Optional<User> getMyUserWithAuthorities () {
        return SecurityUtil.getCurrentUsername()
                .flatMap(userRepository::findOneWithAuthoritiesById);
    }


    private UserDto convertToDto(User user){
        UserDto userDto = UserDto.builder()
                .userId(user.getUserId())
                .permission(user.getPermission())
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .memo(user.getMemo())
                .department(user.getDepartment())
                .registrationDate(user.getRegistrationDate())
                .lastLoginTime(user.getLastLoginTime())
                .lastLoginIp(user.getLastLoginIp())
                .isUsed(user.getIsUsed())
                .build();

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

        List<UserDto> userDtos = userPage.getContent().stream().map(this::convertToDto).toList();

        UserSearchResponseDto responseDto = UserSearchResponseDto.of(userPage.getNumber(), (int) userPage.getTotalElements(), userPage.getTotalPages(), userDtos);

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

        //권한 정보 생성
        Authority authority = Authority.builder()
                .authorityName("MASTER".equals(requestDto.getPermission()) ? "ROLE_MASTER" : "ROLE_ADMIN")
                .build();

        User user = User.builder()
                .id(requestDto.getId()) //아이디
                .pw(passwordEncoder.encode(requestDto.getPassword())) //비밀번호 (암호화 해서 가져옴)
                .permission(requestDto.getPermission())
                .name(requestDto. getName()) //이름
                .email(requestDto.getEmail())
                .department(requestDto.getDepartment())
                .memo(requestDto.getMemo())
                .registrationDate(registrationDate)
                .isUsed(true)  // master 승인 로직 api 완료 시 false로 변경
                .authorities(Collections.singleton(authority))
                .build();

        userRepository.save(user);




    }

}
