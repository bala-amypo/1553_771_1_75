package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RiskScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    private Visitor visitor;

    private Integer totalScore;
    private String riskLevel;

    private LocalDateTime evaluatedAt;

    @PrePersist
    void stampEvaluation() {
        evaluatedAt = LocalDateTime.now();
    }
}
