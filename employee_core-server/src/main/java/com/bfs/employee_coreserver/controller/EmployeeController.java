package com.bfs.employee_coreserver.controller;


import com.bfs.employee_coreserver.model.Contact;
import com.bfs.employee_coreserver.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class EmployeeController {
    @Autowired
    private ContactRepository contactRepository;


    @PostMapping("/getContactByUserId")
    public Contact getByUserId(@RequestBody Map<String, String> map) {
        String userId = map.get("userId").toString();
        return contactRepository.findContactByUserId(Integer.parseInt(userId));
    }

    @PostMapping("/getFloatingDayByUserId")
    public LinkedHashMap<String, String> getFloatingDayByUserId(@RequestBody Map<String, String> map) {
        String userId = map.get("userId").toString();
        String floatingDay = contactRepository.findContactByUserId(Integer.parseInt(userId)).getFloatingDay();
        LinkedHashMap<String, String> ans = new LinkedHashMap<>();
        ans.put("floatingDay", floatingDay);
        return ans;
    }

}
