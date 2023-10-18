package com.weboscrudos.softwaredocbuilder.controllers;

import com.weboscrudos.softwaredocbuilder.models.UsuarioModel;
import com.weboscrudos.softwaredocbuilder.repository.UsuarioRepository;
import com.weboscrudos.softwaredocbuilder.responses.Usuario.UsuarioResponse;
import com.weboscrudos.softwaredocbuilder.responses.Usuario.UsuarioResponses;
import com.weboscrudos.softwaredocbuilder.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    @Autowired
    UsuarioService usuarioService;


    @GetMapping
    public UsuarioResponses obtenerTodosLosUsuarios(){

        UsuarioResponses response = new UsuarioResponses();

        ArrayList<UsuarioModel> usuarios = (ArrayList<UsuarioModel>) usuarioService.findAll();
        if (usuarios.isEmpty()) {
            response.setExito(false);
            response.setMensaje("No se encontraron usuarios");
            response.setUsuarios(null);
        } else {
            response.setExito(true);
            response.setMensaje("Usuarios obtenidas con éxito");
            response.setUsuarios(usuarios);
        }
        return response;
    }

    @PostMapping
    public UsuarioResponse guardarUsuario(@RequestBody UsuarioModel usuarioModel){
        UsuarioResponse response = new UsuarioResponse();

        Optional<UsuarioModel> existeUsuario = usuarioService.findById(usuarioModel.getRut());
        if (existeUsuario.isPresent()) {
            response.setExito(false);
            response.setMensaje("Ya existe un usuario con ese rut");
            response.setUsuario(null);
            return response;
        }

        UsuarioModel usuarioGuardado = usuarioService.save(usuarioModel);
        response.setExito(true);
        response.setMensaje("Usuario guardada con éxito");
        response.setUsuario(usuarioGuardado);
        return response;
    }


}
