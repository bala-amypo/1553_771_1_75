package com.example.demo.service.impl;

import com.example.demo.model.RiskScore;
import com.example.demo.service.RiskScoreService;
import com.example.demo.util.RiskLevelUtils;

import java.util.Collections;
import java.util.List;

public class RiskScoreServiceImpl implements RiskScoreService {

    @Override
    public RiskScore evaluateVisitor(Long visitorId) {
        int score = 0;
        return RiskScore.builder()
                .totalScore(score)
                .riskLevel(RiskLevelUtils.determineRiskLevel(score))
                .build();
    }

    @Override
    public RiskScore getScoreForVisitor(Long visitorId) {
        return RiskScore.builder()
                .totalScore(0)
                .riskLevel("LOW")
                .build();
    }

    @Override
    public List<RiskScore> getAllScores() {
        return Collections.emptyList();
    }
}
