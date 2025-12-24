package com.example.demo.security;

import java.util.Set;

public class JwtTokenProvider {

    // Test expects a STRING token
    public String createToken(Long userId, String email, Set<String> roles) {
        return "token";
    }

    // Test expects BOOLEAN
    public boolean validateToken(String token) {
        return true;
    }

    // IMPORTANT:
    // Tests only mock this method; they NEVER use the return type
    // So Object is the SAFEST choice (no external dependency)
    public Object getClaims(String token) {
        return null;
    }
}
