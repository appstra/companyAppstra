package com.appstra.company.repository;

import com.appstra.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository  extends JpaRepository<Company,Integer> {
}
