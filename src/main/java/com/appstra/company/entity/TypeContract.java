package com.appstra.company.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TYPE_CONTRACT", schema = "PARAMETERIZATION")
public class TypeContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TYCO_ID")
    private Integer typeContractId;

    @Column(name = "TYCO_NAME")
    private Integer typeContractName;

    @Column(name = "TYCO_DESCRIPTION")
    private Integer typeContractDescription;

    @Column(name = "TYCO_CREATION_DATE")
    private Integer typeContractPermissionCreationDate;

    @Column(name = "TYCO_EDIT_DATE")
    private Integer typeContractPermissionEditionDate;

    @Column(name = "TYCO_EDIT_USER_ID")
    private Integer typeContractPermissionEditUserID;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "COMP_ID", referencedColumnName = "COMP_ID")
    private Company company;

}
