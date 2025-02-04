package com.escuela.rural.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name="asg_id",columnDefinition = "BIGINT(10)")
    private Long asgId;

    @Column(name="asg_name",nullable = false)
    private String asgName;

    @Column(name="asg_active",columnDefinition = "TINYINT",nullable = false,updatable = false)
    private Boolean asgActive;

    @Column(name="cur_id",nullable=false)
    private Integer asgCurid;

    @ManyToOne(targetEntity = CursoEntity.class,fetch = FetchType.LAZY)
    @JoinColumn(name="cur_id",referencedColumnName = "cur_id",insertable = false,updatable = false)
    @JsonIgnore
    private CursoEntity curso;
 }
