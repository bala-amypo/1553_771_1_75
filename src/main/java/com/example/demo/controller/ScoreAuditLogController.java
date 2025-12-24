package com.example.demo.controller;

import com.example.demo.model.ScoreAuditLog;
import com.example.demo.service.ScoreAuditLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "ScoreAuditLog")
public class ScoreAuditLogController {

    private final ScoreAuditLogService service;

    public ScoreAuditLogController(ScoreAuditLogService service) {
        this.service = service;
    }

    public ResponseEntity<ScoreAuditLog> create(Long visitorId, Long ruleId, ScoreAuditLog log) {
        return ResponseEntity.ok(service.logScoreChange(visitorId, ruleId, log));
    }

    public ResponseEntity<ScoreAuditLog> get(Long id) {
        return ResponseEntity.ok(service.getLog(id));
    }

    public ResponseEntity<List<ScoreAuditLog>> logsByVisitor(Long visitorId) {
        return ResponseEntity.ok(service.getLogsByVisitor(visitorId));
    }
}
