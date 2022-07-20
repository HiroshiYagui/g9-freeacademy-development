package com.freeacademy.freeacademyapp.repository;

import com.freeacademy.freeacademyapp.model.Tema;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TemaRepositorio extends JpaRepository<Tema,Long> {
    
    List<Tema> findAllBycurso_idCurso(Long idCurso);
    void deleteBycurso_idCurso(Long idCurso);
}
