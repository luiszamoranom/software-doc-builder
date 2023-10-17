package com.weboscrudos.softwaredocbuilder.responses.Usuario;

import com.weboscrudos.softwaredocbuilder.models.UsuarioModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponse {
    private boolean exito;
    private String mensaje;

    private UsuarioModel usuario;

    public UsuarioResponse() {
    }
}
