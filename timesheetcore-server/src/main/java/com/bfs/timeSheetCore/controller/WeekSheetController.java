package com.bfs.timeSheetCore.controller;

import com.bfs.timeSheetCore.model.WeekSheet;
import com.bfs.timeSheetCore.repository.WeekSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class WeekSheetController {
    @Autowired
    private WeekSheetRepository weekSheetRepository;

    @PostMapping("/add")
    public WeekSheet saveWeekSheet(@RequestBody WeekSheet weekSheet){
        return weekSheetRepository.save(weekSheet);
    }

    @PostMapping("/get")
    public List<WeekSheet> getWeekSheetByName(@RequestBody Map<String, String> name){
        System.out.println("I AM HERERRRRRRRRRRRRRRRR");
        return weekSheetRepository.findByUserName(name.get("name"));
    }

    @PostMapping("/update")
    public WeekSheet getWeekSheetBy(@RequestBody WeekSheet weekSheet){
//        WeekSheet update = weekSheetRepository.findByUserNameAndWeekEnding(weekSheet.getUserName(), weekSheet.getWeekEnding());
        return weekSheetRepository.save(weekSheet);
    }
}
