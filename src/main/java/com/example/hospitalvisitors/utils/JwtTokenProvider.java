package com.example.hospitalvisitors.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {

    public static String createToken(String secretKey, String uid) {

        Claims claims = Jwts.claims().setSubject(uid);

        Date now = new Date();

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + (1000L * 60 * 60)))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public static Claims extractClaims(String token, String secretKey) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    public static boolean isExpired(String token, String secretKey) {
        return extractClaims(token, secretKey).getExpiration().before(new Date()); // 만료일이 오늘보다 이전이면 만료되었다.
    }

    public static String getUserId(String token, String secretKey) {
        return extractClaims(token, secretKey).getSubject();
    }

    public static Authentication getAuthentication(String userId) {
        return new UsernamePasswordAuthenticationToken(userId, "", List.of(new SimpleGrantedAuthority("USER")));
    }
}
