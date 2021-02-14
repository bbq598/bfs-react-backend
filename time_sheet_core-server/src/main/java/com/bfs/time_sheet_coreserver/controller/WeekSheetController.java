package com.bfs.time_sheet_coreserver.controller;

import com.bfs.time_sheet_coreserver.model.WeekSheet;
import com.bfs.time_sheet_coreserver.repository.WeekSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
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
        List<WeekSheet> list =  weekSheetRepository.findByUserName(name.get("name"));
        list.removeIf(p -> p.getIsDefault()!=null&&p.getIsDefault()==true);
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }

    @PostMapping("get/default")
    public WeekSheet getDefaultByName(@RequestBody Map<String, String> name){
        WeekSheet weekSheet = weekSheetRepository.findFirst1ByUserNameAndIsDefault(name.get("name"), true);
        return weekSheet!=null ? weekSheet : weekSheetRepository.findFirst1ByUserNameAndIsDefault("default", true);
    }

    @PostMapping("add/default")
    public WeekSheet addDefaultBySheet(@RequestBody WeekSheet weekSheet){
        WeekSheet oldDefault = weekSheetRepository.findFirst1ByUserNameAndIsDefault(weekSheet.getUserName(), true);
        if(oldDefault!=null) weekSheetRepository.delete(oldDefault);
        weekSheet.setIsDefault(true);
        weekSheet.setId(null);
        return weekSheetRepository.save(weekSheet);
    }


    @PostMapping("/update")
    public WeekSheet getWeekSheetBy(@RequestBody WeekSheet weekSheet){
//        WeekSheet update = weekSheetRepository.findByUserNameAndWeekEnding(weekSheet.getUserName(), weekSheet.getWeekEnding());
        return weekSheetRepository.save(weekSheet);
    }
}
