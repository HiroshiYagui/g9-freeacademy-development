package com.freeacademy.freeacademyapp.mapper;

import java.sql.Date;
import java.sql.Timestamp;

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
    @Mapping(target = "fecha",expression =  "java(obtenerFecha(suscripcion.getFechaSuscripcion()))")
    public abstract  SuscripcionResponse mapToDto(Suscripcion suscripcion);

    public abstract  SuscripcionRequest mapToDtoRequest(Suscripcion suscripcion);

    Date obtenerFecha(Timestamp timestamp){
        return new Date(timestamp.getTime());
    }
}
