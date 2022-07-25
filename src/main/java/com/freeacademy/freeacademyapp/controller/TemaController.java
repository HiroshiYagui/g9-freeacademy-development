package com.freeacademy.freeacademyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freeacademy.freeacademyapp.dto.TemaDto;
import com.freeacademy.freeacademyapp.dto.TemaRequestDto;
import com.freeacademy.freeacademyapp.service.TemaService;

import static org.springframework.http.ResponseEntity.status;

import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = {"*"})
public class TemaController {
    
    @Autowired
    private TemaService temaService;

    @GetMapping("/tema")
    public ResponseEntity<List<TemaDto>> ConsultaTema(){
        return status(HttpStatus.OK).body(temaService.buscarTemas());
    }

    @GetMapping("/temas/{id}")
    public ResponseEntity<TemaDto> ConsultarporId(@PathVariable Long id){
        return status(HttpStatus.OK).body(temaService.buscarporId(id));
    }

    @PostMapping("/temas")
    public ResponseEntity<TemaRequestDto> crear(@RequestBody TemaRequestDto request){
        temaService.crear(request);
        return status(HttpStatus.CREATED).body(request);
    }

    @PutMapping("/temas/{id}")
    public ResponseEntity<TemaRequestDto> actualizar(@RequestBody TemaRequestDto request, @PathVariable long id){
        temaService.actualizar(request, id);
        return status(HttpStatus.OK).body(request);
    }

    @DeleteMapping("/temas/{id}")
    public ResponseEntity<TemaDto> eliminar(@PathVariable Long id){
        return status(HttpStatus.OK).body(temaService.eliminar(id));
    }
}
