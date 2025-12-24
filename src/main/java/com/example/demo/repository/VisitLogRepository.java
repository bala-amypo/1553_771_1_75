package com.example.demo.repository;

import com.example.demo.model.VisitLog;

import java.time.LocalDateTime;
import java.util.List;

public interface VisitLogRepository {

    List<VisitLog> findByVisitorSince(Long visitorId, LocalDateTime since);

    Long countVisitsInWindow(
            Long visitorId,
            LocalDateTime start,
            LocalDateTime end
    );
}
