package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class RegisterResponse {
    private Long id;
    private String email;
    private Set<String> roles;
}
