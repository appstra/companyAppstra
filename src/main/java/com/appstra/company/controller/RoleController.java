package com.appstra.company.controller;

import com.appstra.company.entity.Role;
import com.appstra.company.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/saverole")
    @Operation(summary = "Guardar Rol", description = "Guardar un nuevo rol")
    public ResponseEntity<Role> saveRole(@Validated @RequestBody Role role) {
        Role savedRole = roleService.saveRole(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRole);
    }

    @PutMapping("/updaterole")
    @Operation(summary = "Actualizar Rol", description = "Actualizar los datos de un rol existente")
    public ResponseEntity<Role> updateRole(@Validated @RequestBody Role role) {
        Role updatedRole = roleService.upDateRole(role);
        return ResponseEntity.ok(updatedRole);
    }

    @DeleteMapping("/deleterole/{roleId}")
    @Operation(summary = "Eliminar Rol", description = "Eliminar un rol por su ID")
    public ResponseEntity<Boolean> deleteRole(@PathVariable Integer roleId) {
        return ResponseEntity.ok(roleService.deleteRole(roleId));
    }

    @GetMapping("/listrole")
    @Operation(summary = "Listar Roles", description = "Obtener una lista de todos los roles")
    public ResponseEntity<List<Role>> listRole() {
        List<Role> roles = roleService.listRole();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{roleId}")
    @Operation(summary = "Obtener Rol", description = "Obtener la información de un rol por su ID")
    public ResponseEntity<Role> getRole(@PathVariable Integer roleId) {
        Role role = roleService.getRole(roleId);
        return ResponseEntity.ok(role);
    }

    @GetMapping("/listroletyperole/{typeRolesId}")
    @Operation(summary = "Obtener Rol por tipos de rol", description = "Obtener la información de un rol por tipos de rol")
    public ResponseEntity<List<Role>> getRoleTypeRolesId(@PathVariable Integer typeRolesId) {
        return ResponseEntity.ok(roleService.getRoleTypeRolesId(typeRolesId));
    }
}
