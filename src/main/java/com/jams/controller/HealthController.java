
package com.jams.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    private final JdbcTemplate jdbcTemplate;

    public HealthController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/health")
    public String healthCheck() {
        return "JAMS Backend is running!";
    }

    @GetMapping ("/api/health/db")
    public String databaseHealthCheck() {
        Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
        return "Database connected successfully! Result: " + result;
    }
}
