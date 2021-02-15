package com.bfs.time_sheetserver.client;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.Map;

public class EmployeeFallback implements EmployeeClient{

    private final Throwable cause;

    public EmployeeFallback(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public ResponseEntity<String> getMessage() {
        if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
            // Treat the HTTP 404 status
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Message From Fall back:: Not Found");
        }

        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Message Found :: other");
    }


    @Override
    public LinkedHashMap<String, String> getFloatingDayByUserId(Map<String, String> map) {
        return null;
    }



}
