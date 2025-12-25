package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "visit_logs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many logs belong to one visitor
    @ManyToOne
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;

    private String purpose;

    private String location;

    private LocalDateTime entryTime;

    private LocalDateTime exitTime;

    /**
     * REQUIRED BY TEST:
     * testVisitLog_entryAutoNow_ifNull
     *
     * If entryTime is null, it must be auto-set
     */
    @PrePersist
    public void prePersist() {
        if (this.entryTime == null) {
            this.entryTime = LocalDateTime.now();
        }
    }
}
