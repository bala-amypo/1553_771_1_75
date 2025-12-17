package com.example.demo.controller;

import com.example.demo.model.Visitor;
import com.example.demo.service.VisitorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    private final VisitorService service;

    public VisitorController(VisitorService service) {
        this.service = service;
    }

    @PostMapping
    public Visitor create(@RequestBody Visitor visitor) {
        return service.createVisitor(visitor);
    }

    @GetMapping("/{id}")
    public Visitor one(@PathVariable Long id) {
        return service.getVisitor(id);
    }

    @GetMapping
    public List<Visitor> all() {
        return service.getAllVisitors();
    }
}
