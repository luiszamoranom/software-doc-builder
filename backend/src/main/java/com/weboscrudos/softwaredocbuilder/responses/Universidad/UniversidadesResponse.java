package com.weboscrudos.softwaredocbuilder.responses.Universidad;

import com.weboscrudos.softwaredocbuilder.models.UniversidadModel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class UniversidadesResponse {
    private boolean exito;
    private String mensaje;

    private ArrayList<UniversidadModel> universidades;

    public UniversidadesResponse() {
    }
}

