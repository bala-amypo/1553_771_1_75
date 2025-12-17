package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repo,
                           PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public void register(RegisterRequest req) {

        if (req == null || req.getEmail() == null)
            throw new BadRequestException("email required");

        if (repo.findByEmail(req.getEmail()).isPresent())
            throw new BadRequestException("email already exists");

        User user = User.builder()
                .email(req.getEmail())
                .password(encoder.encode(req.getPassword()))
                .role(Set.of("USER"))
                .build();

        repo.save(user);
    }

    @Override
    public AuthResponse login(AuthRequest req) {

        User user = repo.findByEmail(req.getEmail())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        if (!encoder.matches(req.getPassword(), user.getPassword()))
            throw new BadRequestException("invalid credentials");

        // JWT token generation assumed handled elsewhere
        return new AuthResponse("dummy-jwt-token");
    }

    @Override
    public User getByEmail(String email) {

        return repo.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));
    }
}
