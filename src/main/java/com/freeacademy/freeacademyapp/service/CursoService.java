package com.freeacademy.freeacademyapp.service;

import java.util.List;

import com.freeacademy.freeacademyapp.dto.CursoDto;
import com.freeacademy.freeacademyapp.exception.NotFoundException;
import com.freeacademy.freeacademyapp.mapper.CursoMapper;
import com.freeacademy.freeacademyapp.model.Curso;
import com.freeacademy.freeacademyapp.repository.CursoRepositorio;

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
