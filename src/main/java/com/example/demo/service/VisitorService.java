package com.example.demo.service;
import java.util.List;

import com.example.demo.model.Visitor;

public interface VisitorService {
    public Visitor createVisitor(Visitor visitor);
    public Visitor getVisitorById(Long id);
    List<Visitor> getAllVisitors();
}

