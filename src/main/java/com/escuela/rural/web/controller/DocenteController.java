package com.escuela.rural.web.controller;

import com.escuela.rural.persistence.entity.DocenteEntity;
import com.escuela.rural.service.IDocenteService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acade/docentes")
public class DocenteController {

    private final IDocenteService docenteService;

    public DocenteController(IDocenteService docenteService) {
        this.docenteService = docenteService;
    }

    @GetMapping
    public ResponseEntity<List<DocenteEntity>>getAll(){
        return ResponseEntity.ok(this.docenteService.getAll());
    }

    @GetMapping("/page")
    public ResponseEntity<Page<DocenteEntity>> getAll(@RequestParam(defaultValue="0") int page,
                                                      @RequestParam(defaultValue="0") int elements){
    return ResponseEntity.ok(this.docenteService.PageGetAll(page,elements));
    }

    @GetMapping("/{docId}")
    public ResponseEntity<DocenteEntity>getById(@PathVariable long docId){
        return ResponseEntity.ok(this.docenteService.getById(docId));
    }

    @PostMapping
    public ResponseEntity<DocenteEntity> crearDocente(@RequestBody DocenteEntity docente){
        if(docente.getDocId()==null||!this.docenteService.exists(docente.getDocId())){
            return new ResponseEntity<>(this.docenteService.save(docente), HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<DocenteEntity> actualizarDocente(@RequestBody DocenteEntity docente){
        if(docente.getDocId()!=null||this.docenteService.exists(docente.getDocId())){
            return new ResponseEntity<>(this.docenteService.save(docente), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }


    @DeleteMapping("/{docId}")
    public ResponseEntity<Void> eliminarDocente(@PathVariable long docId){
        if(this.docenteService.exists(docId)){
            this.docenteService.deleteById(docId);
         return ResponseEntity.accepted().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
