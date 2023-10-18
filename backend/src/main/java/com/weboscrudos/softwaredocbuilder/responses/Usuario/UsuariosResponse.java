package com.weboscrudos.softwaredocbuilder.responses.Usuario;
import com.weboscrudos.softwaredocbuilder.models.UsuarioModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class UsuariosResponse {
    private boolean exito;
    private String mensaje;
    private ArrayList<UsuarioModel> usuarios;

    public static UsuariosResponse createErrorResponse(String mensaje) {
        UsuariosResponse response = new UsuariosResponse();
        response.setExito(false);
        response.setMensaje(mensaje);
        response.setUsuarios(null);
        return response;
    }

    public static UsuariosResponse createSuccessResponse(String mensaje, ArrayList<UsuarioModel> usuarios) {
        UsuariosResponse response = new UsuariosResponse();
        response.setExito(true);
        response.setMensaje(mensaje);
        response.setUsuarios(usuarios);
        return response;
    }
}
