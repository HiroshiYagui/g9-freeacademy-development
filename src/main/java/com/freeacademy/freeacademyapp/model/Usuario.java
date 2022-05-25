package com.freeacademy.freeacademyapp.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long idUsuario;

    private String nombre;
    private String apellido;
    private int edad;
    private String correo_electronico;
    private String contraseña;
}
