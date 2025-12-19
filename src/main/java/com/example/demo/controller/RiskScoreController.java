package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.RiskScore;
import com.example.demo.service.RiskScoreService;

@RestController
@RequestMapping("/api/risk-scores")
public class RiskScoreController {

    private final RiskScoreService riskScoreService;

    public RiskScoreController(RiskScoreService riskScoreService) {
        this.riskScoreService = riskScoreService;
    }

    @PostMapping("/calculate/{visitorId}")
    public RiskScore calculate(@PathVariable Long visitorId) {
        return riskScoreService.calculateRiskScore(visitorId);
    }

    @GetMapping("/{id}")
    public RiskScore getById(@PathVariable Long id) {
        return riskScoreService.getRiskScore(id);
    }
}
