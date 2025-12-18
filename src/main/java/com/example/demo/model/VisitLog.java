package com.example.demo.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Visitor visitor;

    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    private String purpose;
    private String location;

    @PrePersist
    void initEntryTime() {
        if (entryTime == null) {
            entryTime = LocalDateTime.now();
        }
    }
}
