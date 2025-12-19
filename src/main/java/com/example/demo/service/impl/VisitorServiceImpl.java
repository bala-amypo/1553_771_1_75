package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Visitor;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorService {

    private final VisitorRepository visitorRepository;

    // ✔ Constructor Injection (MANDATORY for tests)
    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Override
    public Visitor createVisitor(Visitor visitor) {

        // ✔ Mandatory validation (TEST EXPECTED)
        if (visitor.getPhone() == null || visitor.getPhone().isBlank()) {
            throw new IllegalArgumentException("phone required");
        }

        if (visitor.getFullName() == null || visitor.getFullName().isBlank()) {
            throw new IllegalArgumentException("fullName required");
        }

        if (visitor.getIdProof() == null || visitor.getIdProof().isBlank()) {
            throw new IllegalArgumentException("idProof required");
        }

        return visitorRepository.save(visitor);
    }

    @Override
    public Visitor getVisitor(Long id) {
        return visitorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Visitor not found"));
    }

    @Override
    public List<Visitor> getAllVisitors() {
        // ✔ MUST return empty list, NOT null
        return visitorRepository.findAll();
    }
}
