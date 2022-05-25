package com.librepre.librepreapp.repository;

import org.springframework.stereotype.Repository;

import com.librepre.librepreapp.model.Curso;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CursoRepositorio extends JpaRepository<Curso,Long>{
    
}
