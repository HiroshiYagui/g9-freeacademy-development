package com.freeacademy.freeacademyapp.controller;


import static org.springframework.http.ResponseEntity.status;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freeacademy.freeacademyapp.dto.SuscripcionCreadaDto;
import com.freeacademy.freeacademyapp.dto.SuscripcionRequest;
import com.freeacademy.freeacademyapp.dto.SuscripcionResponse;
import com.freeacademy.freeacademyapp.service.SuscripcionService;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = {"*"})
public class SuscripcionController {
    @Autowired
    private SuscripcionService suscripcionService;


    @GetMapping("/suscripciones")
    public ResponseEntity<List<SuscripcionResponse>> ConsultaSuscripcion(){
        return status(HttpStatus.OK).body(suscripcionService.buscarSuscripciones());
    }

    @GetMapping("/suscripciones/{id}")
    public ResponseEntity<SuscripcionResponse> ConsultarporId(@PathVariable Long id){
        return status(HttpStatus.OK).body(suscripcionService.buscarporId(id));
    }

    @PostMapping("/suscribir")
    public ResponseEntity<SuscripcionCreadaDto> crear(@RequestBody SuscripcionRequest request){
        return status(HttpStatus.CREATED).body(suscripcionService.crear(request));
    }
}
