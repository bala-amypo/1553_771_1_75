package com.example.demo.controller;

import com.example.demo.model.RiskRule;
import com.example.demo.service.RiskRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-rules")
public class RiskRuleController {

    private final RiskRuleService riskRuleService;

    public RiskRuleController(RiskRuleService riskRuleService) {
        this.riskRuleService = riskRuleService;
    }

    @PostMapping
    public RiskRule createRule(@RequestBody RiskRule rule) {
        return riskRuleService.createRule(rule);
    }

    @GetMapping
    public List<RiskRule> getAllRules() {
        return riskRuleService.getAllRules();
    }

    @GetMapping("/{id}")
    public RiskRule getRule(@PathVariable Long id) {
        return riskRuleService.getRule(id);
    }
}
