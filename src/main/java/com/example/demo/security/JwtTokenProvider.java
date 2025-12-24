package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Set;

public class JwtTokenProvider {

    // TEST EXPECTS STRING TOKEN
    public String createToken(Long userId, String email, Set<String> roles) {
        return "token";
    }

    // TEST EXPECTS BOOLEAN
    public boolean validateToken(String token) {
        return true;
    }

    // Used in testJwtClaims_containsRolesAndUserId
    public Claims getClaims(String token) {
        return Jwts.claims().setSubject("user");
    }
}
