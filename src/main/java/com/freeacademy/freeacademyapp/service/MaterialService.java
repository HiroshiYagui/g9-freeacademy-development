package com.freeacademy.freeacademyapp.service;

import java.util.List;

import com.freeacademy.freeacademyapp.dto.MaterialDto;
import com.freeacademy.freeacademyapp.dto.MaterialReproDto;
import com.freeacademy.freeacademyapp.dto.MaterialRequestDto;
import com.freeacademy.freeacademyapp.exception.NotFoundException;
import com.freeacademy.freeacademyapp.mapper.MaterialMapper;
import com.freeacademy.freeacademyapp.model.Material;
import com.freeacademy.freeacademyapp.model.Tema;
import com.freeacademy.freeacademyapp.repository.MaterialRepositorio;
import com.freeacademy.freeacademyapp.repository.TemaRepositorio;

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
    @Autowired
    private TemaRepositorio temaRepositorio;

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

    @Transactional
    public void crear(MaterialRequestDto materialRequestDto){
        Tema tema=temaRepositorio.findById(materialRequestDto.getIdtema())
                                        .orElseThrow(()-> new NotFoundException("Curso "+materialRequestDto.getIdtema()+" no encontrado"));
        Material material= Material.builder()
                            .enlace(materialRequestDto.getEnlace())
                            .tema(tema)
                            .tipoMaterial(materialRequestDto.getTipoMaterial())
                            .build();
        materialRepositorio.save(material);
    }


    @Transactional
    public void actualizar(MaterialRequestDto materialDto,Long id){
        Material material=materialRepositorio.findById(id)
                    .orElseThrow(() -> new NotFoundException(id.toString()));
        materialMapper.UpdateFromDto(materialDto, material);
        materialRepositorio.save(material);
    }

    @Transactional
    public MaterialDto eliminar(Long id)
    {
        Material material=materialRepositorio.findById(id)
                    .orElseThrow(() -> new NotFoundException(id.toString()));
        materialRepositorio.deleteById(id);
        return materialMapper.mapToresponseDto(material);
    }

}
