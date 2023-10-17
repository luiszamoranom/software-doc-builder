package com.weboscrudos.softwaredocbuilder.responses.RolPlataforma;

import com.weboscrudos.softwaredocbuilder.models.RolPlataformaModel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class RolesPlataformaResponse {
    private boolean exito;
    private String mensaje;

    private ArrayList<RolPlataformaModel> roles;

    public RolesPlataformaResponse() {
    }
}

