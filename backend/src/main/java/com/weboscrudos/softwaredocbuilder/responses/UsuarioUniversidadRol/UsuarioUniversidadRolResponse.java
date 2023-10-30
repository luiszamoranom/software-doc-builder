package com.weboscrudos.softwaredocbuilder.responses.UsuarioUniversidadRol;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import com.weboscrudos.softwaredocbuilder.models.UsuarioUniversidadRolModel;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioUniversidadRolResponse {
    private boolean exito;
    private String mensaje;
    private UsuarioUniversidadRolModel usuarioUniversidadRolModel;

    public static UsuarioUniversidadRolResponse createErrorResponse(String mensaje) {
        UsuarioUniversidadRolResponse response = new UsuarioUniversidadRolResponse();
        response.setExito(false);
        response.setMensaje(mensaje);
        response.setUsuarioUniversidadRolModel(null);
        return response;
    }

    public static UsuarioUniversidadRolResponse createSuccessResponse(String mensaje, UsuarioUniversidadRolModel usuarioUniversidadRolModel) {
        UsuarioUniversidadRolResponse response = new UsuarioUniversidadRolResponse();
        response.setExito(true);
        response.setMensaje(mensaje);
        response.setUsuarioUniversidadRolModel(usuarioUniversidadRolModel);
        return response;
    }
}
