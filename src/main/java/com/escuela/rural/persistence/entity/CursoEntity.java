package com.escuela.rural.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cursos")
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cur_id",nullable = false)
    private Integer curId;

    @Column(name="cur_name",length = 60,nullable = false)
    private String curName;

    @Column(name="cur_cupo",nullable = false)
    private Integer curCupo;

    @Column(name="cur_active",columnDefinition = "TINYINT",nullable = false)
    private Boolean curActive;

}
