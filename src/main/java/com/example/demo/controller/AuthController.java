package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    public ResponseEntity<?> register(Object req) {
        Object result = userService.register(req);
        if (result instanceof ResponseEntity) {
            return (ResponseEntity<?>) result;
        }
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<?> login(AuthRequest req) {
        return ResponseEntity.ok(userService.login(req));
    }
}
