package com.appstra.company.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "ROLE_PERMISSION", schema = "TRANSACTIONAL")
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROPE_ID")
    private Integer rolePermissionId;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "PERM_ID", referencedColumnName = "PERM_ID")
    private Permission permission;

    @Column(name = "ROPE_CREATION_DATE")
    private Timestamp rolePermissionCreationDate;

    @Column(name = "ROPE_EDIT_DATE")
    private Timestamp rolePermissionEditionDate;

    @Column(name = "ROPE_EDIT_USER_ID")
    private Integer rolePermissionEditUserID;

}
