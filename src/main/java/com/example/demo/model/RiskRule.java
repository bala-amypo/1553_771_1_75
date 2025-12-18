package com.example.demo.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity

@Builder

public class RiskRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String ruleName;

    private String ruleType;
    private Integer threshold;
    private Integer scoreImpact;

    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
