package com.example.demo.controller;

import com.example.demo.model.VisitLog;
import com.example.demo.service.VisitLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visit-logs")
public class VisitLogController {

    private final VisitLogService visitLogService;

    public VisitLogController(VisitLogService visitLogService) {
        this.visitLogService = visitLogService;
    }

    @PostMapping("/{visitorId}")
    public VisitLog createLog(
            @PathVariable Long visitorId,
            @RequestBody VisitLog log) {
        return visitLogService.createLog(visitorId, log);
    }

    @GetMapping("/visitor/{visitorId}")
    public List<VisitLog> getLogsForVisitor(@PathVariable Long visitorId) {
        return visitLogService.getLogsForVisitor(visitorId);
    }

    @GetMapping("/{id}")
    public VisitLog getLog(@PathVariable Long id) {
        return visitLogService.getLog(id);
    }
}
