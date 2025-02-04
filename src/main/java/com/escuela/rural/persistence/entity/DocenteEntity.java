package com.escuela.rural.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="docentes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocenteEntity {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="doc_id",columnDefinition = "BIGINT(10)",nullable = false)
    private Long docId;
    @Column(name="doc_name",columnDefinition = "VARCHAR(60)",nullable = false)
    private String docName;
    @Column(name="doc_lastname",columnDefinition = "VARCHAR(60)",nullable = false)
    private String docLname;
    @Column(name="doc_email",columnDefinition ="VARCHAR(100)",unique = true,nullable = false)
    private String docEmail;
    @Column(name="doc_profession",columnDefinition = "VARCHAR(80)",nullable = false)
    private String docProfession;
    @Column(name="doc_escolarity",columnDefinition = "VARCHAR(100)",nullable = false)
    private String docEscolarity;

    @OneToMany(targetEntity = AsignaturaEntity.class,mappedBy = "docente",fetch =FetchType.LAZY)
    private List<AsignaturaEntity>asignaturas;
}
