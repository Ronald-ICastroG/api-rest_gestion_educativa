package com.escuela.rural.web.controller;

import com.escuela.rural.persistence.entity.CursoEntity;
import com.escuela.rural.service.CursoService;
import com.escuela.rural.service.ICursoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/2025/cursos")
public class CursoController {

    private final ICursoService cursoService;

    @Autowired
    public CursoController(ICursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<CursoEntity>> getAll(){
        return new ResponseEntity<>(this.cursoService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{curId}")
    public ResponseEntity<CursoEntity>getById(@PathVariable int curId){
        return new ResponseEntity<>(this.cursoService.getById(curId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CursoEntity>save(@RequestBody CursoEntity cursoEntity){
        return ResponseEntity.ok(this.cursoService.save(cursoEntity));
    }

    @PutMapping
    public ResponseEntity<CursoEntity>update(@RequestBody CursoEntity cursoEntity){
        return ResponseEntity.ok(this.cursoService.save(cursoEntity));
    }


    @DeleteMapping
    public ResponseEntity<Void> deleteById(@PathVariable int curId){
        if(this.cursoService.exists(curId)){
            this.cursoService.deleteById(curId);
        }
        return ResponseEntity.ok().build();
    }

}
