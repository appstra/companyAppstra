package com.appstra.company.repository;

import com.appstra.company.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role,Integer> {
}
