package com.weboscrudos.softwaredocbuilder.responses.Universidad;

import com.weboscrudos.softwaredocbuilder.models.UniversidadModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class UniversidadesResponse {
    private boolean exito;
    private String mensaje;
    private ArrayList<UniversidadModel> universidades;

    public static UniversidadesResponse createErrorResponse(String mensaje) {
        UniversidadesResponse response = new UniversidadesResponse();
        response.setExito(false);
        response.setMensaje(mensaje);
        response.setUniversidades(null);
        return response;
    }

    public static UniversidadesResponse createSuccessResponse(String mensaje, ArrayList<UniversidadModel> universidades) {
        UniversidadesResponse response = new UniversidadesResponse();
        response.setExito(true);
        response.setMensaje(mensaje);
        response.setUniversidades(universidades);
        return response;
    }
}

