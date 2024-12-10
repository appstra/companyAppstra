package com.appstra.company.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TYPE_ROLE", schema = "PARAMETERIZATION")
public class TypeRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TYRO_ID")
    private Integer typeRolesId;
    @Column(name = "TYRO_NAME")
    private Integer typeRolesName;
    @Column(name = "TYRO_DESCRIPTION")
    private Integer typeRolesDescription;
    @Column(name = "TYRO_CREATION_DATE")
    private Integer typeRolesCreationDate;
    @Column(name = "TYRO_EDIT_DATE")
    private Integer typeRolesEditionDate;
    @Column(name = "TYRO_EDIT_USER_ID")
    private Integer typeRolesEditUserID;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "typeRoles")
    private List<Role> roleList;
}
