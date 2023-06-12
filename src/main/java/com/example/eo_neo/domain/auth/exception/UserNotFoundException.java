package com.example.eo_neo.domain.auth.exception;

import com.example.eo_neo.global.error.exception.ErrorCode;
import com.example.eo_neo.global.error.exception.ProjectException;

public class UserNotFoundException extends ProjectException {
    public static final UserNotFoundException EXCEPTION =
            new UserNotFoundException();

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}


