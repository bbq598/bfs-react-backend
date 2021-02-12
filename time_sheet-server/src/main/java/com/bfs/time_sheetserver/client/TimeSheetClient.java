package com.bfs.time_sheetserver.client;

import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "movie-store", fallbackFactory = TimeSheetFallbackFactory.class)
public interface TimeSheetClient {
    @RequestLine("GET")
    @RequestMapping("/movie/message")
    ResponseEntity<String> getMessage();
}
