package com.freeacademy.freeacademyapp.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Data;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.FetchType.LAZY;

@Data
@Entity
public class Suscripcion {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long idSuscripcion;

    Timestamp fechaSuscripcion;
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "idCurso" , referencedColumnName = "idCurso")
    private Curso curso;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "idUsuario" , referencedColumnName = "idUsuario")
    private Usuario usuario;
}
