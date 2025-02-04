package com.escuela.rural.service;

import com.escuela.rural.persistence.entity.DocenteEntity;
import com.escuela.rural.persistence.repository.DocenteRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public interface IDocenteService {


    Page<DocenteEntity> PageGetAll(int page, int elements);

    List<DocenteEntity> getAll();

    DocenteEntity getById(long docId);

    DocenteEntity save(DocenteEntity docenteEntity);

    void deleteById(long docId);

    Boolean exists(long docId);





}
