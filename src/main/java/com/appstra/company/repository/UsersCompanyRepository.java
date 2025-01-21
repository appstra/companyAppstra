package com.appstra.company.repository;

import com.appstra.company.entity.UsersCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersCompanyRepository extends JpaRepository<UsersCompany,Integer> {
    List<UsersCompany> findByUserId (Integer userId);
}
