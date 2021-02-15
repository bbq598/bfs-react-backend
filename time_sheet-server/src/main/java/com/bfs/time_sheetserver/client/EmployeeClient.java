package com.bfs.time_sheetserver.client;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedHashMap;
import java.util.Map;

@FeignClient(name = "employee-core", fallbackFactory = EmployeeFallbackFactory.class)
public interface EmployeeClient {
    @RequestLine("GET")
    @RequestMapping("/movie/message")
    ResponseEntity<String> getMessage();


    @RequestMapping(method = RequestMethod.POST, value = "/getFloatingDayByUserId", produces = "application/json")
    LinkedHashMap<String, String> getFloatingDayByUserId(Map<String, String> map);


}
