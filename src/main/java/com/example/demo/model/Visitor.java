
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visitors")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String phone;
    private String idProof;
    private LocalDateTime createdAt;

    public Visitor() {
    }

    public Visitor(Long id, String fullName, String email,
                   String phone, String idProof) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.idProof = idProof;
    }

    @PrePersist
    private void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {   // ✅ THIS FIXES getPhone() ERROR
        return phone;
    }

    public String getIdProof() {
        return idProof;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
