package com.weboscrudos.softwaredocbuilder.responses.UsuarioUniversidadRol;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import com.weboscrudos.softwaredocbuilder.models.UsuarioUniversidadRolModel;

@Getter
@Setter
@NoArgsConstructor
public class ListaUsuarioUniversidadRolResponse {
    private boolean exito;
    private String mensaje;
    private ArrayList<UsuarioUniversidadRolModel> lista;

    public static ListaUsuarioUniversidadRolResponse createErrorResponse(String mensaje) {
        ListaUsuarioUniversidadRolResponse response = new ListaUsuarioUniversidadRolResponse();
        response.setExito(false);
        response.setMensaje(mensaje);
        response.setLista(null);
        return response;
    }

    public static ListaUsuarioUniversidadRolResponse createSuccessResponse(String mensaje, ArrayList<UsuarioUniversidadRolModel> lista) {
        ListaUsuarioUniversidadRolResponse response = new ListaUsuarioUniversidadRolResponse();
        response.setExito(true);
        response.setMensaje(mensaje);
        response.setLista(lista);
        return response;
    }
}
