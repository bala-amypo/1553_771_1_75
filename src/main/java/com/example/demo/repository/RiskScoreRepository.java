package com.example.demo.repository;

import com.example.demo.model.RiskScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiskScoreRepository extends JpaRepository<RiskScore, Long> {
}
