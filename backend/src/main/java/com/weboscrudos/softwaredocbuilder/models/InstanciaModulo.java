package com.weboscrudos.softwaredocbuilder.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "instanciamodulo")
public class InstanciaModulo {
    @EmbeddedId
    InstanciaModuloId instanciaModuloId;

}
