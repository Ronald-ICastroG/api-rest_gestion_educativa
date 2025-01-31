package com.escuela.rural.persistence.repository;

import com.escuela.rural.persistence.entity.CursoEntity;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoPagSortRepository extends ListPagingAndSortingRepository<CursoEntity,Integer> {
}
