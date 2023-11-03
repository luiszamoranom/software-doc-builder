package com.weboscrudos.softwaredocbuilder.repository;

import com.weboscrudos.softwaredocbuilder.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel,String> {
    ArrayList<UsuarioModel> findByEstadoTrue();
    ArrayList<UsuarioModel> findByEstadoFalse();

    @Query("SELECT DISTINCT u FROM UsuarioModel u " +
       "JOIN u.usuarioUniversidadRoles r " +
       "JOIN r.rol rol " +
       "JOIN r.universidad uni " +
       "WHERE rol.nombre = :nombreRol " +
       "AND uni.abreviacion = :abreviacionUniversidad")
    ArrayList<UsuarioModel> findByRolPlataformaAndUniversidad(
        @Param("nombreRol") String nombreRol,
        @Param("abreviacionUniversidad") String abreviacionUniversidad);
}
