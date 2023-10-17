package com.weboscrudos.softwaredocbuilder.controllers;

import com.weboscrudos.softwaredocbuilder.models.RolPlataformaModel;
import com.weboscrudos.softwaredocbuilder.models.UniversidadModel;
import com.weboscrudos.softwaredocbuilder.models.UsuarioModel;
import com.weboscrudos.softwaredocbuilder.repository.RolPlataformaRepository;
import com.weboscrudos.softwaredocbuilder.responses.RolPlataforma.RolPlataformaResponse;
import com.weboscrudos.softwaredocbuilder.responses.RolPlataforma.RolesPlataformaResponse;
import com.weboscrudos.softwaredocbuilder.responses.Universidad.UniversidadesResponse;
import com.weboscrudos.softwaredocbuilder.services.RolPlataformaService;
import com.weboscrudos.softwaredocbuilder.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/rol_plataforma")
public class RolPlataformaController {
    @Autowired
    RolPlataformaService rolPlataformaService;

    @Autowired
    RolPlataformaRepository rolPlataformaRepository;

    @GetMapping
    public RolesPlataformaResponse obtenerTodosLosRolPlataforma(){
        RolesPlataformaResponse response = new RolesPlataformaResponse();

        ArrayList<RolPlataformaModel> roles = (ArrayList<RolPlataformaModel>) rolPlataformaRepository.findAll();
        if (roles.isEmpty()) {
            response.setExito(false);
            response.setMensaje("No se encontraron roles");
            response.setRoles(new ArrayList<>());
        } else {
            response.setExito(true);
            response.setMensaje("Roles obtenidos con éxito");
            response.setRoles(roles);
        }
        return response;
    }

}
