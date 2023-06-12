package com.example.eo_neo.global.error;

import com.example.eo_neo.global.error.exception.ErrorCode;
import com.example.eo_neo.global.error.exception.ProjectException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ExceptionHandler extends OncePerRequestFilter {
    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (ProjectException e) {
            ErrorCode errorCode = e.getErrorCode();

            ErrorResponse errorResponse = new ErrorResponse(errorCode.getStatus(), errorCode.getMessage());

            String errorResult = objectMapper.writeValueAsString(errorResponse);

            response.setStatus(errorCode.getStatus());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write(errorResult);
        }
    }
}
