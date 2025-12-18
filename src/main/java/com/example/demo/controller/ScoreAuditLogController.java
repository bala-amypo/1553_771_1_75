package com.example.demo.controller;

import com.example.demo.model.ScoreAuditLog;
import com.example.demo.service.ScoreAuditLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/score-logs")
public class ScoreAuditLogController {

    private final ScoreAuditLogService auditLogService;

    public ScoreAuditLogController(ScoreAuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @PostMapping("/{visitorId}/{ruleId}")
    public ScoreAuditLog createLog(
            @PathVariable Long visitorId,
            @PathVariable Long ruleId,
            @RequestBody ScoreAuditLog log) {
        return auditLogService.createLog(visitorId, ruleId, log);
    }

    @GetMapping("/visitor/{visitorId}")
    public List<ScoreAuditLog> getLogsForVisitor(@PathVariable Long visitorId) {
        return auditLogService.getLogsForVisitor(visitorId);
    }

    @GetMapping("/{id}")
    public ScoreAuditLog getLog(@PathVariable Long id) {
        return auditLogService.getLog(id);
    }
}
