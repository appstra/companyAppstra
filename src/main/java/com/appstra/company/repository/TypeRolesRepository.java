package com.appstra.company.repository;

import com.appstra.company.entity.TypeRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeRolesRepository extends JpaRepository<TypeRoles,Integer> {
    List<TypeRoles> findByCompanyCompanyId(Integer companyId);
}
