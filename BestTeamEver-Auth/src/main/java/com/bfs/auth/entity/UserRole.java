package com.bfs.auth.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private int userRoleId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role roleId;

    @Column(name = "active_flag")
    private String activeFlag;

    @Column(name = "create_date")
    private Timestamp createDate;

    @Column(name = "modification_date")
    private String modificationDate;

    @Column(name = "last_modification_user")
    private int lastModificationUser;
}
