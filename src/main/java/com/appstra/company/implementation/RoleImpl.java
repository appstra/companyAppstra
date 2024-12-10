package com.appstra.company.implementation;

import com.appstra.company.entity.Role;
import com.appstra.company.repository.RoleRepository;
import com.appstra.company.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RoleImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role upDateRole(Role role) {
        Role existing =  roleRepository.findById(role.getRoleId())
                .orElseThrow(() -> new IllegalArgumentException("El Rol no existe: " + role.getRoleId()));
        role.setRoleCreationDate(existing.getRoleCreationDate());
        return roleRepository.save(role);
    }

    @Override
    public Boolean deleteRole(Integer roleId) {
        if(roleRepository.existsById(roleId)){
            roleRepository.deleteById(roleId);
            return true;
        }
        return false;
    }

    @Override
    public List<Role> listRole() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRole(Integer roleId) {
        return roleRepository.findById(roleId).orElseThrow(() -> new NoSuchElementException("el permiso con el Id : " + roleId + "no se encontro"));
    }
}
