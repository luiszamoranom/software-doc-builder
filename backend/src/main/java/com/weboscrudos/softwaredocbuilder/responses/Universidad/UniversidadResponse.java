package com.weboscrudos.softwaredocbuilder.responses.Universidad;

import com.weboscrudos.softwaredocbuilder.models.UniversidadModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UniversidadResponse {
    private boolean exito;
    private String mensaje;

    private UniversidadModel universidad;

    public UniversidadResponse() {
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setUniversidad(UniversidadModel universidad) {
        this.universidad = universidad;
    }
}
