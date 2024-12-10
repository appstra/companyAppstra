package com.appstra.company.implementation;

import com.appstra.company.entity.TypeRoles;
import com.appstra.company.repository.TypeRolesRepository;
import com.appstra.company.service.TypeRolesService;

import java.util.List;
import java.util.NoSuchElementException;

public class TypeRolesImpl implements TypeRolesService {
    private final TypeRolesRepository typeRolesRepository;

    public TypeRolesImpl(TypeRolesRepository typeRolesRepository) {
        this.typeRolesRepository = typeRolesRepository;
    }

    @Override
    public TypeRoles saveTypeRoles(TypeRoles typeRoles) {
        return typeRolesRepository.save(typeRoles);
    }

    @Override
    public TypeRoles upDateTypeRoles(TypeRoles typeRoles) {
        TypeRoles existing =  typeRolesRepository.findById(typeRoles.getTypeRolesId())
                .orElseThrow(() -> new IllegalArgumentException("El tipo Rol no existe: " + typeRoles.getTypeRolesId()));
        typeRoles.setTypeRolesCreationDate(existing.getTypeRolesCreationDate());
        return typeRolesRepository.save(typeRoles);
    }

    @Override
    public Boolean deleteTypeRoles(Integer typeRolesId) {
        if(typeRolesRepository.existsById(typeRolesId)){
            typeRolesRepository.deleteById(typeRolesId);
            return true;
        }
        return false;
    }

    @Override
    public List<TypeRoles> listTypeRoles() {
        return typeRolesRepository.findAll();
    }

    @Override
    public TypeRoles getTypeRoles(Integer typeRolesId) {
        return typeRolesRepository.findById(typeRolesId).orElseThrow(() -> new NoSuchElementException("el Tipo contrato con el Id : " + typeRolesId + "no se encontro"));
    }
}
