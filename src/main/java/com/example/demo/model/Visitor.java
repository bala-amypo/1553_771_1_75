package com.example.demo.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "visitors")

@Builder
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String phone;
    private String idProof;

    private LocalDateTime createdAt;

    @PrePersist
    private void assignTimestamp() {
        this.createdAt = LocalDateTime.now();
    }
}
