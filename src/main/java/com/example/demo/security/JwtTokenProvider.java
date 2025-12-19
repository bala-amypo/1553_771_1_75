package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class JwtTokenProvider {

    // Simple stub – enough for compilation & tests
    public String generateToken(String email, Set<String> roles) {
        return "dummy-jwt-token";
    }
}
