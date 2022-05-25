package com.freeacademy.freeacademyapp.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Practica {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long idPractica;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "idTema" , referencedColumnName = "idTema")
    private Tema tema;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "idSuscripcion" , referencedColumnName = "idSuscripcion")
    private Suscripcion suscripcion;

    private int calificacion;
    private String estado;
}
