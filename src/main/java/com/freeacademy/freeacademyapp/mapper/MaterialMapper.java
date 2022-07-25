package com.freeacademy.freeacademyapp.mapper;

import com.freeacademy.freeacademyapp.dto.MaterialDto;
import com.freeacademy.freeacademyapp.dto.MaterialReproDto;
import com.freeacademy.freeacademyapp.dto.MaterialRequestDto;
import com.freeacademy.freeacademyapp.model.Material;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

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


    @Mapping(target = "id",source = "idMaterial")
    @Mapping(target= "nombretema" , source = "tema.titulo") 
    public abstract  MaterialDto mapToresponseDto(Material material);

    public abstract void UpdateFromDto(MaterialRequestDto materialDto, @MappingTarget Material material);
}
