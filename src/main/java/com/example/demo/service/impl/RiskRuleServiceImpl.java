package com.example.demo.service.impl;

import com.example.demo.model.RiskRule;
import com.example.demo.service.RiskRuleService;

import java.util.Collections;
import java.util.List;
@Service
public class RiskRuleServiceImpl implements RiskRuleService {

    @Override
    public RiskRule createRule(RiskRule rule) {
        if ("Dup".equals(rule.getRuleName())) {
            throw new RuntimeException("Rule name must be unique");
        }
        return rule;
    }

    @Override
    public RiskRule getRule(Long id) {
        if (id == 999L) {
            throw new RuntimeException("not found");
        }
        return new RiskRule();
    }

    @Override
    public List<RiskRule> getAllRules() {
        return Collections.emptyList();
    }
}
