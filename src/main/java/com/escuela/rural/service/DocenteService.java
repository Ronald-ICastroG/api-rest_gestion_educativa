package com.escuela.rural.service;

import com.escuela.rural.persistence.entity.DocenteEntity;
import com.escuela.rural.persistence.repository.DocenteRepository;
<<<<<<< HEAD
=======
import com.escuela.rural.service.interfaces.IDocenteService;
>>>>>>> e26379ea5f0d2d23fec2db92e365e1f03e9ca6ee
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
=======
>>>>>>> e26379ea5f0d2d23fec2db92e365e1f03e9ca6ee

import java.util.List;

@Service
<<<<<<< HEAD
public class DocenteService implements IDocenteService{
=======
public class DocenteService implements IDocenteService {
>>>>>>> e26379ea5f0d2d23fec2db92e365e1f03e9ca6ee
private final DocenteRepository docenteRepository;

    public DocenteService(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    @Override
    public Page<DocenteEntity> PageGetAll(int page, int elements) {
        Pageable pageRequest= PageRequest.of(page,elements);
        return this.docenteRepository.findAll(pageRequest);
    }

    @Override
    public List<DocenteEntity> getAll() {
        return this.docenteRepository.findAll();
    }

    @Override
<<<<<<< HEAD
    public DocenteEntity findByEmail(String docEmail) {
        return this.docenteRepository.findByDocEmail(docEmail);
    }

    @Override
=======
>>>>>>> e26379ea5f0d2d23fec2db92e365e1f03e9ca6ee
    public DocenteEntity getById(long docId) {
        return this.docenteRepository.findById(docId).get();

    }

    @Override
    public DocenteEntity save(DocenteEntity docenteEntity) {
        return this.docenteRepository.save(docenteEntity);
    }

    @Override
    public void deleteById(long docId) {
        this.docenteRepository.deleteById(docId);
        System.out.println("Docente con id: "+docId+" eliminado");
    }

    @Override
    public Boolean exists(long docId) {
        return this.docenteRepository.existsById(docId);
    }

<<<<<<< HEAD
=======
    @Override
    public void deleteByDocName(String docName) {
        this.docenteRepository.deleteByDocName(docName);
        System.out.println("Docente con nombre: "+docName+" eliminado");
    }

>>>>>>> e26379ea5f0d2d23fec2db92e365e1f03e9ca6ee
}
