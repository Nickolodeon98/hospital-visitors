package com.example.hospitalvisitors.configuration;

import com.example.hospitalvisitors.utils.JwtTokenProvider;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final String secretKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        /* 헤더에서 토큰을 가져온다. */

        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            log.error("헤더가 없습니다.");
            filterChain.doFilter(request, response);
            return;
        }

        String token = null;
        try {
            token = authorizationHeader.split(" ")[1];
        } catch (Exception e) {
            filterChain.doFilter(request, response);
            throw new RuntimeException(e);
        }

        /* 토큰을 가져왔으면, 유효한지 확인한다. */
        if (JwtTokenProvider.isExpired(token, secretKey)) {
            log.error("만료된 토큰입니다.");
            filterChain.doFilter(request, response);
            return;
        }

        /* 모든 검사를 통과하면, 사용자 아이디를 추출한다. */
        String userId = JwtTokenProvider.getUserId(token, secretKey);

        /* 이제 이 사용자 아이디가 인증되었다는 것을 표시하기 위해 인증된 토큰을 SecurityContextHolder 에 저장한다. */
        SecurityContextHolder.getContext().setAuthentication(JwtTokenProvider.getAuthentication(userId));
        filterChain.doFilter(request, response);
    }
}
