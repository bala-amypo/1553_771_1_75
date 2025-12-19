package com.example.demo.repository;

import com.example.demo.model.VisitLog;
import com.example.demo.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitLogRepository extends JpaRepository<VisitLog, Long> {

    List<VisitLog> findByVisitor(Visitor visitor);
}
