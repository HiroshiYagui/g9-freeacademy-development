package com.freeacademy.freeacademyapp.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class SuscripcionResponse {
    
    private Long idSuscripcion;
    private Long idCurso;
    private Long idUsuario;
    private String nombreCurso;
    private String descripcion;
    private String imagen_url;
    private String nombreUsuario;
    private Date fecha;
}
