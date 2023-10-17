package com.weboscrudos.softwaredocbuilder.responses.Usuario;

import com.weboscrudos.softwaredocbuilder.models.UsuarioModel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class UsuarioResponses {
    private boolean exito;
    private String mensaje;

    private ArrayList<UsuarioModel> usuarios;

    public UsuarioResponses() {
    }
}
