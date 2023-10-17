package com.weboscrudos.softwaredocbuilder.responses.RolPlataforma;

import com.weboscrudos.softwaredocbuilder.models.RolPlataformaModel;

public class RolPlataformaResponse {
    private boolean exito;
    private String mensaje;

    private RolPlataformaModel rol;

    public RolPlataformaResponse() {
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

    public RolPlataformaModel getRol() {
        return rol;
    }

    public void setRol(RolPlataformaModel rol) {
        this.rol = rol;
    }
}
