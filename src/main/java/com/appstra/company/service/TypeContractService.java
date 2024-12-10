package com.appstra.company.service;

import com.appstra.company.entity.TypeContract;

import java.util.List;

public interface TypeContractService {
    TypeContract saveTypeContract(TypeContract typeContract);
    TypeContract upDateTypeContract(TypeContract typeContract);
    Boolean deleteTypeContract(Integer typeContractId);
    List<TypeContract> listTypeContract();
    TypeContract getTypeContract(Integer typeContractId);
}
