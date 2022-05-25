package com.librepre.librepreapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Curso {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long idCurso;

    String nombre;
    String profesor;
    String descripcion;

}