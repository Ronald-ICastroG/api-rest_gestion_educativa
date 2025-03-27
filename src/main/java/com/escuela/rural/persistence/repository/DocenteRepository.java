package com.escuela.rural.persistence.repository;

import com.escuela.rural.persistence.entity.DocenteEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends JpaRepository<DocenteEntity,Long> {
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM docentes d WHERE d.doc_name = :docName",nativeQuery = true)
    void deleteByDocName(@Param("docName")String docName);
}
