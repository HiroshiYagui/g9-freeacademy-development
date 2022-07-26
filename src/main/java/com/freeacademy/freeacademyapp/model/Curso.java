package com.freeacademy.freeacademyapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Builder
public class Curso {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long idCurso;

    String nombre;
    String profesor;
    String descripcion;

}