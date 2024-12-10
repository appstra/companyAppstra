package com.appstra.company.service;

import com.appstra.company.entity.TypeRoles;

import java.util.List;

public interface TypeRolesService {
    TypeRoles savePerson(TypeRoles typeRoles);
    TypeRoles upDatePerson (TypeRoles typeRoles);
    Boolean deletePerson (Integer typeRolesId);
    List<TypeRoles> listPerson();
    TypeRoles getPerson (Integer typeRolesId);
}
