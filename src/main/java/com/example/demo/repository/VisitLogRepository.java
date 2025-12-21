package com.example.demo.repository;

import com.example.demo.model.VisitLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitLogRepository extends JpaRepository<VisitLog, Long> {

    // ✅ ADD THIS METHOD
    long countByVisitorId(Long visitorId);
}
