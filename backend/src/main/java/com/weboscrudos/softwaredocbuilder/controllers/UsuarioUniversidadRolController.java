package com.weboscrudos.softwaredocbuilder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weboscrudos.softwaredocbuilder.models.UsuarioModel;
import com.weboscrudos.softwaredocbuilder.models.UsuarioUniversidadRolModel;
import com.weboscrudos.softwaredocbuilder.responses.RolPlataforma.RolesPlataformaResponse;
import com.weboscrudos.softwaredocbuilder.responses.Usuario.UsuarioResponse;
import com.weboscrudos.softwaredocbuilder.responses.UsuarioUniversidadRol.ListaUsuarioUniversidadRolResponse;
import com.weboscrudos.softwaredocbuilder.responses.UsuarioUniversidadRol.UsuarioUniversidadRolResponse;
import com.weboscrudos.softwaredocbuilder.services.UsuariouniversidadRolService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/rol_de_usuario_en_universidad")
@CrossOrigin(origins = "http://localhost:3000")
public class UsuarioUniversidadRolController {
    @Autowired
    UsuariouniversidadRolService usuariouniversidadRolService;

    @GetMapping
    public ListaUsuarioUniversidadRolResponse findAll(){
        ListaUsuarioUniversidadRolResponse response = new ListaUsuarioUniversidadRolResponse();
        
        ArrayList<UsuarioUniversidadRolModel> lista = usuariouniversidadRolService.findAll();
        if (lista.isEmpty()) {
            response.setExito(false);
            response.setMensaje("No se encontraron usuarios con roles en universidades");
            response.setLista(new ArrayList<>());
        } else {
            response.setExito(true);
            response.setMensaje("usuarios con roles en universidades obtenidos con éxito");
            response.setLista(lista);
        }
        return response;
    }

    @GetMapping("/{id}")
    public UsuarioUniversidadRolResponse findById(@PathVariable("id") String id){
        Optional<UsuarioUniversidadRolModel> coincidencia = usuariouniversidadRolService.findById(Long.parseLong(id));
        if (coincidencia.isEmpty()) {
            return UsuarioUniversidadRolResponse.createErrorResponse("No existe id para ese rol de usuario en una universidad");
        }
        return UsuarioUniversidadRolResponse.createSuccessResponse("Existe  id para ese rol de usuario en una universidad", coincidencia.orElse(null));
    }
}
