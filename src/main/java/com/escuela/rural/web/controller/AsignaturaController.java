package com.escuela.rural.web.controller;

import com.escuela.rural.persistence.entity.AsignaturaEntity;
import com.escuela.rural.service.IAsignaturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {

    private final IAsignaturaService asignaturaService;

    public AsignaturaController(IAsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }

    @GetMapping
    public ResponseEntity<List<AsignaturaEntity>> getAll() {
        return new ResponseEntity<>(this.asignaturaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{asgId}")
    public ResponseEntity<AsignaturaEntity> getById(@PathVariable int asgId) {
        return ResponseEntity.ok(this.asignaturaService.getById(asgId));
    }

    @PostMapping
    public ResponseEntity<AsignaturaEntity> save(AsignaturaEntity asignaturaEntity) {
        if (asignaturaEntity.getAsgId() == null && !this.asignaturaService.exists(asignaturaEntity.getAsgId())) {
            return new ResponseEntity<>(this.asignaturaService.save(asignaturaEntity), HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<AsignaturaEntity> update(AsignaturaEntity asignaturaEntity) {
        if (asignaturaEntity.getAsgId() != null || this.asignaturaService.exists(asignaturaEntity.getAsgId())) {
            return new ResponseEntity<>(this.asignaturaService.save(asignaturaEntity), HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

        @DeleteMapping
        public ResponseEntity<Void> deleteById (long asgId){
            if (this.asignaturaService.exists(asgId)) {
                this.asignaturaService.deleteById((int) asgId);
                return ResponseEntity.accepted().build();
            } else {
                return ResponseEntity.badRequest().build();

            }
        }
    }

