package com.weboscrudos.softwaredocbuilder.repository;

import com.weboscrudos.softwaredocbuilder.models.UniversidadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversidadRepository extends JpaRepository<UniversidadModel,String> {
    List<UniversidadModel> findByEstadoTrue();
    List<UniversidadModel> findByEstadoFalse();
}
