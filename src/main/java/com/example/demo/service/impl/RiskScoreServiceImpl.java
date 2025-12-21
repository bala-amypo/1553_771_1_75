package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskRule;
import com.example.demo.model.RiskScore;
import com.example.demo.model.Visitor;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.repository.RiskScoreRepository;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.RiskScoreService;
import com.example.demo.util.RiskLevelUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RiskScoreServiceImpl implements RiskScoreService {

    private final RiskScoreRepository riskScoreRepository;
    private final VisitorRepository visitorRepository;
    private final RiskRuleRepository riskRuleRepository;
    private final VisitLogRepository visitLogRepository;

    // ✅ Constructor Injection
    public RiskScoreServiceImpl(RiskScoreRepository riskScoreRepository,
                                VisitorRepository visitorRepository,
                                RiskRuleRepository riskRuleRepository,
                                VisitLogRepository visitLogRepository) {
        this.riskScoreRepository = riskScoreRepository;
        this.visitorRepository = visitorRepository;
        this.riskRuleRepository = riskRuleRepository;
        this.visitLogRepository = visitLogRepository;
    }

    @Override
    public RiskScore evaluateVisitor(Long visitorId) {

        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));

        int totalScore = 0;

        // Fetch all rules
        List<RiskRule> rules = riskRuleRepository.findAll();

        for (RiskRule rule : rules) {

            // 🔹 FREQUENT VISITS RULE
            if ("FREQUENT_VISITS".equalsIgnoreCase(rule.getRuleType())) {
                long visitCount = visitLogRepository.countByVisitorId(visitorId);
                if (visitCount >= rule.getThreshold()) {
                    totalScore += rule.getScoreImpact();
                }
            }

            // 🔹 AFTER HOURS RULE (basic demo logic)
            if ("AFTER_HOURS".equalsIgnoreCase(rule.getRuleType())) {
                totalScore += rule.getScoreImpact();
            }
        }

        // Either update existing score or create new one
        RiskScore score = riskScoreRepository
                .findByVisitorId(visitorId)
                .orElse(RiskScore.builder().visitor(visitor).build());

        score.setTotalScore(totalScore);
        score.setRiskLevel(RiskLevelUtils.determineRiskLevel(totalScore));
        score.setEvaluatedAt(LocalDateTime.now());

        return riskScoreRepository.save(score);
    }

    @Override
    public RiskScore getScoreForVisitor(Long visitorId) {
        return riskScoreRepository.findByVisitorId(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Risk score not found"));
    }

    @Override
    public List<RiskScore> getAllScores() {
        return riskScoreRepository.findAll();
    }
}
