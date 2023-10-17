package com.weboscrudos.softwaredocbuilder.responses.Universidad;

import com.weboscrudos.softwaredocbuilder.models.UniversidadModel;

import java.util.ArrayList;

public class UniversidadesResponse {
    private boolean exito;
    private String mensaje;

    private ArrayList<UniversidadModel> universidades;

    public UniversidadesResponse() {
    }

    public boolean isExito() {
        return exito;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ArrayList<UniversidadModel> getUniversidades() {
        return universidades;
    }

    public void setUniversidades(ArrayList<UniversidadModel> universidades) {
        this.universidades = universidades;
    }
}

