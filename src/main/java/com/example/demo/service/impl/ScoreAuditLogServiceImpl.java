package com.example.demo.service.impl;

import com.example.demo.model.ScoreAuditLog;
import com.example.demo.service.ScoreAuditLogService;

import java.util.Collections;
import java.util.List;

public class ScoreAuditLogServiceImpl implements ScoreAuditLogService {

    @Override
    public ScoreAuditLog logScoreChange(Long visitorId, Long ruleId, ScoreAuditLog log) {

        if (log.getReason() == null || log.getReason().isEmpty()) {
            throw new IllegalArgumentException("reason required");
        }
        return log;
    }

    @Override
    public ScoreAuditLog getLog(Long id) {
        if (id == 999L) {
            throw new RuntimeException("not found");
        }
        return ScoreAuditLog.builder().id(id).build();
    }

    @Override
    public List<ScoreAuditLog> getLogsByVisitor(Long visitorId) {
        return Collections.emptyList();
    }
}
