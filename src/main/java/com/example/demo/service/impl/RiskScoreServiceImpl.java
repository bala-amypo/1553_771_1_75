package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.RiskRule;
import com.example.demo.model.RiskScore;
import com.example.demo.model.Visitor;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.repository.RiskScoreRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.RiskScoreService;
import com.example.demo.util.RiskLevelUtils;

@Service
public class RiskScoreServiceImpl implements RiskScoreService {

    private final RiskScoreRepository riskScoreRepository;
    private final RiskRuleRepository riskRuleRepository;
    private final VisitorRepository visitorRepository;

    public RiskScoreServiceImpl(RiskScoreRepository riskScoreRepository,
                                RiskRuleRepository riskRuleRepository,
                                VisitorRepository visitorRepository) {
        this.riskScoreRepository = riskScoreRepository;
        this.riskRuleRepository = riskRuleRepository;
        this.visitorRepository = visitorRepository;
    }

    @Override
    public RiskScore calculateRiskScore(Long visitorId) {

        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));

        List<RiskRule> rules = riskRuleRepository.findAll();

        int totalScore = 0;
        for (RiskRule rule : rules) {
            totalScore += rule.getWeight();
        }

        String riskLevel = RiskLevelUtils.determineRiskLevel(totalScore);

        RiskScore score = new RiskScore();
        score.setVisitor(visitor);
        score.setScore(totalScore);
        score.setRiskLevel(riskLevel);
        score.setCalculatedAt(LocalDateTime.now());

        return riskScoreRepository.save(score);
    }

    @Override
    public RiskScore getRiskScore(Long id) {
        return riskScoreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Risk score not found"));
    }
}
