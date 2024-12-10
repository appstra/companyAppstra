package com.appstra.company.implementation;

import com.appstra.company.entity.Company;
import com.appstra.company.repository.CompanyRepository;
import com.appstra.company.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CompanyImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company upDateCompany(Company company) {
        Company existingState = companyRepository.findById(company.getCompanyId())
                .orElseThrow(() -> new IllegalArgumentException("la empresa no existe: " + company.getCompanyId()));
        company.setCompanyCreationDate(existingState.getCompanyCreationDate());

        return companyRepository.save(company);
    }

    @Override
    public Boolean deleteCompany(Integer companyId) {
        if (companyRepository.existsById(companyId)) {
            companyRepository.deleteById(companyId);
            return true;
        }
        return false;
    }

    @Override
    public List<Company> listCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompany(Integer companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new NoSuchElementException("la compañia con el Id : " + companyId + "no se encontro"));
    }
}
