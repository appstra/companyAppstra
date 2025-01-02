package com.appstra.company.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "COMPANY", schema = "PARAMETERIZATION")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMP_ID")
    private Integer companyId;

    @Column(name = "COMP_NAME")
    private String companyName;

    @Column(name = "COMP_NIT_NUMBER")
    private String companyNit;

    @Column(name = "COMP_ADDRESS")
    private String companyAddress;

    @Column(name = "CITY_ID")
    @Comment("Campo de la base de datos de UserAppstra")
    private Integer cityId;

    @Column(name = "COMP_WEBSITE")
    private String companyWebsite;

    @Column(name = "COMP_CREATION_DATE")
    private LocalDate companyCreationDate;

    @Column(name = "COMP_EDIT_DATE")
    private LocalDate companyEditionDate;

    @Column(name = "COMP_EDIT_USER_ID")
    private Integer companyEditUserID;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "company")
    private List<Office> officeList;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "company")
    private List<Role> roleList;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "company")
    private List<TypeContract> typeContractList;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "company")
    private List<TypeRoles> typeRolesList;

}
