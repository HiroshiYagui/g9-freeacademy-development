package com.freeacademy.freeacademyapp.mapper;

import com.freeacademy.freeacademyapp.dto.CursoDto;
import com.freeacademy.freeacademyapp.model.Curso;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public interface CursoMapper {

    public abstract Curso map(CursoDto cursoDto);

    public abstract  CursoDto mapToDto(Curso curso);

    public void UpdateFromDto(CursoDto cursoDto, @MappingTarget Curso curso);
}
