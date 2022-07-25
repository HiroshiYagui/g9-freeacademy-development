package com.freeacademy.freeacademyapp.mapper;

import org.mapstruct.Mapper;

import com.freeacademy.freeacademyapp.dto.UsuarioDto;
import com.freeacademy.freeacademyapp.model.Usuario;

@Mapper(componentModel="spring")
public abstract class UsuarioMapper {
    
    public abstract  UsuarioDto mapToDto(Usuario usuario);
}
