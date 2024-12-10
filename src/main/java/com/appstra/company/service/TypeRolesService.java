package com.appstra.company.service;

import com.appstra.company.entity.TypeRoles;

import java.util.List;

public interface TypeRolesService {
    TypeRoles saveTypeRoles(TypeRoles typeRoles);
    TypeRoles upDateTypeRoles(TypeRoles typeRoles);
    Boolean deleteTypeRoles(Integer typeRolesId);
    List<TypeRoles> listTypeRoles();
    TypeRoles getTypeRoles(Integer typeRolesId);
}
