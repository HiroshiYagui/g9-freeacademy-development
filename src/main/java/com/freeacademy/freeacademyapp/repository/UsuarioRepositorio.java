package com.freeacademy.freeacademyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freeacademy.freeacademyapp.model.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {
    
}
