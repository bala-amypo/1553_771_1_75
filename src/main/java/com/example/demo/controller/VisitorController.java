package com.example.demo.controller;

import com.example.demo.model.Visitor;
import com.example.demo.service.VisitorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    // CREATE VISITOR
    @PostMapping
    public Visitor createVisitor(@RequestBody Visitor visitor) {
        return visitorService.createVisitor(visitor);
    }

    // GET VISITOR BY ID
    @GetMapping("/{id}")
    public Visitor getVisitor(@PathVariable Long id) {
        return visitorService.getVisitor(id);
    }

    // GET ALL VISITORS
    @GetMapping
    public List<Visitor> getAllVisitors() {
        return visitorService.getAllVisitors();
    }
}
