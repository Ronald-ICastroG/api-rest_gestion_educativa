package com.escuela.rural.service.interfaces;

import com.escuela.rural.persistence.entity.DocenteEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDocenteService {


    Page<DocenteEntity> PageGetAll(int page, int elements);

    List<DocenteEntity> getAll();

    DocenteEntity getById(long docId);

    DocenteEntity save(DocenteEntity docenteEntity);

    void deleteById(long docId);

    Boolean exists(long docId);





}
