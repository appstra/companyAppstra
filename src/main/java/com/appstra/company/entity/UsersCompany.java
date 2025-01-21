package com.appstra.company.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "USERS_COMPANY", schema = "TRANSACTIONAL")
public class UsersCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USCO_ID")
    private Integer usersCompanyId;

    @Column(name = "USER_ID")
    @Comment("ID del usuario ID, base de datos de userAppstra")
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "COMP_ID", referencedColumnName = "COMP_ID")
    private Company company;

    @Column(name = "USCO_CREATION_DATE")
    private Timestamp usersCompanyCreationDate;

    @Column(name = "USCO_EDIT_DATE")
    private Timestamp usersCompanyEditionDate;

    @Column(name = "USCO_EDIT_USER_ID")
    private Integer usersCompanyEditUserID;
}
