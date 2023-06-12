package com.example.eo_neo.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProjectException extends RuntimeException{
    private final ErrorCode errorCode;
}