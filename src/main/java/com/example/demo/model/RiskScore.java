// package com.example.demo.model;

// import java.time.LocalDateTime;
// import jakarta.persistence.*;

// @Entity
// public class RiskScore {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private int score;
//     private String riskLevel;
//     private LocalDateTime calculatedAt;

//     @ManyToOne
//     private Visitor visitor;

//     public Long getId() {
//         return id;
//     }

//     public int getScore() {
//         return score;
//     }

//     public void setScore(int score) {
//         this.score = score;
//     }

//     public String getRiskLevel() {
//         return riskLevel;
//     }

//     public void setRiskLevel(String riskLevel) {
//         this.riskLevel = riskLevel;
//     }

//     public LocalDateTime getCalculatedAt() {
//         return calculatedAt;
//     }

//     public void setCalculatedAt(LocalDateTime calculatedAt) {
//         this.calculatedAt = calculatedAt;
//     }

//     public Visitor getVisitor() {
//         return visitor;
//     }

//     public void setVisitor(Visitor visitor) {
//         this.visitor = visitor;
//     }
// }
