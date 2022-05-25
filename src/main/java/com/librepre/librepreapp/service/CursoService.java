package com.librepre.librepreapp.service;

import java.util.List;

import com.librepre.librepreapp.dto.CursoDto;
import com.librepre.librepreapp.mapper.CursoMapper;
import com.librepre.librepreapp.model.Curso;
import com.librepre.librepreapp.repository.CursoRepositorio;
import com.librepre.librepreapp.exception.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class CursoService {

    @Autowired
    private  CursoRepositorio cursoRepositorio;
    @Autowired
    private  CursoMapper cursoMapper;


    @Transactional(readOnly = true)
    public List<CursoDto> buscarCursos() {
        return cursoRepositorio.findAll().
        stream().
        map(cursoMapper::mapToDto).
        collect(toList());
    }
    
    @Transactional(readOnly=true)
    public CursoDto buscarporId(Long id)
    {
        Curso curso=cursoRepositorio.findById(id)
                    .orElseThrow(() -> new NotFoundException(id.toString()));
        return cursoMapper.mapToDto(curso);
        
    }


    @Transactional
    public void crear(CursoDto cursoDto){
        cursoRepositorio.save(cursoMapper.map(cursoDto));
    }


    @Transactional
    public void actualizar(CursoDto cursoDto,Long id){
        Curso curso=cursoRepositorio.findById(id)
                    .orElseThrow(() -> new NotFoundException(id.toString()));
        cursoMapper.UpdateFromDto(cursoDto, curso);
        cursoRepositorio.save(curso);
    }

    @Transactional
    public CursoDto eliminar(Long id)
    {
        Curso curso=cursoRepositorio.findById(id)
                    .orElseThrow(() -> new NotFoundException(id.toString()));
        cursoRepositorio.deleteById(id);
        return cursoMapper.mapToDto(curso);
    }
}
