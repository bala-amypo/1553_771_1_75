package com.example.demo.controller;

import com.example.demo.model.RiskRule;
import com.example.demo.service.RiskRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "RiskRule")
public class RiskRuleController {

    private final RiskRuleService service;

    public RiskRuleController(RiskRuleService service) {
        this.service = service;
    }

    public ResponseEntity<RiskRule> create(RiskRule rule) {
        return ResponseEntity.ok(service.createRule(rule));
    }

    public ResponseEntity<RiskRule> get(Long id) {
        return ResponseEntity.ok(service.getRule(id));
    }

    public ResponseEntity<List<RiskRule>> all() {
        return ResponseEntity.ok(service.getAllRules());
    }
}
