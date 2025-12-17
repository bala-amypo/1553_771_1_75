package com.example.demo.service;

import java.util.List;

import com.example.demo.model.RiskScore;

public interface RiskScoreService {
    public RiskScore evaluateVisitor(Long visitorId); 
    public RiskScore getScoreForVisitor(Long visitorid);
    public List<RiskScore> getAllRules();

}