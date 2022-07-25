package com.freeacademy.freeacademyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freeacademy.freeacademyapp.model.Practica;

@Repository
public interface PracticaRepositorio extends JpaRepository<Practica,Long> {
    
    void deleteBysuscripcion_idSuscripcion(Long id);
    void deleteBytema_idTema(Long id);
}
