package com.appstra.company.controller;

import com.appstra.company.entity.TypeRoles;
import com.appstra.company.service.TypeRolesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

@RestController
@RequestMapping("/api/v1/typeroles")
public class TypeRolesController {

    private final TypeRolesService typeRolesService;

    public TypeRolesController(TypeRolesService typeRolesService) {
        this.typeRolesService = typeRolesService;
    }

    @PostMapping("/savetyperoles")
    @Operation(summary = "Guardar Tipo de Rol", description = "Guardar un nuevo tipo de rol")
    public ResponseEntity<TypeRoles> saveTypeRoles(@Validated @RequestBody TypeRoles typeRoles) {
        TypeRoles savedTypeRoles = typeRolesService.saveTypeRoles(typeRoles);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTypeRoles);
    }

    @PutMapping("/updatetyperoles")
    @Operation(summary = "Actualizar Tipo de Rol", description = "Actualizar los datos de un tipo de rol existente")
    public ResponseEntity<TypeRoles> updateTypeRoles(@Validated @RequestBody TypeRoles typeRoles) {
        TypeRoles updatedTypeRoles = typeRolesService.upDateTypeRoles(typeRoles);
        return ResponseEntity.ok(updatedTypeRoles);
    }

    @DeleteMapping("/deletetyperoles/{typeRolesId}")
    @Operation(summary = "Eliminar Tipo de Rol", description = "Eliminar un tipo de rol por su ID")
    public ResponseEntity<Boolean> deleteTypeRoles(@PathVariable Integer typeRolesId) {
        return ResponseEntity.ok(typeRolesService.deleteTypeRoles(typeRolesId));
    }

    @GetMapping("/listtyperoles")
    @Operation(summary = "Listar Tipos de Roles", description = "Obtener una lista de todos los tipos de roles")
    public ResponseEntity<List<TypeRoles>> listTypeRoles() {
        List<TypeRoles> typeRolesList = typeRolesService.listTypeRoles();
        return ResponseEntity.ok(typeRolesList);
    }

    @GetMapping("/{typeRolesId}")
    @Operation(summary = "Obtener Tipo de Rol", description = "Obtener la información de un tipo de rol por su ID")
    public ResponseEntity<TypeRoles> getTypeRoles(@PathVariable Integer typeRolesId) {
        TypeRoles typeRoles = typeRolesService.getTypeRoles(typeRolesId);
        return ResponseEntity.ok(typeRoles);
    }

    @GetMapping("/listtyperolescompanyId/{companyId}")
    @Operation(summary = "Listar Tipos de Roles por compañia ID", description = "Obtener una lista de todos los tipos de roles por compañia ID")
    public ResponseEntity<List<TypeRoles>> listtyperolescompanyId(@PathVariable Integer companyId) {
        List<TypeRoles> typeRolesList = typeRolesService.listtyperolescompanyId(companyId);
        return ResponseEntity.ok(typeRolesList);
    }
}