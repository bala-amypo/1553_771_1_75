package com.example.demo.model;

import java.time.LocalDateTime;

public class RiskScore {
    private long id;
    private int totalScore;
    private String riskLevel;
    private LocalDateTime evaluatedAt;
    public RiskScore(long id, int totalScore, String riskLevel, LocalDateTime evaluatedAt) {
        this.id = id;
        this.totalScore = totalScore;
        this.riskLevel = riskLevel;
        this.evaluatedAt = evaluatedAt;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getTotalScore() {
        return totalScore;
    }
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
    public String getRiskLevel() {
        return riskLevel;
    }
    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }
    public LocalDateTime getEvaluatedAt() {
        return evaluatedAt;
    }
    public void setEvaluatedAt(LocalDateTime evaluatedAt) {
        this.evaluatedAt = evaluatedAt;
    }

    
}
