package com.daou.sabangnetserver.global.error;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {
    private final int code;

    public UserNotFoundException(int code, String message) {
        super(message);
        this.code = code;
    }
}
