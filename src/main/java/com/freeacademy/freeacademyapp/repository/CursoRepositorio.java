package com.freeacademy.freeacademyapp.repository;

import org.springframework.stereotype.Repository;

import com.freeacademy.freeacademyapp.model.Curso;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CursoRepositorio extends JpaRepository<Curso,Long>{
    
}
