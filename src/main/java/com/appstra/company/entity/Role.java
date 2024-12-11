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
@Table(name = "ROLE", schema = "PARAMETERIZATION")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Integer roleId;
    @Column(name = "ROLE_NAME")
    private String roleName;
    @Column(name = "ROLE_DESCRIPTION")
    private String roleDescription;
    @Column(name = "ROLE_CREATION_DATE")
    private Timestamp roleCreationDate;
    @Column(name = "ROLE_EDIT_DATE")
    private Timestamp roleEditionDate;
    @Column(name = "ROLE_EDIT_USER_ID")
    private Integer roleEditUserID;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "TYRO_ID", referencedColumnName = "TYRO_ID")
    private TypeRoles typeRoles;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "COMP_ID", referencedColumnName = "COMP_ID")
    private Company company;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "role")
    private List<RolePermission> roleList;
}
