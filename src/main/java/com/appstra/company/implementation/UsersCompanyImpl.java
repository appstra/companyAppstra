package com.appstra.company.implementation;

import com.appstra.company.entity.UsersCompany;
import com.appstra.company.repository.UsersCompanyRepository;
import com.appstra.company.service.UsersCompanyService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UsersCompanyImpl implements UsersCompanyService {
    private final UsersCompanyRepository usersCompanyRepository;

    public UsersCompanyImpl(UsersCompanyRepository usersCompanyRepository) {
        this.usersCompanyRepository = usersCompanyRepository;
    }

    @Override
    public UsersCompany saveUsersCompany(UsersCompany usersCompany) {
        usersCompany.setUsersCompanyCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        usersCompany.setUsersCompanyEditionDate(Timestamp.valueOf(LocalDateTime.now()));
        return usersCompanyRepository.save(usersCompany);
    }

    @Override
    public UsersCompany updateUsersCompany(UsersCompany usersCompany) {
        UsersCompany existing = usersCompanyRepository.findById(usersCompany.getUsersCompanyId())
                .orElseThrow(() -> new IllegalArgumentException("La compañía de usuario no existe: " + usersCompany.getUsersCompanyId()));
        usersCompany.setUsersCompanyCreationDate(existing.getUsersCompanyCreationDate());
        return usersCompanyRepository.save(usersCompany);
    }

    @Override
    public Boolean deleteUsersCompany(Integer usersCompanyId) {
        if (usersCompanyRepository.existsById(usersCompanyId)) {
            usersCompanyRepository.deleteById(usersCompanyId);
            return true;
        }
        return false;
    }

    @Override
    public List<UsersCompany> listUsersCompany() {
        return usersCompanyRepository.findAll();
    }

    @Override
    public UsersCompany getUsersCompany(Integer usersCompanyId) {
        return usersCompanyRepository.findById(usersCompanyId)
                .orElseThrow(() -> new NoSuchElementException("La compañía de usuario con el Id: " + usersCompanyId + " no se encontró"));
    }

    @Override
    public List<UsersCompany> listUsersCompanyUserId(Integer userId) {
        return usersCompanyRepository.findByUserId(userId);
    }
}

