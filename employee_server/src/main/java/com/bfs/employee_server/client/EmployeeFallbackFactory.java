package com.bfs.employee_server.client;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class EmployeeFallbackFactory implements FallbackFactory<EmployeeClient> {
    @Override
    public EmployeeClient create(Throwable throwable) {
        return new EmployeeFallback(throwable);
    }
}
