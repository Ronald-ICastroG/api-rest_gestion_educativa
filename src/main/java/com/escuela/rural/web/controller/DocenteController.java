package com.escuela.rural.web.controller;

import com.escuela.rural.persistence.entity.DocenteEntity;
import com.escuela.rural.service.interfaces.IDocenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acade/docentes")
@Tag(name="Docente-resource")
public class DocenteController {

    private final IDocenteService docenteService;

    public DocenteController(IDocenteService docenteService) {
        this.docenteService = docenteService;
    }
    @Operation(summary = "Get docentes list ")
    @GetMapping
    public ResponseEntity<List<DocenteEntity>>getAll(){
        return ResponseEntity.ok(this.docenteService.getAll());
    }

    @Operation(summary = "Get docentes List paged, given request param page and elements than need the user to see")
    @GetMapping("/page")
    public ResponseEntity<Page<DocenteEntity>> getAll(@RequestParam(defaultValue="0") int page,
                                                      @RequestParam(defaultValue="0") int elements){
    return ResponseEntity.ok(this.docenteService.PageGetAll(page,elements));
    }

    @Operation(summary="Get docente given id {docId}")
    @GetMapping("/{docId}")
    public ResponseEntity<DocenteEntity>getById(@PathVariable long docId){
        return ResponseEntity.ok(this.docenteService.getById(docId));
    }

    @Operation(summary = "Post or save docente given the RequestBody that includes name {docName},lastname{docLname},email {docEmail},profession {docProfession} and scolarity {docScolarity}")
    @PostMapping
    public ResponseEntity<DocenteEntity> crearDocente(@RequestBody DocenteEntity docente){
        if(docente.getDocId()==null||!this.docenteService.exists(docente.getDocId())){
            return new ResponseEntity<>(this.docenteService.save(docente), HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Put, update or modify the docenteEntity, given the RequestBody, including docId")
    @PutMapping
    public ResponseEntity<DocenteEntity> actualizarDocente(@RequestBody DocenteEntity docente){
        if(docente.getDocId()!=null||this.docenteService.exists(docente.getDocId())){
            return new ResponseEntity<>(this.docenteService.save(docente), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }


    @Operation(summary = "Delete docente given id {docId}")
    @DeleteMapping("/{docId}")
    public ResponseEntity<Void> eliminarDocente(@PathVariable long docId){
        if(this.docenteService.exists(docId)){
            this.docenteService.deleteById(docId);
         return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
