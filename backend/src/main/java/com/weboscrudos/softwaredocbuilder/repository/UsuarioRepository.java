package com.weboscrudos.softwaredocbuilder.repository;

import com.weboscrudos.softwaredocbuilder.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel,String> {

}
