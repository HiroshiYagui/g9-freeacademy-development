package com.freeacademy.freeacademyapp.controller;
import java.util.List;

import com.freeacademy.freeacademyapp.dto.MaterialReproDto;
import com.freeacademy.freeacademyapp.service.MaterialService;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.status;


@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = {"*"})
public class MaterialController {
    @Autowired
    private MaterialService materialService;


    @GetMapping("/materials")
    public ResponseEntity<List<MaterialReproDto>> ConsultaMaterial(){
        return status(HttpStatus.OK).body(materialService.buscarMateriales());
    }

    @GetMapping("/curso/materials/{id}")
    public ResponseEntity<List<MaterialReproDto>> ConsultaMaterialporCurso(@PathVariable Long id){
        return status(HttpStatus.OK).body(materialService.buscarMaterialesporidCurso(id));
    }

    @GetMapping("/materials/{id}")
    public ResponseEntity<MaterialReproDto> ConsultarporId(@PathVariable Long id){
        return status(HttpStatus.OK).body(materialService.buscarporId(id));
    }

   
}
