package com.appstra.company.service;

import com.appstra.company.entity.RolePermission;

import java.util.List;

public interface RolePermissionService {
    RolePermission saveRolePermission(RolePermission rolePermission);
    RolePermission upDateRolePermission(RolePermission rolePermission);
    Boolean deleteRolePermission(Integer rolePermissionId);
    List<RolePermission> listRolePermission();
    RolePermission getRolePermission(Integer rolePermissionId);
}
