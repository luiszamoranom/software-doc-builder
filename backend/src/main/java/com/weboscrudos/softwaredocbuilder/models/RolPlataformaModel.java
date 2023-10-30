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
@Table(name="rol_en_universidad")
public class RolPlataformaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @OneToMany(mappedBy = "rol")
    @JsonManagedReference
    private List<UsuarioUniversidadRolModel> usuarioUniversidadRoles = new ArrayList<>();
}
