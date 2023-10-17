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
}
