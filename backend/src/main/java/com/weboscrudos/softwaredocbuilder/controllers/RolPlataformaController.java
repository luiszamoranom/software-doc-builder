package com.weboscrudos.softwaredocbuilder.controllers;

import com.weboscrudos.softwaredocbuilder.models.RolPlataformaModel;
import com.weboscrudos.softwaredocbuilder.repository.RolPlataformaRepository;
import com.weboscrudos.softwaredocbuilder.responses.RolPlataforma.RolesPlataformaResponse;
import com.weboscrudos.softwaredocbuilder.services.RolPlataformaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/rol_en_universidad")
@CrossOrigin(origins = "http://localhost:3000")
public class RolPlataformaController {
    @Autowired
    RolPlataformaService rolPlataformaService;

    @GetMapping
    public RolesPlataformaResponse findAll(){
        RolesPlataformaResponse response = new RolesPlataformaResponse();

        ArrayList<RolPlataformaModel> roles = rolPlataformaService.findAll();
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
