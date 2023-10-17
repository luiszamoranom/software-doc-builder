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
}
