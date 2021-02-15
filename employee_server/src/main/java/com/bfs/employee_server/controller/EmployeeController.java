package com.bfs.employee_server.controller;

import com.bfs.employee_server.client.EmployeeClient;
import com.bfs.employee_server.config.CloudConfig;
import com.bfs.employee_server.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private CloudConfig cloudConfig;

    @Autowired
    private EmployeeClient employeeClient;

    @GetMapping("/message")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok("Message from " + cloudConfig.getUserRole()  );
    }


    @PostMapping("/getContactByUserId")
    public Contact getContactByUserId(@RequestBody Map<String, String> map) {
        return employeeClient.getContactByUserId(map);
    }

    @PostMapping("getFloatingDayByUserId")
    public String getFloatingDayByUserId(@RequestBody Map<String, String> map) {
        return employeeClient.getFloatingDayByUserId(map);
    }

    @PostMapping("updateContactById")
    public Contact updateContactById(@RequestBody Map<String, String> map) {
        System.out.println("server-controller");
        return employeeClient.updateContactById(map);
    }
}
