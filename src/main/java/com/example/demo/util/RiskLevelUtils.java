package com.example.demo.util;

public class RiskLevelUtils {

    public static String getRiskLevel(int score) {
        if (score < 30) {
            return "LOW";
        } else if (score < 70) {
            return "MEDIUM";
        } else {
            return "HIGH";
        }
    }
}
