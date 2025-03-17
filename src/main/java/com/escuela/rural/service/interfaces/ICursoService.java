package com.escuela.rural.service.interfaces;

import com.escuela.rural.persistence.entity.CursoEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICursoService{

    List<CursoEntity>getAll();

    CursoEntity getById(Integer curId);

    CursoEntity save(CursoEntity cursoEntity);

    void deleteById(int curId);

    boolean exists(int curId);


}
