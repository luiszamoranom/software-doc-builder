package com.weboscrudos.softwaredocbuilder.responses.Usuario;

import com.weboscrudos.softwaredocbuilder.models.UsuarioModel;

import java.util.ArrayList;

public class UsuarioResponses {
    private boolean exito;
    private String mensaje;

    private ArrayList<UsuarioModel> usuarios;

    public UsuarioResponses() {
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

    public ArrayList<UsuarioModel> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<UsuarioModel> usuarios) {
        this.usuarios = usuarios;
    }
}
