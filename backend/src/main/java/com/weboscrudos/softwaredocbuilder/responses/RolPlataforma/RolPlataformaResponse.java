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
}
