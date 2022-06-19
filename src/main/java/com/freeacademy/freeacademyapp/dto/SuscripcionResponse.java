package com.freeacademy.freeacademyapp.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class SuscripcionResponse {
    
    private Long idSuscripcion;
    private Long idCurso;
    private Long idUsuario;
    private String nombreCurso;
    private String nombreUsuario;
    private Timestamp fechaSuscripcion;
}