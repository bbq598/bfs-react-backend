package com.bfs.time_sheetserver.controller;

import com.bfs.time_sheetserver.client.EmployeeClient;
import com.bfs.time_sheetserver.client.TimeSheetClient;
import com.bfs.time_sheetserver.config.CloudConfig;
import com.bfs.time_sheetserver.domain.WeekSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/time")
public class TimeSheetController {
    @Autowired
    private CloudConfig cloudConfig;

    @Autowired
    private TimeSheetClient timeSheetClient;

    @Autowired
    private EmployeeClient employeeClient;

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
        Map id = new HashMap();
        id.put("userId", "1");
        LinkedHashMap<String, String> floatid = employeeClient.getFloatingDayByUserId(id);
        System.out.println(floatid.get("floatingDay"));
        System.out.println(floatid);
        List<WeekSheet> data= timeSheetClient.getTimeSheet(name);
        System.out.println(data.toString());
    }

    @PostMapping("/getTimeSheet")
    public List<WeekSheet> getTimeSheet(HttpServletRequest request){
        System.out.println("username: " + request.getAttribute("username"));
        System.out.println("userId: " + request.getAttribute("userId"));
        Map name = new HashMap();
        name.put("name",request.getAttribute("username"));
        List<WeekSheet> weekSheets = timeSheetClient.getTimeSheet(name);
        Map id = new HashMap();
        id.put("userId", request.getAttribute("userId"));
        LinkedHashMap<String, String> floatid = employeeClient.getFloatingDayByUserId(id);
        for (int i = 0; i < weekSheets.size(); i++) {
            weekSheets.get(i).setFloatingDay();
            weekSheets.get(i).setFloatDayLeft(Integer.parseInt(floatid.get("floatingDay")));
        }
        return weekSheets;
    }


    @PostMapping("/updateWeekSheet")
    public WeekSheet updateWeekSheet(@RequestBody WeekSheet weekSheet) {
        return timeSheetClient.updateWeekSheet(weekSheet);
    }

    @PostMapping("/setDefault")
    public WeekSheet addDefault(@RequestBody WeekSheet weekSheet) {
        return timeSheetClient.addDefault(weekSheet);
    }


    @PostMapping("getFloatingDayByUserId")
    public LinkedHashMap<String, String> getFloatingDayByUserId(@RequestBody Map<String, String> map) {
        return employeeClient.getFloatingDayByUserId(map);
    }
}
