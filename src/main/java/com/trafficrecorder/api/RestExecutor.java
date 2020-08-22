package com.trafficrecorder.api;

import org.springframework.http.ResponseEntity;

@FunctionalInterface
public interface RestExecutor {
    String BASE_URL = "/api";

    public ResponseEntity<Object> execute();
}
