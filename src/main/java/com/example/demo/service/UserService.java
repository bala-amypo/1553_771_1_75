package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.AuthRequest;

public interface UserService {

    User register(RegisterRequest request);

    Object login(AuthRequest request);
}
