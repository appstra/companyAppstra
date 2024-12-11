package com.appstra.company.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

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
    private Timestamp permissionCreationDate;

    @Column(name = "PERM_EDIT_DATE")
    private Timestamp permissionEditionDate;

    @Column(name = "PERM_EDIT_USER_ID")
    private Integer permissionEditUserID;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "permission")
    private List<RolePermission> roleList;

}
