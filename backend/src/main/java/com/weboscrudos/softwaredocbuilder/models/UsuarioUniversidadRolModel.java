package com.weboscrudos.softwaredocbuilder.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="usuario_universidad_rol")
public class UsuarioUniversidadRolModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UsuarioModel usuario;

    @ManyToOne
    private UniversidadModel universidad;

    @ManyToOne
    private RolPlataformaModel rol;

    @Column
    private boolean estado = true;
}
