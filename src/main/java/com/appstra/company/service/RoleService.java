package com.appstra.company.service;

import com.appstra.company.entity.Role;

import java.util.List;

public interface RoleService {
    Role saveRole(Role role);
    Role upDateRole(Role role);
    Boolean deleteRole(Integer roleId);
    List<Role> listRole();
    Role getRole(Integer roleId);
}
