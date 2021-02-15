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
        Integer floatingDay = contactRepository.findContactByUserId(Integer.parseInt(userId)).getFloatingDay();
        LinkedHashMap<String, String> ans = new LinkedHashMap<>();
        ans.put("floatingDay", floatingDay.toString());
        return ans;
    }

    @PostMapping("/updateContactById")
    public Contact updateContactById(@RequestBody Map<String, String> map) {
        Integer update = contactRepository.updateContactById(
                map.get("phone"), map.get("email"), map.get("homeAddress"),
                map.get("ec1FirstName"), map.get("ec1LastName"), map.get("ec1Phone"),
                map.get("ec2FirstName"), map.get("ec2LastName"), map.get("ec2Phone"),
                Integer.parseInt(map.get("floatingDay")), Integer.parseInt(map.get("userId")));
        return contactRepository.findContactByUserId(Integer.parseInt(map.get("userId")));
    }
}
