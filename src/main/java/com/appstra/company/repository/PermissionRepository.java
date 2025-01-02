package com.appstra.company.repository;

import com.appstra.company.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission,Integer> {
    List<Permission> findByRoleListRoleRoleId (Integer roleId);
}