package com.bfs.time_sheetserver.client;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class TimeSheetFallbackFactory implements FallbackFactory<TimeSheetClient> {
    @Override
    public TimeSheetClient create(Throwable throwable) {
        return new TimeSheetFallback(throwable);
    }
}
