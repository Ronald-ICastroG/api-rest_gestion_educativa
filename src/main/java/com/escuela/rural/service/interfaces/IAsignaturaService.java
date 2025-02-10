package com.escuela.rural.service.interfaces;

import com.escuela.rural.persistence.entity.AsignaturaEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAsignaturaService {

    List<AsignaturaEntity> getAll();

    AsignaturaEntity getById(long asgId);
    AsignaturaEntity save(AsignaturaEntity asignaturaEntity);
    void deleteById(long asgId);
    Boolean exists(long asgId);


}
