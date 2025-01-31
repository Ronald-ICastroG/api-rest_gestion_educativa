package com.escuela.rural.persistence.repository;

import com.escuela.rural.persistence.entity.CursoEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends ListCrudRepository<CursoEntity,Integer> {
}
