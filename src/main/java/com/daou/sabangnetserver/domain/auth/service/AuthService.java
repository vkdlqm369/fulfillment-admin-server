package com.daou.sabangnetserver.domain.auth.service;

import com.daou.sabangnetserver.global.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final TokenProvider tokenProvider;

    public String extractAuthorities (String token) {
        Collection<? extends GrantedAuthority> authorities = tokenProvider.getAuthoritiesFromToken(token);
        return authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
    }

    public String extractId(String token) {
        return tokenProvider.getIdFromToken(token);
    }


}
