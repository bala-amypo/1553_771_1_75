// package com.example.demo.service.impl;

// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.VisitLog;
// import com.example.demo.model.Visitor;
// import com.example.demo.repository.VisitLogRepository;
// import com.example.demo.repository.VisitorRepository;
// import com.example.demo.service.VisitLogService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class VisitLogServiceImpl implements VisitLogService {

//     private final VisitLogRepository logRepo;
//     private final VisitorRepository visitorRepo;

//     public VisitLogServiceImpl(VisitLogRepository logRepo,
//                                VisitorRepository visitorRepo) {
//         this.logRepo = logRepo;
//         this.visitorRepo = visitorRepo;
//     }

//     @Override
//     public VisitLog createVisitLog(Long visitorId, VisitLog log) {

//         Visitor visitor = visitorRepo.findById(visitorId)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Visitor not found"));

//         if (log.getExitTime() != null &&
//             log.getExitTime().isBefore(log.getEntryTime())) {
//             throw new BadRequestException(
//                     "exitTime must be after entryTime");
//         }

//         log.setVisitor(visitor);
//         return logRepo.save(log);
//     }

//     @Override
//     public VisitLog getLog(Long id) {
//         return logRepo.findById(id)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("VisitLog not found"));
//     }

//     @Override
//     public List<VisitLog> getLogsByVisitor(Long visitorId) {
//         return logRepo.findByVisitorId(visitorId);
//     }
// }
