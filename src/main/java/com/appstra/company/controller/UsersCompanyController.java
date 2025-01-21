package com.appstra.company.controller;

import com.appstra.company.entity.UsersCompany;
import com.appstra.company.service.UsersCompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

@RestController
@RequestMapping("/api/v1/userscompany")
public class UsersCompanyController {

    private final UsersCompanyService usersCompanyService;

    public UsersCompanyController(UsersCompanyService usersCompanyService) {
        this.usersCompanyService = usersCompanyService;
    }

    @PostMapping("/saveUsersCompany")
    @Operation(summary = "Guardar Compañía de Usuario", description = "Guardar una nueva compañía de usuario")
    public ResponseEntity<UsersCompany> saveUsersCompany(@Validated @RequestBody UsersCompany usersCompany) {
        UsersCompany savedUsersCompany = usersCompanyService.saveUsersCompany(usersCompany);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUsersCompany);
    }

    @PutMapping("/updateUsersCompany")
    @Operation(summary = "Actualizar Compañía de Usuario", description = "Actualizar los datos de una compañía de usuario existente")
    public ResponseEntity<UsersCompany> updateUsersCompany(@Validated @RequestBody UsersCompany usersCompany) {
        UsersCompany updatedUsersCompany = usersCompanyService.updateUsersCompany(usersCompany);
        return ResponseEntity.ok(updatedUsersCompany);
    }

    @DeleteMapping("/deleteUsersCompany/{usersCompanyId}")
    @Operation(summary = "Eliminar Compañía de Usuario", description = "Eliminar una compañía de usuario por su ID")
    public ResponseEntity<Boolean> deleteUsersCompany(@PathVariable Integer usersCompanyId) {
        return ResponseEntity.ok(usersCompanyService.deleteUsersCompany(usersCompanyId));
    }

    @GetMapping("/listUsersCompany")
    @Operation(summary = "Listar Compañías de Usuario", description = "Obtener una lista de todas las compañías de usuario")
    public ResponseEntity<List<UsersCompany>> listUsersCompany() {
        List<UsersCompany> usersCompanies = usersCompanyService.listUsersCompany();
        return ResponseEntity.ok(usersCompanies);
    }

    @GetMapping("/getUsersCompany/{usersCompanyId}")
    @Operation(summary = "Obtener Compañía de Usuario", description = "Obtener la información de una compañía de usuario por su ID")
    public ResponseEntity<UsersCompany> getUsersCompany(@PathVariable Integer usersCompanyId) {
        UsersCompany usersCompany = usersCompanyService.getUsersCompany(usersCompanyId);
        return ResponseEntity.ok(usersCompany);
    }

    @GetMapping("/listUsersCompanyUserId/{userId}")
    @Operation(summary = "Listar Compañías de Usuario por usuario ID", description = "Obtener una lista de todas las compañías de usuario por usuario ID")
    public ResponseEntity<List<UsersCompany>> listUsersCompanyUserId(@PathVariable Integer userId) {
        List<UsersCompany> usersCompanies = usersCompanyService.listUsersCompanyUserId(userId);
        return ResponseEntity.ok(usersCompanies);
    }
}

