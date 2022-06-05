package com.freeacademy.freeacademyapp.model;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.FetchType.LAZY;

@Data
@Entity
public class Tema {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long idTema;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "idCurso" , referencedColumnName = "idCurso")
    private Curso curso;
    private String imagen_url;
    private String titulo;
    private Time duracion;
    private String tipo;


}
