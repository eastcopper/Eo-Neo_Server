package com.example.eo_neo.global.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = parseRequest(request);
        if (!token.isEmpty()) {
            // 시큐리티 콘텍스트에 Authentication을 저장한다.
            SecurityContextHolder.getContext().setAuthentication(jwtProvider.generatAuthentication(token));
        }
        filterChain.doFilter(request, response);
    }

    private String parseRequest(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) return token.substring(7);
        return null;
    }
}
