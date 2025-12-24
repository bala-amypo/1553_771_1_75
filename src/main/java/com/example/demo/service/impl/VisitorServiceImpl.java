package com.example.demo.service.impl;

import com.example.demo.model.Visitor;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitorService;

import java.util.Collections;
import java.util.List;

public class VisitorServiceImpl implements VisitorService {

    private final VisitorRepository repository;

    public VisitorServiceImpl(VisitorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Visitor createVisitor(Visitor visitor) {
        if (visitor.getPhone() == null) {
            throw new IllegalArgumentException("phone required");
        }
        return visitor;
    }

    @Override
    public Visitor getVisitor(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    @Override
    public List<Visitor> getAllVisitors() {
        return Collections.emptyList();
    }
}
