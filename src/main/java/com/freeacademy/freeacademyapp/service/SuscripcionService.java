package com.freeacademy.freeacademyapp.service;

import org.springframework.transaction.annotation.Transactional;

import com.freeacademy.freeacademyapp.dto.SuscripcionCreadaDto;
import com.freeacademy.freeacademyapp.dto.SuscripcionRequest;
import com.freeacademy.freeacademyapp.dto.SuscripcionResponse;
import com.freeacademy.freeacademyapp.exception.NotFoundException;
import com.freeacademy.freeacademyapp.mapper.SuscripcionMapper;
import com.freeacademy.freeacademyapp.model.Curso;
import com.freeacademy.freeacademyapp.model.Practica;
import com.freeacademy.freeacademyapp.model.Suscripcion;
import com.freeacademy.freeacademyapp.model.Tema;
import com.freeacademy.freeacademyapp.model.Usuario;
import com.freeacademy.freeacademyapp.repository.CursoRepositorio;
import com.freeacademy.freeacademyapp.repository.PracticaRepositorio;
import com.freeacademy.freeacademyapp.repository.SuscripcionRepositorio;
import com.freeacademy.freeacademyapp.repository.TemaRepositorio;
import com.freeacademy.freeacademyapp.repository.UsuarioRepositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.toList;

import java.sql.Timestamp;

@Service
@Transactional
public class SuscripcionService {
    
    @Autowired
    private  SuscripcionRepositorio suscripcionRepositorio;
    @Autowired
    private CursoRepositorio cursoRepositorio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private TemaRepositorio temaRepositorio;   
    @Autowired
    private PracticaRepositorio practicaRepositorio;    
    @Autowired
    private  SuscripcionMapper suscripcionMapper;

    @Transactional(readOnly = true)
    public List<SuscripcionResponse> buscarSuscripciones() {
        return suscripcionRepositorio.findAll().
        stream().
        map(suscripcionMapper::mapToDto).
        collect(toList());
    }

    @Transactional(readOnly = true)
    public List<SuscripcionResponse> buscarSuscripcionesporUsuario(Long id) {
        
        List<Suscripcion> suscripciones=suscripcionRepositorio.findByusuario_idUsuario(id)
                                        .orElseThrow(()->new NotFoundException(id.toString()) );
        
        return suscripciones.
        stream().
        map(suscripcionMapper::mapToDto).
        collect(toList());
    }


    @Transactional(readOnly=true)
    public SuscripcionResponse buscarporId(Long id)
    {
        Suscripcion suscripcion=suscripcionRepositorio.findById(id)
                    .orElseThrow(() -> new NotFoundException(id.toString()));
        return suscripcionMapper.mapToDto(suscripcion);
        
    }

    @Transactional
    public SuscripcionCreadaDto crear(SuscripcionRequest suscripcionDto){
        Usuario usuario=usuarioRepositorio.findById(suscripcionDto.getIdUsuario())
                        .orElseThrow(() -> new NotFoundException(suscripcionDto.getIdUsuario().toString()));
        Curso curso=cursoRepositorio.findById(suscripcionDto.getIdCurso())
                        .orElseThrow(() -> new NotFoundException(suscripcionDto.getIdCurso().toString()));

        Suscripcion suscripcion=new Suscripcion();
        suscripcion.setCurso(curso);
        suscripcion.setUsuario(usuario);
        suscripcion.setFechaSuscripcion(new Timestamp(System.currentTimeMillis()));             
        suscripcionRepositorio.save(suscripcion);

        List<Tema> listaTemas=temaRepositorio.findAllBycurso_idCurso(suscripcionDto.getIdCurso());

        Long idultSuscripcion=suscripcionRepositorio.findTopByOrderByidSuscripcionDesc()
                    .orElseThrow(()->new NotFoundException("No hay suscripciones"));

        Suscripcion ultSuscripcion=suscripcionRepositorio.findById(idultSuscripcion)
                    .orElseThrow(()->new NotFoundException("No hay suscripciones"));



        for(Tema tema:listaTemas){

            Practica practica=new Practica();
            practica.setSuscripcion(ultSuscripcion);
            practica.setTema(tema);
            practica.setCalificacion(0);
            practica.setEstado("No aprobado");

            practicaRepositorio.save(practica);
        }
        
        SuscripcionCreadaDto suscripcionCreadaDto=new SuscripcionCreadaDto();
        suscripcionCreadaDto.setEstado("Creado Correctamente");

        return suscripcionCreadaDto;

        
    }

}
