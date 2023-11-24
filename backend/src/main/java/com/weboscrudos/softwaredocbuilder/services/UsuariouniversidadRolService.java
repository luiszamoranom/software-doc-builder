package com.weboscrudos.softwaredocbuilder.services;

import com.weboscrudos.softwaredocbuilder.models.RolPlataformaModel;
import com.weboscrudos.softwaredocbuilder.models.UniversidadModel;
import com.weboscrudos.softwaredocbuilder.models.UsuarioModel;
import com.weboscrudos.softwaredocbuilder.models.UsuarioUniversidadRolModel;
import com.weboscrudos.softwaredocbuilder.repository.UsuarioUniversidadRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuariouniversidadRolService {

    @Autowired
    UsuarioUniversidadRolRepository usuarioUniversidadRolRepository;

    public UsuarioUniversidadRolModel save(UsuarioUniversidadRolModel usuarioUniversidadRol) {
        return usuarioUniversidadRolRepository.save(usuarioUniversidadRol);
    }

    public Optional<UsuarioUniversidadRolModel> findByUsuarioAndRolAndUniversidad(Optional<UsuarioModel> usuario, Optional<RolPlataformaModel> rol, Optional<UniversidadModel> universidad) {
        return usuarioUniversidadRolRepository.findByUsuarioAndRolAndUniversidad(usuario, rol, universidad);
    }

    public UsuarioUniversidadRolModel generarnuevoUsuarioUniversidadRol(Optional<RolPlataformaModel> rolPlataformaModel, Optional<UniversidadModel> universidadModel) {
        UsuarioUniversidadRolModel nuevoUsuarioUniversidadRol = new UsuarioUniversidadRolModel();
        nuevoUsuarioUniversidadRol.setUniversidad(universidadModel.get());
        nuevoUsuarioUniversidadRol.setRol(rolPlataformaModel.get());
        return nuevoUsuarioUniversidadRol;
    }

    public UsuarioUniversidadRolModel setearUsuario(UsuarioUniversidadRolModel nuevoUsuarioUniversidadRol, UsuarioModel nuevoUsuario) {
        nuevoUsuarioUniversidadRol.setUsuario(nuevoUsuario);
        return nuevoUsuarioUniversidadRol;
    }


    public void saveConUsuarioRolUniverisdad(UsuarioUniversidadRolModel usuarioUniversidadRolModelListo) {
        usuarioUniversidadRolRepository.save(usuarioUniversidadRolModelListo);
    }

    public ArrayList<UsuarioUniversidadRolModel> findAll() {
        return (ArrayList<UsuarioUniversidadRolModel>) usuarioUniversidadRolRepository.findAll();
    }

    public Optional<UsuarioUniversidadRolModel> findById(Long id) {
        return usuarioUniversidadRolRepository.findById(id);
    }
}
