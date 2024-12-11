package com.appstra.company.controller;

import com.appstra.company.entity.TypeContract;
import com.appstra.company.service.TypeContractService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

@RestController
@RequestMapping("/api/v1/typecontracts")
public class TypeContractController {

    private final TypeContractService typeContractService;

    public TypeContractController(TypeContractService typeContractService) {
        this.typeContractService = typeContractService;
    }

    @PostMapping("/savetypecontract")
    @Operation(summary = "Guardar Tipo de Contrato", description = "Guardar un nuevo tipo de contrato")
    public ResponseEntity<TypeContract> saveTypeContract(@Validated @RequestBody TypeContract typeContract) {
        TypeContract savedTypeContract = typeContractService.saveTypeContract(typeContract);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTypeContract);
    }

    @PutMapping("/updatetypecontract")
    @Operation(summary = "Actualizar Tipo de Contrato", description = "Actualizar los datos de un tipo de contrato existente")
    public ResponseEntity<TypeContract> updateTypeContract(@Validated @RequestBody TypeContract typeContract) {
        TypeContract updatedTypeContract = typeContractService.upDateTypeContract(typeContract);
        return ResponseEntity.ok(updatedTypeContract);
    }

    @DeleteMapping("/deletetypecontract/{typeContractId}")
    @Operation(summary = "Eliminar Tipo de Contrato", description = "Eliminar un tipo de contrato por su ID")
    public ResponseEntity<Boolean> deleteTypeContract(@PathVariable Integer typeContractId) {
        return ResponseEntity.ok(typeContractService.deleteTypeContract(typeContractId));
    }

    @GetMapping("/listtypecontract")
    @Operation(summary = "Listar Tipos de Contratos", description = "Obtener una lista de todos los tipos de contratos")
    public ResponseEntity<List<TypeContract>> listTypeContract() {
        List<TypeContract> typeContracts = typeContractService.listTypeContract();
        return ResponseEntity.ok(typeContracts);
    }

    @GetMapping("/{typeContractId}")
    @Operation(summary = "Obtener Tipo de Contrato", description = "Obtener la información de un tipo de contrato por su ID")
    public ResponseEntity<TypeContract> getTypeContract(@PathVariable Integer typeContractId) {
        TypeContract typeContract = typeContractService.getTypeContract(typeContractId);
        return ResponseEntity.ok(typeContract);
    }
}
