package com.escuela.rural.service;

import com.escuela.rural.persistence.entity.CursoEntity;
import com.escuela.rural.persistence.repository.CursoPagSortRepository;
import com.escuela.rural.persistence.repository.CursoRepository;
import com.escuela.rural.service.interfaces.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService implements ICursoService {

    private final CursoRepository cursoRepository;
    private final CursoPagSortRepository cursoPagSortRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository, CursoPagSortRepository cursoPagSortRepository) {
        this.cursoRepository = cursoRepository;
        this.cursoPagSortRepository = cursoPagSortRepository;
    }


    public List<CursoEntity> getAll(){
        return this.cursoRepository.findAll();
    }

    public CursoEntity getById(Integer curId){
        return this.cursoRepository.findById(curId).orElse(null);
    }

    @Override
    public CursoEntity save(CursoEntity cursoEntity) {
        return this.cursoRepository.save(cursoEntity);
    }

    public void deleteById(int curId){
        this.cursoRepository.deleteById(curId);
        System.out.println(curId+" Deleted");
    }

    //método para verificar si existe un objeto a través del id
    @Override
    public boolean exists(int curId) {
        return this.cursoRepository.existsById(curId);
    }

}
