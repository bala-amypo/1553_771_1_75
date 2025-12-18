package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.RiskRule;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.service.RiskRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskRuleServiceImpl implements RiskRuleService {

    private final RiskRuleRepository repo;

    public RiskRuleServiceImpl(RiskRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public RiskRule createRule(RiskRule rule) {

        if (repo.existsByRuleName(rule.getRuleName())) {
            throw new BadRequestException(
                    "Rule name must be unique");
        }

        if (rule.getScoreImpact() < 0)
            throw new BadRequestException("score must be non-negative");

        return repo.save(rule);
    }

    @Override
    public RiskRule getRule(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new BadRequestException("Rule not found"));
    }

    @Override
    public List<RiskRule> getAllRules() {
        return repo.findAll();
    }
}
