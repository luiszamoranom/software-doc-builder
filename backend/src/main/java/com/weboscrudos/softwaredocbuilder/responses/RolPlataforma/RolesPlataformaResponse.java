package com.weboscrudos.softwaredocbuilder.responses.RolPlataforma;

import com.weboscrudos.softwaredocbuilder.models.RolPlataformaModel;

import java.util.ArrayList;

public class RolesPlataformaResponse {
    private boolean exito;
    private String mensaje;

    private ArrayList<RolPlataformaModel> roles;

    public RolesPlataformaResponse() {
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

    public ArrayList<RolPlataformaModel> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<RolPlataformaModel> roles) {
        this.roles = roles;
    }
}

