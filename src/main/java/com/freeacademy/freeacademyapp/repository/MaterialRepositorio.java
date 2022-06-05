package com.freeacademy.freeacademyapp.repository;

import com.freeacademy.freeacademyapp.model.Material;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepositorio extends JpaRepository<Material,Long> {
    Optional<Material> findById(Long id);
}
