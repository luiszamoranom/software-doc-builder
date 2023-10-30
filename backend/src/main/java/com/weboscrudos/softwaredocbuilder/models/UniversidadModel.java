package com.weboscrudos.softwaredocbuilder.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Getter
@Setter
@Table(name="universidad")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "abreviacion")
public class UniversidadModel {

    @Id
    private String abreviacion;

    @Column
    private String nombre;

    @Column
    private boolean estado=true;

    @OneToMany(mappedBy = "universidad")
    @JsonIdentityReference(alwaysAsId = true)
    private List<UsuarioUniversidadRolModel> usuarioUniversidadRoles = new ArrayList<>();

    @OneToMany(mappedBy = "universidad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModuloModel> modulos = new ArrayList<>();
}
