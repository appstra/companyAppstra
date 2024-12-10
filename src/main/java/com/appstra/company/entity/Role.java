package com.appstra.company.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private Integer roleName;
    @Column(name = "ROLE_DESCRIPTION")
    private Integer roleDescription;
    @Column(name = "ROLE_CREATION_DATE")
    private Integer roleCreationDate;
    @Column(name = "ROLE_EDIT_DATE")
    private Integer roleEditionDate;
    @Column(name = "ROLE_EDIT_USER_ID")
    private Integer roleEditUserID;

    @ManyToOne
    @JoinColumn(name = "TYRO_ID", referencedColumnName = "TYRO_ID")
    private TypeRoles typeRoles;
    @ManyToOne
    @JoinColumn(name = "COMP_ID", referencedColumnName = "COMP_ID")
    private Company company;
}
