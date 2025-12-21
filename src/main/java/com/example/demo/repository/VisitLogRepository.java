package com.example.demo.repository;

import com.example.demo.model.VisitLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface VisitLogRepository extends JpaRepository<VisitLog, Long> {

    // Get all logs for a visitor
    List<VisitLog> findByVisitorId(Long visitorId);

    // Get logs after a specific time
    List<VisitLog> findByVisitorIdAndEntryTimeAfter(
            Long visitorId,
            LocalDateTime since
    );

    // Count visits in a time window (advanced use)
    long countByVisitorIdAndEntryTimeBetween(
            Long visitorId,
            LocalDateTime start,
            LocalDateTime end
    );

    // ✅ REQUIRED for RiskScoreServiceImpl
    long countByVisitorId(Long visitorId);
}
