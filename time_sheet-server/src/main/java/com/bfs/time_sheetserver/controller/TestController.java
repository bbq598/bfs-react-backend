package com.bfs.time_sheetserver.controller;

import com.bfs.time_sheetserver.client.TimeSheetClient;
import com.bfs.time_sheetserver.config.CloudConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private CloudConfig cloudConfig;

    @Autowired
    private TimeSheetClient timeSheetClient;

    @GetMapping("/message")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok("Message from " + cloudConfig.getUserRole()  );
    }

    @GetMapping("/message2")
    public ResponseEntity<String> getMessageFromTest() {
        return timeSheetClient.getMessage();
    }


}
