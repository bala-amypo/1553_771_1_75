package com.example.demo.model;

import java.time.LocalDateTime;

public class RiskRule {
    private long id;
    private String ruleName;
    private int Threshold;
    private int scoreImpact;
    private LocalDateTime createdAt;
    public RiskRule(long id, String ruleName, int threshold, int scoreImpact, LocalDateTime createdAt) {
        this.id = id;
        this.ruleName = ruleName;
        Threshold = threshold;
        this.scoreImpact = scoreImpact;
        this.createdAt = createdAt;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getRuleName() {
        return ruleName;
    }
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
    public int getThreshold() {
        return Threshold;
    }
    public void setThreshold(int threshold) {
        Threshold = threshold;
    }
    public int getScoreImpact() {
        return scoreImpact;
    }
    public void setScoreImpact(int scoreImpact) {
        this.scoreImpact = scoreImpact;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
}
