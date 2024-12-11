package com.appstra.company.controller;

import com.appstra.company.entity.RolePermission;
import com.appstra.company.service.RolePermissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rolepermissions")
public class RolePermissionController {

    private final RolePermissionService rolePermissionService;

    public RolePermissionController(RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    @PostMapping("/saverolepermission")
    @Operation(summary = "Guardar Permiso de Rol", description = "Guardar un nuevo permiso de rol")
    public ResponseEntity<RolePermission> saveRolePermission(@Validated @RequestBody RolePermission rolePermission) {
        RolePermission savedRolePermission = rolePermissionService.saveRolePermission(rolePermission);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRolePermission);
    }

    @PutMapping("/updaterolepermission")
    @Operation(summary = "Actualizar Permiso de Rol", description = "Actualizar los datos de un permiso de rol existente")
    public ResponseEntity<RolePermission> updateRolePermission(@Validated @RequestBody RolePermission rolePermission) {
        RolePermission updatedRolePermission = rolePermissionService.upDateRolePermission(rolePermission);
        return ResponseEntity.ok(updatedRolePermission);
    }

    @DeleteMapping("/deleterolepermission/{rolePermissionId}")
    @Operation(summary = "Eliminar Permiso de Rol", description = "Eliminar un permiso de rol por su ID")
    public ResponseEntity<Boolean> deleteRolePermission(@PathVariable Integer rolePermissionId) {
        return ResponseEntity.ok(rolePermissionService.deleteRolePermission(rolePermissionId));
    }

    @GetMapping("/listrolepermission")
    @Operation(summary = "Listar Permisos de Rol", description = "Obtener una lista de todos los permisos de rol")
    public ResponseEntity<List<RolePermission>> listRolePermission() {
        List<RolePermission> rolePermissions = rolePermissionService.listRolePermission();
        return ResponseEntity.ok(rolePermissions);
    }

    @GetMapping("/{rolePermissionId}")
    @Operation(summary = "Obtener Permiso de Rol", description = "Obtener la información de un permiso de rol por su ID")
    public ResponseEntity<RolePermission> getRolePermission(@PathVariable Integer rolePermissionId) {
        RolePermission rolePermission = rolePermissionService.getRolePermission(rolePermissionId);
        return ResponseEntity.ok(rolePermission);
    }
}