package com.example.demo.model;

import java.time.LocalDateTime;

public class ScoreAuditLog {
   private long id;
   private int scoreChange;
   private String reason;
   private LocalDateTime loggedAt;
   public ScoreAuditLog(long id, int scoreChange, String reason, LocalDateTime loggedAt) {
    this.id = id;
    this.scoreChange = scoreChange;
    this.reason = reason;
    this.loggedAt = loggedAt;
   }
   public long getId() {
    return id;
   }
   public void setId(long id) {
    this.id = id;
   }
   public int getScoreChange() {
    return scoreChange;
   }
   public void setScoreChange(int scoreChange) {
    this.scoreChange = scoreChange;
   }
   public String getReason() {
    return reason;
   }
   public void setReason(String reason) {
    this.reason = reason;
   }
   public LocalDateTime getLoggedAt() {
    return loggedAt;
   }
   public void setLoggedAt(LocalDateTime loggedAt) {
    this.loggedAt = loggedAt;
   }
   
}
