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
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "description")
    private String description;

    @Column(name = "create_date")
    private Timestamp createDate;

    @Column(name = "modification_date")
    private String modificationDate;

    @Column(name = "last_modification_user")
    private int lastModificationUser;

    @OneToMany(mappedBy = "roleId", fetch = FetchType.EAGER)
    private Set<UserRole> userRoles = new HashSet<>();

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", modificationDate='" + modificationDate + '\'' +
                ", lastModificationUser=" + lastModificationUser +
                '}';
    }
}
