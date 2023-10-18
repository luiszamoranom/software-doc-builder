package com.weboscrudos.softwaredocbuilder.responses.RolPlataforma;
import com.weboscrudos.softwaredocbuilder.models.RolPlataformaModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class RolesPlataformaResponse {
    private boolean exito;
    private String mensaje;
    private ArrayList<RolPlataformaModel> roles;

    public static RolesPlataformaResponse createErrorResponse(String mensaje) {
        RolesPlataformaResponse response = new RolesPlataformaResponse();
        response.setExito(false);
        response.setMensaje(mensaje);
        response.setRoles(null);
        return response;
    }

    public static RolesPlataformaResponse createSuccessResponse(String mensaje, ArrayList<RolPlataformaModel> roles) {
        RolesPlataformaResponse response = new RolesPlataformaResponse();
        response.setExito(true);
        response.setMensaje(mensaje);
        response.setRoles(roles);
        return response;
    }
}

