package com.weboscrudos.softwaredocbuilder.responses.Universidad;
import com.weboscrudos.softwaredocbuilder.models.UniversidadModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UniversidadResponse {
    private boolean exito;
    private String mensaje;
    private UniversidadModel universidad;

    public static UniversidadResponse createSuccessResponse(String mensaje, UniversidadModel universidad) {
        UniversidadResponse response = new UniversidadResponse();
        response.setExito(true);
        response.setMensaje(mensaje);
        response.setUniversidad(universidad);
        return response;
    }

    public static UniversidadResponse createErrorResponse(String mensaje) {
        UniversidadResponse response = new UniversidadResponse();
        response.setExito(false);
        response.setMensaje(mensaje);
        response.setUniversidad(null);
        return response;
    }
}
