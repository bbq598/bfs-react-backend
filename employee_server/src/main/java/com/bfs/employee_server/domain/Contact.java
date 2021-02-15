package com.bfs.employee_server.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Contact {
    private Integer ID;
    private Integer userId;
    private String phone;
    private String email;
    private String homeAddress;
    private String ec1FirstName;
    private String ec1LastName;
    private String ec1Phone;
    private String ec2FirstName;
    private String ec2LastName;
    private String ec2Phone;
    private String floatingDay;

}