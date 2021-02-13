package com.bfs.employee_server.client;

import com.bfs.employee_server.domain.Contact;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.util.Map;

@FeignClient(name = "employee-core", fallbackFactory = EmployeeFallbackFactory.class)
public interface EmployeeClient {
    @RequestLine("GET")
    @RequestMapping("/movie/message")
    ResponseEntity<String> getMessage();

    @RequestMapping(method = RequestMethod.POST, value = "/get", produces = "application/json")
    List<Contact> getContact(Map<String, String> name);

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    Contact updateContact(Contact contact);

}
