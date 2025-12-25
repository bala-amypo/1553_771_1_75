package com.example.demo.service.impl;

import com.example.demo.model.RiskScore;
import com.example.demo.model.Visitor;
import com.example.demo.repository.RiskScoreRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.RiskScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskScoreServiceImpl implements RiskScoreService {

    private final RiskScoreRepository riskScoreRepository;
    private final VisitorRepository visitorRepository;

    public RiskScoreServiceImpl(RiskScoreRepository riskScoreRepository,
                                VisitorRepository visitorRepository) {
        this.riskScoreRepository = riskScoreRepository;
        this.visitorRepository = visitorRepository;
    }

    @Override
    public RiskScore evaluateVisitor(Long visitorId) {
        Visitor visitor = visitorRepository.findById(visitorId).orElseThrow();
        RiskScore score = new RiskScore();
        score.setVisitor(visitor);
        score.setTotalScore(0);
        score.setRiskLevel("LOW");
        return riskScoreRepository.save(score);
    }

    @Override
    public RiskScore getScoreForVisitor(Long visitorId) {
        return riskScoreRepository.findAll()
                .stream()
                .filter(r -> r.getVisitor() != null &&
                             r.getVisitor().getId().equals(visitorId))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public List<RiskScore> getAllScores() {
        return riskScoreRepository.findAll();
    }
}
