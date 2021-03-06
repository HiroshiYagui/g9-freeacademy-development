package com.freeacademy.freeacademyapp.dto;

import java.sql.Time;

import lombok.Data;

@Data
public class TemaDto {
    private Long id;
    private String imagen_url;
    private String titulo;
    private Time duracion;
    private String tipo;
    private String nombreCurso;
}
