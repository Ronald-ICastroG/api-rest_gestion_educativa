package com.escuela.rural.persistence.repository;

import com.escuela.rural.persistence.entity.DocenteEntity;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
=======
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
>>>>>>> e26379ea5f0d2d23fec2db92e365e1f03e9ca6ee
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends JpaRepository<DocenteEntity,Long> {
<<<<<<< HEAD

    DocenteEntity findByDocEmail(@Param("doc_email")String docEmail);

=======
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM docentes d WHERE d.doc_name=:doc_name",nativeQuery = true)
    void deleteByDocName(@Param("docName")String docName);
>>>>>>> e26379ea5f0d2d23fec2db92e365e1f03e9ca6ee
}
