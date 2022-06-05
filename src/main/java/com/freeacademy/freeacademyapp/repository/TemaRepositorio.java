package com.freeacademy.freeacademyapp.repository;

import com.freeacademy.freeacademyapp.model.Tema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TemaRepositorio extends JpaRepository<Tema,Long> {
    
}
