package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Visitor;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorService {

    private final VisitorRepository repo;

    public VisitorServiceImpl(VisitorRepository repo) {
        this.repo = repo;
    }

    @Override
    public Visitor createVisitor(Visitor v) {

        if (v == null)
            throw new BadRequestException("visitor data required");

        if (v.getPhone() == null || v.getPhone().isBlank())
            throw new BadRequestException("phone required");

        return repo.save(v);
    }

    @Override
    public Visitor getVisitor(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Visitor not found"));
    }

    @Override
    public List<Visitor> getAllVisitors() {
        return repo.findAll();
    }
}
