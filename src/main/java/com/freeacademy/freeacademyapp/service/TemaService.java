package com.freeacademy.freeacademyapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freeacademy.freeacademyapp.dto.TemaDto;
import com.freeacademy.freeacademyapp.dto.TemaRequestDto;
import com.freeacademy.freeacademyapp.exception.NotFoundException;
import com.freeacademy.freeacademyapp.mapper.TemaMapper;
import com.freeacademy.freeacademyapp.model.Curso;
import com.freeacademy.freeacademyapp.model.Tema;
import com.freeacademy.freeacademyapp.repository.TemaRepositorio;
import com.freeacademy.freeacademyapp.repository.CursoRepositorio;
import com.freeacademy.freeacademyapp.repository.MaterialRepositorio;
import com.freeacademy.freeacademyapp.repository.PracticaRepositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class TemaService {
    
    @Autowired
    private TemaRepositorio temaRepositorio;
    @Autowired
    private CursoRepositorio cursoRepositorio;
    @Autowired
    private MaterialRepositorio materialRepositorio;
    @Autowired
    private PracticaRepositorio practicaRepositorio;
    @Autowired
    private TemaMapper temaMapper;
    
    
    @Transactional(readOnly = true)
    public List<TemaDto> buscarTemas() {
        return temaRepositorio.findAll().
        stream().
        map(temaMapper::mapToDto).
        collect(toList());
    }
    
    @Transactional(readOnly=true)
    public TemaDto buscarporId(Long id)
    {
        Tema tema=temaRepositorio.findById(id)
                    .orElseThrow(() -> new NotFoundException(id.toString()));
        return temaMapper.mapToDto(tema);
        
    }


    @Transactional
    public void crear(TemaRequestDto temaRequestDto){
        Curso curso=cursoRepositorio.findById(temaRequestDto.getIdCurso())
                                        .orElseThrow(()-> new NotFoundException("Curso "+temaRequestDto.getIdCurso()+" no encontrado"));
        Tema tema=new Tema();
        tema.setCurso(curso);
        tema.setDuracion(temaRequestDto.getDuracion());
        tema.setImagen_url(temaRequestDto.getImagen_url());
        tema.setTipo(temaRequestDto.getTipo());
        tema.setTitulo(temaRequestDto.getTitulo());
        temaRepositorio.save(tema);
    }


    @Transactional
    public void actualizar(TemaRequestDto temaDto,Long id){
        Tema tema=temaRepositorio.findById(id)
                    .orElseThrow(() -> new NotFoundException(id.toString()));
        temaMapper.UpdateFromDto(temaDto, tema);
        temaRepositorio.save(tema);
    }

    @Transactional
    public TemaDto eliminar(Long id)
    {
        Tema tema=temaRepositorio.findById(id)
                    .orElseThrow(() -> new NotFoundException(id.toString()));
        temaRepositorio.deleteById(id);
        practicaRepositorio.deleteBytema_idTema(id);
        materialRepositorio.deleteBytema_idTema(id);
        return temaMapper.mapToDto(tema);
    }
}
