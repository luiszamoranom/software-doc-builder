package com.weboscrudos.softwaredocbuilder.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
    private List<UsuarioUniversidadRolModel> usuarioUniversidadRoles = new ArrayList<>();
}
