package com.freeacademy.freeacademyapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freeacademy.freeacademyapp.dto.UsuarioDto;
import com.freeacademy.freeacademyapp.exception.NotFoundException;
import com.freeacademy.freeacademyapp.mapper.UsuarioMapper;
import com.freeacademy.freeacademyapp.model.Usuario;
import com.freeacademy.freeacademyapp.repository.UsuarioRepositorio;

@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private UsuarioMapper usuarioMapper;

    public UsuarioDto obtenerUsuario(Long id){
        Usuario usuario=usuarioRepositorio.findById(id)
                        .orElseThrow(()-> new NotFoundException("no se encontro usuario "+id));
        return usuarioMapper.mapToDto(usuario);
        
    }

}
