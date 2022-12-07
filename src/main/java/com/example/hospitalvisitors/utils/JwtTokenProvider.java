package com.example.hospitalvisitors.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

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
}
