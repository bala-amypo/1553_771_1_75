package com.example.demo.service;

import com.example.demo.dto.AuthRequest;

public interface UserService {

    Object register(Object request);

    Object login(AuthRequest request);
}
