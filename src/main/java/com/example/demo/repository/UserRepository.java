package com.example.demo.repository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

import java.util.Optional;
@Repository
public interface UserRepository {

    Optional<User> findByEmail(String email);

    User save(User user);
}
