package com.devrenan.jdevcurso.model;

import jakarta.persistence.*;

@Entity
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String numero;

    @ManyToOne
    private Usuario usuario;

}
