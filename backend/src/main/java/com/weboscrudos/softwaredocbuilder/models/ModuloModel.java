package com.weboscrudos.softwaredocbuilder.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "modulo")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nombre")
public class ModuloModel {
    @Id
    @Column
    private String nombre;

    @Column
    private Boolean estado=true;

    @Column
    private String descripcion;
    
    @ManyToOne
    @JoinColumn(name = "universidad_abreviacion")
    @JsonIgnore
    private UniversidadModel universidad;

    @OneToMany
    @JsonManagedReference
    private List<InstanciaModulo> instancias;
}
