package com.weboscrudos.softwaredocbuilder.responses.Universidad;

import com.weboscrudos.softwaredocbuilder.models.UniversidadModel;

public class UniversidadResponse {
    private boolean exito;
    private String mensaje;

    private UniversidadModel universidad;

    public UniversidadResponse() {
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

    public UniversidadModel getUniversidad() {
        return universidad;
    }

    public void setUniversidad(UniversidadModel universidad) {
        this.universidad = universidad;
    }
}
