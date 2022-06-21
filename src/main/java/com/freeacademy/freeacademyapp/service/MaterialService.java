package com.freeacademy.freeacademyapp.service;

import java.util.List;

import com.freeacademy.freeacademyapp.dto.MaterialReproDto;
import com.freeacademy.freeacademyapp.exception.NotFoundException;
import com.freeacademy.freeacademyapp.mapper.MaterialMapper;
import com.freeacademy.freeacademyapp.model.Material;
import com.freeacademy.freeacademyapp.repository.MaterialRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class MaterialService {

    @Autowired
    private  MaterialRepositorio materialRepositorio;
    @Autowired
    private  MaterialMapper materialMapper;

    @Transactional(readOnly = true)
    public List<MaterialReproDto> buscarMateriales() {
        return materialRepositorio.findAll().
        stream().
        map(materialMapper::mapToDto).
        collect(toList());
    }

    @Transactional(readOnly = true)
    public List<MaterialReproDto> buscarMaterialesporidCurso(Long id) {
        List<Material> materiales=materialRepositorio.findBytema_curso_idCurso(id)
                                    .orElseThrow(()-> new NotFoundException(id.toString()));
        return materiales.
        stream().
        map(materialMapper::mapToDto).
        collect(toList());
    }


    @Transactional(readOnly=true)
    public MaterialReproDto buscarporId(Long id)
    {
        Material material=materialRepositorio.findById(id)
                    .orElseThrow(() -> new NotFoundException(id.toString()));
        return materialMapper.mapToDto(material);
        
    }


}
