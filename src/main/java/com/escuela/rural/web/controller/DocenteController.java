package com.escuela.rural.web.controller;

import com.escuela.rural.persistence.entity.DocenteEntity;
<<<<<<< HEAD
import com.escuela.rural.service.IDocenteService;
=======
import com.escuela.rural.service.interfaces.IDocenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
>>>>>>> e26379ea5f0d2d23fec2db92e365e1f03e9ca6ee
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acade/docentes")
<<<<<<< HEAD
=======
@Tag(name="Docente-resource")
>>>>>>> e26379ea5f0d2d23fec2db92e365e1f03e9ca6ee
public class DocenteController {

    private final IDocenteService docenteService;

    public DocenteController(IDocenteService docenteService) {
        this.docenteService = docenteService;
    }
<<<<<<< HEAD

=======
    @Operation(summary = "Get docentes list ")
>>>>>>> e26379ea5f0d2d23fec2db92e365e1f03e9ca6ee
    @GetMapping
    public ResponseEntity<List<DocenteEntity>>getAll(){
        return ResponseEntity.ok(this.docenteService.getAll());
    }

<<<<<<< HEAD
=======
    @Operation(summary = "Get docentes List paged, given request param page and elements than need the user to see")
>>>>>>> e26379ea5f0d2d23fec2db92e365e1f03e9ca6ee
    @GetMapping("/page")
    public ResponseEntity<Page<DocenteEntity>> getAll(@RequestParam(defaultValue="0") int page,
                                                      @RequestParam(defaultValue="0") int elements){
    return ResponseEntity.ok(this.docenteService.PageGetAll(page,elements));
    }

<<<<<<< HEAD
    @GetMapping("/{docId}")
=======
    @Operation(summary="Get docente given id {docId}")
    @GetMapping("/{docId:[0-9]+}")
>>>>>>> e26379ea5f0d2d23fec2db92e365e1f03e9ca6ee
    public ResponseEntity<DocenteEntity>getById(@PathVariable long docId){
        return ResponseEntity.ok(this.docenteService.getById(docId));
    }

<<<<<<< HEAD
    @GetMapping("/mail/{docEmail}")
    public ResponseEntity<DocenteEntity>getByEmail(@PathVariable String docEmail){
       return ResponseEntity.ok(this.docenteService.findByEmail(docEmail));
    }

=======
    @Operation(summary = "Post or save docente given the RequestBody that includes name {docName},lastname{docLname},email {docEmail},profession {docProfession} and scolarity {docScolarity}")
>>>>>>> e26379ea5f0d2d23fec2db92e365e1f03e9ca6ee
    @PostMapping
    public ResponseEntity<DocenteEntity> crearDocente(@RequestBody DocenteEntity docente){
        if(docente.getDocId()==null||!this.docenteService.exists(docente.getDocId())){
            return new ResponseEntity<>(this.docenteService.save(docente), HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }

<<<<<<< HEAD
=======
    @Operation(summary = "Put, update or modify the docenteEntity, given the RequestBody, including docId")
>>>>>>> e26379ea5f0d2d23fec2db92e365e1f03e9ca6ee
    @PutMapping
    public ResponseEntity<DocenteEntity> actualizarDocente(@RequestBody DocenteEntity docente){
        if(docente.getDocId()!=null||this.docenteService.exists(docente.getDocId())){
            return new ResponseEntity<>(this.docenteService.save(docente), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }


<<<<<<< HEAD
    @DeleteMapping("/{docId}")
    public ResponseEntity<Void> eliminarDocente(@PathVariable long docId){
        if(this.docenteService.exists(docId)){
            this.docenteService.deleteById(docId);
         return ResponseEntity.accepted().build();
        }
        return ResponseEntity.badRequest().build();
    }
=======
    @Operation(summary = "Delete docente given id {docId}")
    @DeleteMapping("/{docId:[0-9]+}")
    public ResponseEntity<Void> eliminarDocente(@PathVariable long docId){
        if(this.docenteService.exists(docId)){
            this.docenteService.deleteById(docId);
         return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Delete docente given the name {docName}, using JPQL native query")
    @DeleteMapping("/name/{docName:[a-zA-Z]+}")
    public ResponseEntity<Void> deleteByDocName(@PathVariable String docName){
        this.docenteService.deleteByDocName(docName);
        return ResponseEntity.noContent().build();
    }
>>>>>>> e26379ea5f0d2d23fec2db92e365e1f03e9ca6ee
}
