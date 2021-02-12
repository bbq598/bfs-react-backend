package com.bfs.time_sheetserver.client;

import com.bfs.time_sheetserver.domain.WeekSheet;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.util.Map;

@FeignClient(name = "timesheet-core", fallbackFactory = TimeSheetFallbackFactory.class)
public interface TimeSheetClient {
    @RequestLine("GET")
    @RequestMapping("/movie/message")
    ResponseEntity<String> getMessage();

    @RequestMapping(method = RequestMethod.POST, value = "/get", produces = "application/json")
    List<WeekSheet> getTimeSheet(Map<String, String> name);

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    WeekSheet updateWeekSheet(WeekSheet weekSheet);

}
