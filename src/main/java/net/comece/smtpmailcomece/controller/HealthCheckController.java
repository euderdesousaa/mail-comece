package net.comece.smtpmailcomece.controller;

import lombok.RequiredArgsConstructor;
import net.comece.smtpmailcomece.service.DatabaseHealthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HealthCheckController {

    private final DatabaseHealthService service;

    @GetMapping("/api/health")
    public ResponseEntity<String> healthCheck() {
        if (service.isDatabaseUp()) {
            return ResponseEntity.ok("OK");
        }else {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Database is down");
        }
    }
}
