package com.bfs.employee_coreserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@Entity
@Getter
@Table(name = "contact_information")
public class Contact implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer ID;
    @Column(name = "userid")
    private Integer userId;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "homeaddress")
    private String homeAddress;
    @Column(name = "emergencycontact1firstname")
    private String ec1FirstName;
    @Column(name = "emergencycontact1lastname")
    private String ec1LastName;
    @Column(name = "emergencycontact1phone")
    private String ec1Phone;
    @Column(name = "emergencycontact2firstname")
    private String ec2FirstName;
    @Column(name = "emergencycontact2lastname")
    private String ec2LastName;
    @Column(name = "emergencycontact2phone")
    private String ec2Phone;
    @Column(name = "floatingday")
    private Integer floatingDay;

}
