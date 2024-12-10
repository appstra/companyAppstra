package com.appstra.company.implementation;

import com.appstra.company.entity.RolePermission;
import com.appstra.company.repository.RolePermissionRepository;
import com.appstra.company.service.RolePermissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RolePermissionImpl implements RolePermissionService {
    private final RolePermissionRepository rolePermissionRepository;

    public RolePermissionImpl(RolePermissionRepository rolePermissionRepository) {
        this.rolePermissionRepository = rolePermissionRepository;
    }

    @Override
    public RolePermission saveRolePermission(RolePermission rolePermission) {
        return rolePermissionRepository.save(rolePermission);
    }

    @Override
    public RolePermission upDateRolePermission(RolePermission rolePermission) {
        RolePermission existing =  rolePermissionRepository.findById(rolePermission.getRolePermissionId())
                .orElseThrow(() -> new IllegalArgumentException("El Rol - Permiso no existe: " + rolePermission.getRolePermissionId()));
        rolePermission.setRolePermissionCreationDate(existing.getRolePermissionCreationDate());
        return rolePermissionRepository.save(rolePermission);
    }

    @Override
    public Boolean deleteRolePermission(Integer rolePermissionId) {
        if(rolePermissionRepository.existsById(rolePermissionId)){
            rolePermissionRepository.deleteById(rolePermissionId);
            return true;
        }
        return false;
    }

    @Override
    public List<RolePermission> listRolePermission() {
        return rolePermissionRepository.findAll();
    }

    @Override
    public RolePermission getRolePermission(Integer rolePermissionId) {
        return rolePermissionRepository.findById(rolePermissionId).orElseThrow(() -> new NoSuchElementException("el rol permiso con el Id : " + rolePermissionId + "no se encontro"));
    }
}
