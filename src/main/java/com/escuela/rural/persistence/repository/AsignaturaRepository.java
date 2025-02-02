package com.escuela.rural.persistence.repository;

import com.escuela.rural.persistence.entity.AsignaturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<AsignaturaEntity,Long> {
}
