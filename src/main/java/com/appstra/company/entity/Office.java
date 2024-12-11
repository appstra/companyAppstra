package com.appstra.company.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "OFFICE", schema = "PARAMETERIZATION")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OFFI_ID")
    private Integer officeId;

    @Column(name = "OFFI_NAME")
    private String officeName;

    @Column(name = "OFFI_DESCRIPTION")
    private String officeDescription;

    @Column(name = "OFFI_CREATION_DATE")
    private LocalDate officeCreationDate;

    @Column(name = "OFFI_EDIT_DATE")
    private LocalDate officeEditionDate;

    @Column(name = "OFFI_EDIT_USER_ID")
    private Integer officeEditUserID;

    @ManyToOne
    @JoinColumn(name = "COMP_ID", referencedColumnName = "COMP_ID")
    private Company company;
}
