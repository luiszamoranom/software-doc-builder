package com.weboscrudos.softwaredocbuilder.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="usuario")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "rut")
public class UsuarioModel {

    @Id
    private String rut;

    @Column
    private String nombres;

    @Column
    private String apellidos;

    @Column
    private String contrasena;

    @Column
    private String email;

    @Column
    private boolean estado = true;

    @Column
    private String rol_plataforma="Usuario";

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioUniversidadRolModel> usuarioUniversidadRoles = new ArrayList<>();
}
