package com.bfs.time_sheetserver.controller;

import com.bfs.time_sheetserver.client.TimeSheetClient;
import com.bfs.time_sheetserver.config.CloudConfig;
import com.bfs.time_sheetserver.domain.WeekSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/time")
public class TimeSheetController {
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

    @GetMapping("/getTimeSheet2")
    public void getTimeSheet(){
        Map name = new HashMap();
        name.put("name", "tiger");
        List<WeekSheet> data= timeSheetClient.getTimeSheet(name);
        System.out.println(data.toString());
    }

    @PostMapping("/getTimeSheet")
    public List<WeekSheet> getTimeSheet(@RequestBody Map<String, String> name){
        List<WeekSheet> weekSheets = timeSheetClient.getTimeSheet(name);
        for (int i = 0; i < weekSheets.size(); i++) {
            weekSheets.get(i).setFloatingDay();
        }
        return weekSheets;
    }

    @PostMapping("/updateWeekSheet")
    public WeekSheet updateWeekSheet(@RequestBody WeekSheet weekSheet) {
        return timeSheetClient.updateWeekSheet(weekSheet);
    }
}
