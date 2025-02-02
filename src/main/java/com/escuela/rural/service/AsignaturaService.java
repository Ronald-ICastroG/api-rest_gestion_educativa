package com.escuela.rural.service;

import com.escuela.rural.persistence.entity.AsignaturaEntity;
import com.escuela.rural.persistence.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaService implements IAsignaturaService {
    private final AsignaturaRepository asignaturaRepository;

    @Autowired
    public AsignaturaService(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }


    @Override
    public List<AsignaturaEntity> getAll() {
        return this.asignaturaRepository.findAll();
    }

    @Override
    public AsignaturaEntity getById(long asgId) {
        return this.asignaturaRepository.findById(asgId).get();
    }

    @Override
    public AsignaturaEntity save(AsignaturaEntity asignaturaEntity) {
        return this.asignaturaRepository.save(asignaturaEntity);
    }

    @Override
    public void deleteById(long asgId) {
    this.asignaturaRepository.deleteById(asgId);
        System.out.println("asignatura " +asgId+ " eliminado");
    }

    public Boolean exists(long asgId){
        return this.asignaturaRepository.existsById(asgId);
    }
}
