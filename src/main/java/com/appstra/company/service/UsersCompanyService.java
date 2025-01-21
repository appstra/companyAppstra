package com.appstra.company.service;

import com.appstra.company.entity.UsersCompany;

import java.util.List;

public interface UsersCompanyService {
    UsersCompany saveUsersCompany(UsersCompany usersCompany);
    UsersCompany updateUsersCompany(UsersCompany usersCompany);
    Boolean deleteUsersCompany(Integer usersCompanyId);
    List<UsersCompany> listUsersCompany();
    UsersCompany getUsersCompany(Integer usersCompanyId);
    List<UsersCompany> listUsersCompanyUserId (Integer userId);
}

