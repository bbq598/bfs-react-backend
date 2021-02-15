package com.bfs.employee_server.client;

import com.bfs.employee_server.domain.Contact;
import feign.FeignException;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public Contact getContactByUserId(Map<String, String> map) {
        return null;
    }

    @Override
    public String getFloatingDayByUserId(Map<String, String> map) {
        return null;
    }

    @Override
    public Contact updateContactById(Contact contact) {
        return null;
    }

}
