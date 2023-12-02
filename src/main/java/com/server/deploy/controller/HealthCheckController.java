package com.server.deploy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthCheckController {

    // 기본 제공되는 컨트롤러. 서버로부터 요청이 잘 오는지 확인하는 컨트롤러.
    @Value("${serverName}")
    private String serverName; // 현재 가동중인 서버를 확인하기 위함(yml의 serverName_
    @Value("${server.env}")
    private String env;
    private Integer visitedCount = 0;
    @GetMapping("/hc")
    public ResponseEntity<?> healthCheck() {
        visitedCount++;
        Map<String, Object> healthCheckData = new HashMap<>();

        healthCheckData.put("serverName",serverName);
        healthCheckData.put("actor", "주성광");
        healthCheckData.put("env",env);
        healthCheckData.put("visitedCount",visitedCount);

        return ResponseEntity.ok(healthCheckData);
    }

    @GetMapping("/env")
    public ResponseEntity<String> getEnv() {
        return ResponseEntity.ok(env);
    }
}