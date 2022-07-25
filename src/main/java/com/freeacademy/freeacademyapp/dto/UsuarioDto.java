package com.freeacademy.freeacademyapp.dto;

import lombok.Data;

@Data
public class UsuarioDto {
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private int edad;
    private String correo_electronico;
    private String contraseña;
}
