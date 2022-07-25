package com.freeacademy.freeacademyapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.freeacademy.freeacademyapp.dto.TemaDto;
import com.freeacademy.freeacademyapp.dto.TemaRequestDto;
import com.freeacademy.freeacademyapp.model.Tema;

@Mapper(componentModel="spring")
public abstract class TemaMapper {

    public abstract Tema map(TemaDto temaDto);

    @Mapping(target = "id",source = "idTema")
    @Mapping(target = "nombreCurso",source= "curso.nombre")
    public abstract  TemaDto mapToDto(Tema tema);

    public abstract void UpdateFromDto(TemaRequestDto temaDto, @MappingTarget Tema tema);
}
