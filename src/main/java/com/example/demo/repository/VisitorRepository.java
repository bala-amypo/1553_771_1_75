package com.example.demo.repository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Visitor;
import java.util.Optional;
@Repository
public interface VisitorRepository {
    Optional<Visitor> findById(Long id);
}
