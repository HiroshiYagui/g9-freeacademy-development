package com.librepre.librepreapp.controller;
import com.librepre.librepreapp.dto.CursoDto;
import com.librepre.librepreapp.service.CursoService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class CursosController {
    @Autowired
    private CursoService cursoService;

    @GetMapping("/curso")
    public ResponseEntity<List<CursoDto>> ConsultaCurso(){
        return status(HttpStatus.OK).body(cursoService.buscarCursos());
    }

    @GetMapping("/cursos/{id}")
    public ResponseEntity<CursoDto> ConsultarporId(@PathVariable Long id){
        return status(HttpStatus.OK).body(cursoService.buscarporId(id));
    }

    @PostMapping("/cursos")
    public ResponseEntity<CursoDto> crear(@RequestBody CursoDto request){
        cursoService.crear(request);
        return status(HttpStatus.CREATED).body(request);
    }

    @PutMapping("/cursos/{id}")
    public ResponseEntity<CursoDto> actualizar(@RequestBody CursoDto request, @PathVariable long id){
        cursoService.actualizar(request, id);
        return status(HttpStatus.OK).body(request);
    }

    @DeleteMapping("/cursos/{id}")
    public ResponseEntity<CursoDto> eliminar(@PathVariable Long id){
        return status(HttpStatus.OK).body(cursoService.eliminar(id));
    }
}
