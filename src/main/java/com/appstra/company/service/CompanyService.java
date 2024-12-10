package com.appstra.company.service;

import com.appstra.company.entity.Company;

import java.util.List;

public interface CompanyService {
    Company saveCompany(Company company);
    Company upDateCompany (Company company);
    Boolean deleteCompany(Integer companyId);
    List<Company> listCompany();
    Company getCompany(Integer companyId);
}
