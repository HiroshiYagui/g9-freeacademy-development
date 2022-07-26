package com.freeacademy.freeacademyapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Data;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.FetchType.LAZY;

@Entity
@Data
public class Material {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long idMaterial;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "idTema" , referencedColumnName = "idTema")
    private Tema tema;
    
    private String tipoMaterial;
    private String enlace;
}
