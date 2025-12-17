package com.example.demo.service;

import java.util.List;

import com.example.demo.model.VisitLog;

public interface VisitLogService {
    public VisitLog createVisitLog(Long visitorid,VisitLog log);
    public VisitLog getLog(Long id);
    List<VisitLog> getLogsByVisitor(Long visitorId);
}