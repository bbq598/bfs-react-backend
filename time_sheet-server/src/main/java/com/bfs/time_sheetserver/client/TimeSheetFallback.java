package com.bfs.time_sheetserver.client;


import com.bfs.time_sheetserver.domain.WeekSheet;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public class TimeSheetFallback implements TimeSheetClient{

    private final Throwable cause;

    public TimeSheetFallback(Throwable cause) {
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
    public List<WeekSheet> getTimeSheet(Map<String, String> name) {
        return null;
    }

    @Override
    public WeekSheet updateWeekSheet(WeekSheet weekSheet) {
        return null;
    }

}
