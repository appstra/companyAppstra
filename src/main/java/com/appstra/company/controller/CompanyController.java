package com.appstra.company.controller;

import com.appstra.company.entity.Company;
import com.appstra.company.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Company")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/savecompany")
    @Operation(summary = "Guardar Empresa", description = "Guardar empresa")
    public ResponseEntity<Company> saveCompany(@Validated @RequestBody Company company){
        return ResponseEntity.ok(companyService.saveCompany(company));
    }
    @PutMapping("/updatecompany")
    @Operation(summary = "actualiza empresa", description = "actualiza empresa")
    public ResponseEntity<Company> updateCompany (@Validated @RequestBody Company company){
        return ResponseEntity.ok(companyService.upDateCompany(company));
    }
    @DeleteMapping("/deletecompany/{companyId}")
    @Operation(summary = "Elimina empresa", description = "Elimina empresa")
    public ResponseEntity<Boolean> deleteCompany(@PathVariable("companyId") Integer companyId){
        return ResponseEntity.ok(companyService.deleteCompany(companyId));
    }
    @GetMapping("/listcopampany")
    @Operation(summary = "Lista empresas", description = "Lista empresas")
    public ResponseEntity<List<Company>> listCompany (){
        return ResponseEntity.ok(companyService.listCompany());
    }
    @GetMapping("/{personId}")
    @Operation(summary = "Informa persona", description = "Informa persona")
    public ResponseEntity<Company> getPerson (@PathVariable("companyId") Integer companyId){
        return ResponseEntity.ok(companyService.getCompany(companyId));
    }
}
