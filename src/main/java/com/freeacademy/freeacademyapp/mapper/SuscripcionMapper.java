package com.freeacademy.freeacademyapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.freeacademy.freeacademyapp.dto.SuscripcionRequest;
import com.freeacademy.freeacademyapp.dto.SuscripcionResponse;
import com.freeacademy.freeacademyapp.model.Suscripcion;

@Mapper(componentModel = "spring")
public abstract class SuscripcionMapper {
    
    
    public abstract Suscripcion map(SuscripcionRequest suscripcionRequest);

    @Mapping(target = "idCurso",source = "curso.idCurso")
    @Mapping(target = "idUsuario",source = "usuario.idUsuario")
    @Mapping(target = "nombreCurso",source = "curso.nombre")
    @Mapping(target = "nombreUsuario",source = "usuario.nombre")
    public abstract  SuscripcionResponse mapToDto(Suscripcion suscripcion);
}
