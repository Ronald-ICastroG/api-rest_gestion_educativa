package com.escuela.rural.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@Data
@NoArgsConstructor
@Table(name="cursos")
@Entity
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cur_id",nullable = false)
    private Integer curId;

    @Column(name="cur_name",length = 60,nullable = false)
    private String curName;

    @Column(name="cur_cupo")
    private Integer curCupo;

    @Column(name="cur_active",columnDefinition = "TINYINT(1)")
    private Boolean curActive;

    @OneToMany(targetEntity = AsignaturaEntity.class,mappedBy = "curso",fetch = FetchType.LAZY)
    private List<AsignaturaEntity> asignaturas;

}
