package com.weboscrudos.softwaredocbuilder.responses.Usuario;
import com.weboscrudos.softwaredocbuilder.models.UsuarioModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioResponse {
    private boolean exito;
    private String mensaje;
    private UsuarioModel usuario;

    public static UsuarioResponse createErrorResponse(String mensaje) {
        UsuarioResponse response = new UsuarioResponse();
        response.setExito(false);
        response.setMensaje(mensaje);
        response.setUsuario(null);
        return response;
    }

    public static UsuarioResponse createSuccessResponse(String mensaje, UsuarioModel usuario) {
        UsuarioResponse response = new UsuarioResponse();
        response.setExito(true);
        response.setMensaje(mensaje);
        response.setUsuario(usuario);
        return response;
    }
}
