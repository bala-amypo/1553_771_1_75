package com.example.demo.controller;

import com.example.demo.model.RiskScore;
import com.example.demo.service.RiskScoreService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "RiskScore")
public class RiskScoreController {

    private final RiskScoreService service;

    public RiskScoreController(RiskScoreService service) {
        this.service = service;
    }

    public ResponseEntity<RiskScore> evaluate(Long visitorId) {
        return ResponseEntity.ok(service.evaluateVisitor(visitorId));
    }

    public ResponseEntity<RiskScore> get(Long visitorId) {
        return ResponseEntity.ok(service.getScoreForVisitor(visitorId));
    }

    public ResponseEntity<List<RiskScore>> all() {
        return ResponseEntity.ok(service.getAllScores());
    }
}
