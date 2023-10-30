package com.weboscrudos.softwaredocbuilder.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="usuario_universidad_rol")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UsuarioUniversidadRolModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    private UsuarioModel usuario;

    @ManyToOne
    @JsonBackReference
    private UniversidadModel universidad;

    @ManyToOne
    @JsonBackReference
    private RolPlataformaModel rol;

    @Column
    private boolean estado = true;
}
