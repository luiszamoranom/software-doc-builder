package com.weboscrudos.softwaredocbuilder.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Getter
@Setter
@Table(name="universidad")
public class UniversidadModel {

    @Id
    private String abreviacion;

    @Column
    private String nombre;

    @Column
    private boolean estado=true;

    @OneToMany(mappedBy = "universidad")
    @JsonManagedReference
    private List<UsuarioUniversidadRolModel> usuarioUniversidadRoles = new ArrayList<>();
}
