package com.appstra.company.implementation;

import com.appstra.company.entity.TypeContract;
import com.appstra.company.repository.TypeContractRepository;
import com.appstra.company.service.TypeContractService;

import java.util.List;
import java.util.NoSuchElementException;

public class TypeContractImpl implements TypeContractService {
    private final TypeContractRepository typeContractRepository;

    public TypeContractImpl(TypeContractRepository typeContractRepository) {
        this.typeContractRepository = typeContractRepository;
    }

    @Override
    public TypeContract saveTypeContract(TypeContract typeContract) {
        return typeContractRepository.save(typeContract);
    }

    @Override
    public TypeContract upDateTypeContract(TypeContract typeContract) {
        TypeContract existing =  typeContractRepository.findById(typeContract.getTypeContractId())
                .orElseThrow(() -> new IllegalArgumentException("El Tipo Contrato no existe: " + typeContract.getTypeContractId()));
        typeContract.setTypeContractPermissionCreationDate(existing.getTypeContractPermissionCreationDate());
        return typeContractRepository.save(typeContract);
    }

    @Override
    public Boolean deleteTypeContract(Integer typeContractId) {
        if(typeContractRepository.existsById(typeContractId)){
            typeContractRepository.deleteById(typeContractId);
            return true;
        }
        return false;
    }

    @Override
    public List<TypeContract> listTypeContract() {
        return typeContractRepository.findAll();
    }

    @Override
    public TypeContract getTypeContract(Integer typeContractId) {
        return typeContractRepository.findById(typeContractId).orElseThrow(() -> new NoSuchElementException("el Tipo contrato con el Id : " + typeContractId + "no se encontro"));
    }
}
