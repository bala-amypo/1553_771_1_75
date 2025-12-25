package com.example.demo.service.impl;
import org.springframework.stereotype.Service;

import com.example.demo.model.RiskScore;
import com.example.demo.service.RiskScoreService;
import com.example.demo.util.RiskLevelUtils;

import java.util.Collections;
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
        Visitor v = visitorRepository.findById(visitorId).orElseThrow();
        RiskScore rs = new RiskScore();
        rs.setVisitor(v);
        rs.setTotalScore(0);
        rs.setRiskLevel("LOW");
        return riskScoreRepository.save(rs);
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
