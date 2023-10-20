package com.weboscrudos.softwaredocbuilder.repository;

import com.weboscrudos.softwaredocbuilder.models.RolPlataformaModel;
import com.weboscrudos.softwaredocbuilder.models.UniversidadModel;
import com.weboscrudos.softwaredocbuilder.models.UsuarioModel;
import com.weboscrudos.softwaredocbuilder.models.UsuarioUniversidadRolModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioUniversidadRolRepository extends JpaRepository<UsuarioUniversidadRolModel,Long> {
    Optional<UsuarioUniversidadRolModel> findByUsuarioAndRolAndUniversidad(Optional<UsuarioModel> usuarioModel, Optional<RolPlataformaModel> rolPlataformaModel, Optional<UniversidadModel> universidadModel);
}
