package com.weboscrudos.softwaredocbuilder.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
    private List<UsuarioUniversidadRolModel> usuarioUniversidadRoles = new ArrayList<>();
}
