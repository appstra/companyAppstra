package com.appstra.company.service;

import com.appstra.company.entity.Permission;

import java.util.List;

public interface PermissionService {
    Permission savePermission(Permission permission);
    Permission upDatePermission (Permission permission);
    Boolean deletePermission(Integer permissionId);
    List<Permission> listPermission();
    Permission getPermission(Integer permissionId);
    List<Permission> getListrolepermissionroleid(Integer roleId);
}
