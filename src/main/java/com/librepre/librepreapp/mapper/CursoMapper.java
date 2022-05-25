package com.librepre.librepreapp.mapper;

import com.librepre.librepreapp.dto.CursoDto;
import com.librepre.librepreapp.model.Curso;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public interface CursoMapper {

    public abstract Curso map(CursoDto cursoDto);

    public abstract  CursoDto mapToDto(Curso curso);

    public void UpdateFromDto(CursoDto cursoDto, @MappingTarget Curso curso);
}
