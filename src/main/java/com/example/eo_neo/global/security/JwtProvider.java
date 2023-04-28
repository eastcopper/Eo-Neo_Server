package com.example.eo_neo.global.security;

import com.example.eo_neo.global.security.auth.Details;
import com.example.eo_neo.global.security.auth.DetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtProvider {

    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256); // 암호화할 때 사용될 시큐리티 키

    private final DetailsService detailsService;

    public Authentication generatAuthentication(String token) {
        Claims claims = parseToken(token);
        String accountId = claims.getSubject();
        Details details = (Details) detailsService.loadUserByUsername(accountId);
        return new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
    }

    public Claims parseToken(String token) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJwt(token).getBody();
    }

    public String accessTokenGenerator(String accountId) {
        return generateToken(accountId, "access", 1800L);
    }

    public String refreshTokenGenerator(String accountId) {
        return generateToken(accountId, "refresh", 43200L);
    }

    private String generateToken(String accountId, String type, Long exp) {

        // subject = id 박는 곳
        // expiration = 만료시간 정하는 곳
        // claim = token type 박는 곳
        // signWith = 해당 토큰을 암호화할 키
        return Jwts.builder()
                .setSubject(accountId)
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .claim("type", type)
                .signWith(secretKey)
                .compact();
    }
}
