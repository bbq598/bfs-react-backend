package com.bfs.auth.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "person_id")
    private String personId;

    @Column(name = "create_date")
    private Timestamp createDate;

    @Column(name = "modification_date")
    private Timestamp modificationDate;

    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
    private Set<UserRole> userRoles = new HashSet<>();

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", personId='" + personId + '\'' +
                ", createDate=" + createDate +
                ", modificationDate=" + modificationDate +
                '}';
    }
}
