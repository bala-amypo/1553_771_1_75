package com.example.demo.repository;

import com.example.demo.model.VisitLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VisitLogRepository extends JpaRepository<VisitLog, Long> {

    // REQUIRED by test: testVisitCountQuery_simulation
    List<VisitLog> findByVisitorSince(Long visitorId, LocalDateTime since);

    // REQUIRED by test: testCustomQuery_countVisitsInWindow
    Long countVisitsInWindow(Long visitorId, LocalDateTime start, LocalDateTime end);
}
