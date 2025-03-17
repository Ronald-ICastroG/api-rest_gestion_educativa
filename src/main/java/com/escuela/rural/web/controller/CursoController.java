package com.escuela.rural.web.controller;

import com.escuela.rural.persistence.entity.CursoEntity;
import com.escuela.rural.service.interfaces.ICursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/2025/cursos")
@Tag(name="curso resource")
public class CursoController {

    private final ICursoService cursoService;

    @Autowired
    public CursoController(ICursoService cursoService) {
        this.cursoService = cursoService;
    }

    @Operation(summary = "Obtain all cursos ")
    @GetMapping
    public ResponseEntity<List<CursoEntity>> getAll(){
        return new ResponseEntity<>(this.cursoService.getAll(),HttpStatus.OK);
    }

    @Operation(summary = "Obtain curso given the id {curId}")
    @GetMapping("/{curId}")
    public ResponseEntity<CursoEntity>getById(@PathVariable int curId){
        return new ResponseEntity<>(this.cursoService.getById(curId),HttpStatus.OK);
    }

    @Operation(summary="Post: save the curso given the body parameters name,cupo,active ")
    @PostMapping
    public ResponseEntity<CursoEntity>save(@RequestBody CursoEntity cursoEntity) {
        if (cursoEntity.getCurId()== null || !cursoService.exists(cursoEntity.getCurId())) {
            return new ResponseEntity<>(this.cursoService.save(cursoEntity), HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary="Put, Modify or update the name,cupo and active given the body, including id curId")
    @PutMapping
    public ResponseEntity<CursoEntity>update(@RequestBody CursoEntity cursoEntity){
        if (cursoEntity.getCurId()!= null || cursoService.exists(cursoEntity.getCurId())) {
            return ResponseEntity.ok(this.cursoService.save(cursoEntity));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary="Delete curso given the id {curId}")
    @DeleteMapping("/{curId}")
    public ResponseEntity<Void> deleteById(@PathVariable int curId){
        if(this.cursoService.exists(curId)){
            this.cursoService.deleteById(curId);
        }
        return ResponseEntity.noContent().build();
    }

}
