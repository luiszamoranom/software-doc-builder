package com.weboscrudos.softwaredocbuilder.responses.Usuario;

import com.weboscrudos.softwaredocbuilder.models.UsuarioModel;

public class UsuarioResponse {
    private boolean exito;
    private String mensaje;

    private UsuarioModel usuario;

    public UsuarioResponse() {
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

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}
