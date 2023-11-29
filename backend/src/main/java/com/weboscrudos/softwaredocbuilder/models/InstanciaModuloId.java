package com.weboscrudos.softwaredocbuilder.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class InstanciaModuloId implements Serializable {
    private Long moduloId;
    private String ano;
    private int semestre;
}

