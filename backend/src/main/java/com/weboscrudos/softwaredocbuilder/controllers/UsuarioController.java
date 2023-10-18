package com.weboscrudos.softwaredocbuilder.controllers;

import com.weboscrudos.softwaredocbuilder.models.UsuarioModel;
import com.weboscrudos.softwaredocbuilder.responses.Usuario.UsuarioResponse;
import com.weboscrudos.softwaredocbuilder.responses.Usuario.UsuariosResponse;
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
    public UsuariosResponse findAll(){
        ArrayList<UsuarioModel> usuarios = usuarioService.findAll();
        if (usuarios.isEmpty()) {
           return UsuariosResponse.createErrorResponse("No hay usuarios");
        }
        return UsuariosResponse.createSuccessResponse("Ha obtenido los usuarios con éxito",usuarios);
    }

    @PostMapping
    public UsuarioResponse save(@RequestBody UsuarioModel usuarioModel){
        Optional<UsuarioModel> posibleUsuario = usuarioService.findById(usuarioModel.getRut());
        if (posibleUsuario.isPresent()) {
            return UsuarioResponse.createErrorResponse("Ya existe un usuario con ese rut, no es posible registrarlo");
        }

        usuarioService.save(usuarioModel);
        return UsuarioResponse.createSuccessResponse("Usuario guardado exitosamente",usuarioModel);
    }
}
