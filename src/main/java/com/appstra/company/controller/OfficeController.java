package com.appstra.company.controller;
import com.appstra.company.entity.Office;
import com.appstra.company.service.OfficeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

@RestController
@RequestMapping("/api/v1/offices")
public class OfficeController {
    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping("/saveoffice")
    @Operation(summary = "Guardar Oficina", description = "Guardar una nueva oficina")
    public ResponseEntity<Office> saveOffice(@Validated @RequestBody Office office) {
        Office savedOffice = officeService.saveOffice(office);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOffice);
    }

    @PutMapping("/updateoffice")
    @Operation(summary = "Actualizar Oficina", description = "Actualizar los datos de una oficina existente")
    public ResponseEntity<Office> updateOffice(@Validated @RequestBody Office office) {
        Office updatedOffice = officeService.upDateOffice(office);
        return ResponseEntity.ok(updatedOffice);
    }

    @DeleteMapping("/deleteoffice/{officeId}")
    @Operation(summary = "Eliminar Oficina", description = "Eliminar una oficina por su ID")
    public ResponseEntity<Boolean> deleteOffice(@PathVariable Integer officeId) {
        return ResponseEntity.ok(officeService.deleteOffice(officeId));
    }

    @GetMapping("/listoffice")
    @Operation(summary = "Listar Oficinas", description = "Obtener una lista de todas las oficinas")
    public ResponseEntity<List<Office>> listOffices() {
        List<Office> offices = officeService.listOffice();
        return ResponseEntity.ok(offices);
    }

    @GetMapping("/{officeId}")
    @Operation(summary = "Obtener Oficina", description = "Obtener la información de una oficina por su ID")
    public ResponseEntity<Office> getOffice(@PathVariable Integer officeId) {
        Office office = officeService.getOffice(officeId);
        return ResponseEntity.ok(office);
    }
}