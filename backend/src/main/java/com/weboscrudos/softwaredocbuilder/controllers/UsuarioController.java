package com.weboscrudos.softwaredocbuilder.controllers;

import com.weboscrudos.softwaredocbuilder.models.UniversidadModel;
import com.weboscrudos.softwaredocbuilder.models.UsuarioModel;
import com.weboscrudos.softwaredocbuilder.responses.Universidad.UniversidadResponse;
import com.weboscrudos.softwaredocbuilder.responses.Universidad.UniversidadesResponse;
import com.weboscrudos.softwaredocbuilder.responses.Usuario.UsuarioResponse;
import com.weboscrudos.softwaredocbuilder.responses.Usuario.UsuariosResponse;
import com.weboscrudos.softwaredocbuilder.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/filtro/{filtro}")
    public UsuariosResponse findFiltrado(@PathVariable("filtro") String filtro){
        ArrayList<UsuarioModel> usuarios;
        if("todos".equals(filtro)){
            usuarios= usuarioService.findAll();
        }else if("habilitados".equals(filtro)){
            usuarios= usuarioService.findByEstadoTrue();
        }else if("deshabilitados".equals(filtro)){
            usuarios= usuarioService.findByEstadoFalse();
        } else {
            return UsuariosResponse.createErrorResponse("PathVariable no válido");
        }

        if (usuarios.isEmpty()) {
            return UsuariosResponse.createErrorResponse("No se encontraron usuarios");
        } else {
            return UsuariosResponse.createSuccessResponse("Usuarios obtenidas con éxito", usuarios);
        }
    }

    @GetMapping("/login/{rut}")
    public UsuarioResponse login(@PathVariable("rut") String rut,
                                      @RequestBody Map<String, String> campos) {
        Optional<UsuarioModel> usuarioExistente = usuarioService.findById(rut);
        if (usuarioExistente.isEmpty()) {
            return UsuarioResponse.createErrorResponse("No es posible realizar el login ya que no existe usuario con dicho rut");
        }

        if(campos.get("rut").equals(usuarioExistente.get().getRut()) && campos.get("contrasena").equals(usuarioExistente.get().getContrasena())) {
            if(usuarioExistente.get().isEstado()){
                return UsuarioResponse.createSuccessResponse("Login exitoso", usuarioExistente.get());
            }else{
                return UsuarioResponse.createErrorResponse("Credenciales correctas pero el usuario esta deshabilitado, login fallido");
            }
        }

        return UsuarioResponse.createErrorResponse("Contraseña incorrecta");
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

    @GetMapping("/{rut}")
    public UsuarioResponse findById(@PathVariable("rut") String rut){
        Optional<UsuarioModel> usuarioExistente = usuarioService.findById(rut);
        if (usuarioExistente.isEmpty()) {
            return UsuarioResponse.createErrorResponse("No existe un usuario con dicho rut");
        }
        return UsuarioResponse.createSuccessResponse("Existe un usuario con ese rut", usuarioExistente.orElse(null));
    }

    @PutMapping("/habilitar/{rut}")
    public UsuarioResponse setEstadoTrue(@PathVariable("rut") String rut){
        Optional<UsuarioModel> usuarioExistente = usuarioService.findById(rut);
        if (usuarioExistente.isEmpty()) {
            return UsuarioResponse.createErrorResponse("No existe un usuario con dicho rut");
        }

        UsuarioModel usuarioActualizado = usuarioService.setEstadoTrue(usuarioExistente);
        return UsuarioResponse.createSuccessResponse("Universidad habilitada con éxito", usuarioActualizado);
    }

    @PutMapping("/deshabilitar/{rut}")
    public UsuarioResponse setEstadoFalse(@PathVariable("rut") String rut){
        Optional<UsuarioModel> usuarioExistente = usuarioService.findById(rut);
        if (usuarioExistente.isEmpty()) {
            return UsuarioResponse.createErrorResponse("No existe un usuario con dicho rut");
        }

        UsuarioModel usuarioActualizado = usuarioService.setEstadoFalse(usuarioExistente);
        return UsuarioResponse.createSuccessResponse("Universidad habilitada con éxito", usuarioActualizado);
    }



}
