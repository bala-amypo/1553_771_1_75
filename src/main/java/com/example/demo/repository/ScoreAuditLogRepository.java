package com.example.demo.repository;

import com.example.demo.model.ScoreAuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreAuditLogRepository extends JpaRepository<ScoreAuditLog, Long> {
}
