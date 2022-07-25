package com.freeacademy.freeacademyapp.dto;

import java.sql.Time;

import lombok.Data;

@Data
public class TemaRequestDto {
    private String imagen_url;
    private String titulo;
    private Time duracion;
    private String tipo;
    private Long idCurso;
}
