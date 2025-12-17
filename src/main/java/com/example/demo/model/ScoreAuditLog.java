// package com.example.demo.model;

// import jakarta.persistence.*;

// import java.time.LocalDateTime;

// @Entity

// @Builder

// public class ScoreAuditLog {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     private Visitor visitor;

//     @ManyToOne
//     private RiskRule appliedRule;

//     private Integer scoreChange;
//     private String reason;

//     private LocalDateTime loggedAt;

//     @PrePersist
//     void logNow() {
//         loggedAt = LocalDateTime.now();
//     }
// }
