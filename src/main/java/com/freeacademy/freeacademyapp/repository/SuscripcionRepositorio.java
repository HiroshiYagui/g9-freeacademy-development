package com.freeacademy.freeacademyapp.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freeacademy.freeacademyapp.model.Suscripcion;

@Repository
public interface SuscripcionRepositorio extends JpaRepository<Suscripcion,Long> {
    
    @Query(value="select s.id_suscripcion from suscripcion s order by id_suscripcion desc limit 1" , nativeQuery=true)
    Optional<Long> findTopByOrderByidSuscripcionDesc();

    Optional<List<Suscripcion>> findByusuario_idUsuario(Long id);
}
