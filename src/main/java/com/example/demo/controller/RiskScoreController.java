package com.example.demo.controller;

import com.example.demo.model.RiskScore;
import com.example.demo.service.RiskScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-scores")
public class RiskScoreController {

    private final RiskScoreService riskScoreService;

    public RiskScoreController(RiskScoreService riskScoreService) {
        this.riskScoreService = riskScoreService;
    }

    @PostMapping("/evaluate/{visitorId}")
    public RiskScore evaluateVisitor(@PathVariable Long visitorId) {
        return riskScoreService.evaluateVisitor(visitorId);
    }

    @GetMapping("/{visitorId}")
    public RiskScore getScore(@PathVariable Long visitorId) {
        return riskScoreService.getScoreForVisitor(visitorId);
    }

    @GetMapping
    public List<RiskSc
