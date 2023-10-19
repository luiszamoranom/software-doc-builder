package com.weboscrudos.softwaredocbuilder.responses.RolPlataforma;
import com.weboscrudos.softwaredocbuilder.models.RolPlataformaModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RolPlataformaResponse {
    private boolean exito;
    private String mensaje;
    private RolPlataformaModel rol;

    public static RolPlataformaResponse createSuccessResponse(String mensaje, RolPlataformaModel rol) {
        RolPlataformaResponse response = new RolPlataformaResponse();
        response.setExito(true);
        response.setMensaje(mensaje);
        response.setRol(rol);
        return response;
    }

    public static RolPlataformaResponse createErrorResponse(String mensaje) {
        RolPlataformaResponse response = new RolPlataformaResponse();
        response.setExito(false);
        response.setMensaje(mensaje);
        response.setRol(null);
        return response;
    }
}
