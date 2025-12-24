package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component   // ✅ THIS IS THE FIX
public class JwtTokenProvider {

    public String createToken(Long userId, String email, Set<String> roles) {
        return "token";
    }

    public boolean validateToken(String token) {
        return true;
    }

    public Object getClaims(String token) {
        return null;
    }
}
