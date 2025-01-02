package com.appstra.company.repository;

import com.appstra.company.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository  extends JpaRepository<Role,Integer> {
    List<Role> findByTypeRolesTypeRolesId (Integer typeRolesId);
}
