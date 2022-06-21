package com.freeacademy.freeacademyapp.repository;

import com.freeacademy.freeacademyapp.model.Material;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepositorio extends JpaRepository<Material,Long> {
    Optional<Material> findById(Long id);

    Optional<List<Material>> findBytema_curso_idCurso(Long id);  
}
