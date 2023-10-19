package com.weboscrudos.softwaredocbuilder.services;

import com.weboscrudos.softwaredocbuilder.dto.usuario.UsuarioCreateDTO;
import com.weboscrudos.softwaredocbuilder.dto.usuario.UsuarioUpdateDTO;
import com.weboscrudos.softwaredocbuilder.models.UsuarioModel;
import com.weboscrudos.softwaredocbuilder.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioModel save(UsuarioCreateDTO usuarioCreateDTO) {
        UsuarioModel usuarioModel= new UsuarioModel();
        usuarioModel.setRut(usuarioCreateDTO.getNombres());
        usuarioModel.setNombres(usuarioCreateDTO.getNombres());
        usuarioModel.setApellidos(usuarioCreateDTO.getApellidos());
        usuarioModel.setContrasena(usuarioCreateDTO.getContrasena());
        usuarioModel.setEmail(usuarioCreateDTO.getEmail());
        return usuarioRepository.save(usuarioModel);
    }

    public ArrayList<UsuarioModel> findAll() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> findById(String rut) {
        return usuarioRepository.findById(rut);
    }

    public ArrayList<UsuarioModel> findByEstadoTrue() {
        return usuarioRepository.findByEstadoTrue();
    }

    public ArrayList<UsuarioModel> findByEstadoFalse() {
        return usuarioRepository.findByEstadoFalse();
    }

    public UsuarioModel setEstadoTrue(Optional<UsuarioModel> usuarioExistente) {
        UsuarioModel usuarioActualizado = usuarioExistente.get();
        usuarioActualizado.setEstado(true);
        usuarioRepository.save(usuarioActualizado);
        return usuarioActualizado;
    }

    public UsuarioModel setEstadoFalse(Optional<UsuarioModel> usuarioExistente) {
        UsuarioModel usuarioActualizado = usuarioExistente.get();
        usuarioActualizado.setEstado(false);
        usuarioRepository.save(usuarioActualizado);
        return usuarioActualizado;
    }

    public UsuarioModel update(Optional<UsuarioModel> usuarioExistente, UsuarioUpdateDTO usuarioUpdateDTO) {
        UsuarioModel usuario = usuarioExistente.get();
        usuario.setNombres(usuarioUpdateDTO.getNombres());
        usuario.setApellidos(usuarioUpdateDTO.getApellidos());
        usuario.setContrasena(usuarioUpdateDTO.getContrasena());
        usuario.setEmail(usuarioUpdateDTO.getEmail());
        usuarioRepository.save(usuario);
        return usuario;
    }
}
