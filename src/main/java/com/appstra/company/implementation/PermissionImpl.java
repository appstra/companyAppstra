package com.appstra.company.implementation;

import com.appstra.company.entity.Permission;
import com.appstra.company.repository.PermissionRepository;
import com.appstra.company.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PermissionImpl implements PermissionService {
    private final PermissionRepository permissionRepository;

    public PermissionImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public Permission savePermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public Permission upDatePermission(Permission permission) {
        Permission existing =  permissionRepository.findById(permission.getPermissionId())
                .orElseThrow(() -> new IllegalArgumentException("El Permiso no existe: " + permission.getPermissionId()));
        permission.setPermissionCreationDate(existing.getPermissionCreationDate());
        return permissionRepository.save(permission);
    }

    @Override
    public Boolean deletePermission(Integer permissionId) {
        if(permissionRepository.existsById(permissionId)){
            permissionRepository.deleteById(permissionId);
            return true;
        }
        return false;
    }

    @Override
    public List<Permission> listPermission() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission getPermission(Integer permissionId) {
        return permissionRepository.findById(permissionId).orElseThrow(() -> new NoSuchElementException("el permiso con el Id : " + permissionId + "no se encontro"));
    }

    @Override
    public List<Permission> getListrolepermissionroleid(Integer roleId) {
        return permissionRepository.findByRoleListRoleRoleId(roleId);
    }
}
