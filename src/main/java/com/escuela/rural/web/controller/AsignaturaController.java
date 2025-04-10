package com.escuela.rural.web.controller;

import com.escuela.rural.persistence.entity.AsignaturaEntity;
import com.escuela.rural.service.interfaces.IAsignaturaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignaturas")
@Tag(name="Asignatura-resource")
public class AsignaturaController {

    private final IAsignaturaService asignaturaService;

    public AsignaturaController(IAsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }

    @Operation(summary = "Get all asignaturas ")
    @GetMapping
    public ResponseEntity<List<AsignaturaEntity>> getAll() {
        return new ResponseEntity<>(this.asignaturaService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Get asignatura given id {asgId}")
    @GetMapping("/{asgId}")
    public ResponseEntity<AsignaturaEntity> getById(@PathVariable long asgId) {
        return ResponseEntity.ok(this.asignaturaService.getById(asgId));
    }

    @Operation(summary = "Create asignatura given thee RequestBody,including asgCurid and asgDocid")
    @PostMapping
    public ResponseEntity<AsignaturaEntity> save(@RequestBody AsignaturaEntity asignaturaEntity) {
            return new ResponseEntity<>(this.asignaturaService.save(asignaturaEntity), HttpStatus.CREATED);

    }
    @Operation(summary = "Update asignatura given @Requestbody including id {asgId}")
    @PutMapping
    public ResponseEntity<AsignaturaEntity> update(@RequestBody AsignaturaEntity asignaturaEntity) {
        if (asignaturaEntity.getAsgId() != null || this.asignaturaService.exists(asignaturaEntity.getAsgId())) {
            return new ResponseEntity<>(this.asignaturaService.save(asignaturaEntity), HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Delete asignatura given id {asgId}")
        @DeleteMapping("/{asgId}")
        public ResponseEntity<Void> deleteById (@PathVariable long asgId){
            if (this.asignaturaService.exists(asgId)) {
                this.asignaturaService.deleteById(asgId);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.badRequest().build();

            }
        }
    }

