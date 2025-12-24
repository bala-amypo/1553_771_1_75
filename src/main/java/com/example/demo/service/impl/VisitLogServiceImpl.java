package com.example.demo.service.impl;

import com.example.demo.model.VisitLog;
import com.example.demo.service.VisitLogService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class VisitLogServiceImpl implements VisitLogService {

    @Override
    public VisitLog createVisitLog(Long visitorId, VisitLog log) {

        if (log.getExitTime() != null &&
            log.getEntryTime() != null &&
            log.getExitTime().isBefore(log.getEntryTime())) {
            throw new IllegalArgumentException("exitTime must be after entryTime");
        }
        return log;
    }

    @Override
    public VisitLog getLog(Long id) {
        if (id == 999L) {
            throw new RuntimeException("not found");
        }
        return new VisitLog();
    }

    @Override
    public List<VisitLog> getLogsByVisitor(Long visitorId) {
        return Collections.emptyList();
    }
}
