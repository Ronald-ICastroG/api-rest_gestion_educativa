package com.escuela.rural.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="asignaturas")
public class AsignaturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="asg_id",columnDefinition = "BIGINT")
    private Long asgId;

    @Column(name="asg_name",nullable = false)
    private String asgName;

    @Column(name="asg_active",columnDefinition = "TINYINT",nullable = false,updatable = false)
    private Boolean asgActive;

    @ManyToOne(targetEntity = CursoEntity.class,fetch = FetchType.LAZY)
    private CursoEntity curso;
 }
