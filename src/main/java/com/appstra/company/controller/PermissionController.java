package com.appstra.company.controller;

import com.appstra.company.entity.Permission;
import com.appstra.company.service.PermissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

@RestController
@RequestMapping("/api/v1/permissions")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping("/savepermission")
    @Operation(summary = "Guardar Permiso", description = "Guardar un nuevo permiso")
    public ResponseEntity<Permission> savePermission(@Validated @RequestBody Permission permission) {
        Permission savedPermission = permissionService.savePermission(permission);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPermission);
    }

    @PutMapping("/updatepermission")
    @Operation(summary = "Actualizar Permiso", description = "Actualizar los datos de un permiso existente")
    public ResponseEntity<Permission> updatePermission(@Validated @RequestBody Permission permission) {
        Permission updatedPermission = permissionService.upDatePermission(permission);
        return ResponseEntity.ok(updatedPermission);
    }

    @DeleteMapping("/deletepermission/{permissionId}")
    @Operation(summary = "Eliminar Permiso", description = "Eliminar un permiso por su ID")
    public ResponseEntity<Boolean> deletePermission(@PathVariable Integer permissionId) {
        return ResponseEntity.ok(permissionService.deletePermission(permissionId));
    }

    @GetMapping("/listpermission")
    @Operation(summary = "Listar Permisos", description = "Obtener una lista de todos los permisos")
    public ResponseEntity<List<Permission>> listPermission() {
        List<Permission> permissions = permissionService.listPermission();
        return ResponseEntity.ok(permissions);
    }

    @GetMapping("/{permissionId}")
    @Operation(summary = "Obtener Permiso", description = "Obtener la información de un permiso por su ID")
    public ResponseEntity<Permission> getPermission(@PathVariable Integer permissionId) {
        Permission permission = permissionService.getPermission(permissionId);
        return ResponseEntity.ok(permission);
    }
}
