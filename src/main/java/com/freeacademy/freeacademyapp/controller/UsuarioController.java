package com.freeacademy.freeacademyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freeacademy.freeacademyapp.dto.UsuarioDto;
import com.freeacademy.freeacademyapp.service.UsuarioService;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = {"*"})
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/usuario/{id}")
    public ResponseEntity<UsuarioDto> ObtenerUsuario(@PathVariable Long id){
        return status(HttpStatus.OK).body(usuarioService.obtenerUsuario(id));
    }
}
