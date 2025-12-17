package com.example.demo.model;

import java.time.LocalDateTime;

public class Visitor {
   
    public long id;
    private String fullName;
    private String  email;
    private String  phone;
    private String  idProof;
    private LocalDateTime createdAt;
    public Visitor(long id, String fullName, String email, String phone, String idProof, LocalDateTime createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.idProof = idProof;
        this.createdAt = createdAt;
    }
    public long getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public String getIdProof() {
        return idProof;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setIdProof(String idProof) {
        this.idProof = idProof;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
}
