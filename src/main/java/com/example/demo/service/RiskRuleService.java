package com.example.demo.service;

import java.util.List;

import com.example.demo.model.RiskRule;

public interface RiskRuleService {
    public RiskRule creatRule(RiskRule rule);
    public List<RiskRule> getAllRules();
    public RiskRule getRule(long id);

    
}
