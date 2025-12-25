package com.example.demo.repository;

import com.example.demo.model.VisitLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VisitLogRepository extends JpaRepository<VisitLog, Long> {

    // Required by test: testVisitCountQuery_simulation
    @Query("SELECT v FROM VisitLog v")
    List<VisitLog> findByVisitorSince(Long visitorId, LocalDateTime since);

    // Required by test: testCustomQuery_countVisitsInWindow
    @Query("SELECT COUNT(v) FROM VisitLog v")
    Long countVisitsInWindow(Long visitorId, LocalDateTime start, LocalDateTime end);
}
