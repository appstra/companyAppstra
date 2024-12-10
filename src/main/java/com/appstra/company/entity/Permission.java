package com.appstra.company.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PERMISSION", schema = "PARAMETERIZATION")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERM_ID")
    private Integer permissionId;

    @Column(name = "PERM_NAME")
    private String permissionName;

    @Column(name = "PERM_DESCRIPTION")
    private String permissionDescription;

    @Column(name = "PERM_CREATION_DATE")
    private Integer permissionCreationDate;

    @Column(name = "PERM_EDIT_DATE")
    private Integer permissionEditionDate;

    @Column(name = "PERM_EDIT_USER_ID")
    private Integer permissionEditUserID;

}
