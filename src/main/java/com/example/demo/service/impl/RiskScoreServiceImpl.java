package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskScore;
import com.example.demo.model.Visitor;
import com.example.demo.repository.RiskScoreRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.RiskScoreService;
import com.example.demo.util.RiskLevelUtils;
import org.springframework.stereotype.Service;

@Service
public class RiskScoreServiceImpl implements RiskScoreService {

    private final RiskScoreRepository scoreRepo;
    private final VisitorRepository visitorRepo;

    public RiskScoreServiceImpl(RiskScoreRepository scoreRepo,
                                VisitorRepository visitorRepo) {
        this.scoreRepo = scoreRepo;
        this.visitorRepo = visitorRepo;
    }

    @Override
    public RiskScore evaluateVisitor(Long visitorId) {

        Visitor v = visitorRepo.findById(visitorId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Visitor not found"));

        int computedScore = (int) (Math.random() * 100);
        String level = RiskLevelUtils.determineRiskLevel(computedScore);

        RiskScore score = RiskScore.builder()
                .visitor(v)
                .totalScore(computedScore)
                .riskLevel(level)
                .build();

        return scoreRepo.save(score);
    }

    @Override
    public RiskScore getScoreForVisitor(Long visitorId) {
        return scoreRepo.findByVisitorId(visitorId);
    }

    @Override
    public java.util.List<RiskScore> getAllScores() {
        return scoreRepo.findAll();
    }
}
