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
}

