package com.freeacademy.freeacademyapp.mapper;

import com.freeacademy.freeacademyapp.dto.MaterialReproDto;
import com.freeacademy.freeacademyapp.model.Material;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class MaterialMapper {


    public abstract Material map(MaterialReproDto materialDto);


    @Mapping(target = "titulo",source = "tema.titulo")
    @Mapping(target = "imagen_url",source = "tema.imagen_url")
    @Mapping(target = "duracion",expression =  "java(getTime(material))")
    public abstract  MaterialReproDto mapToDto(Material material);
     Integer getTime(Material material){
        Long time=material.getTema().getDuracion().getTime()/10000;
        return time.intValue();
    }
}
