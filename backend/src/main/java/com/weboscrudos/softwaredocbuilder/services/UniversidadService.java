package com.weboscrudos.softwaredocbuilder.services;

import com.weboscrudos.softwaredocbuilder.models.UniversidadModel;
import com.weboscrudos.softwaredocbuilder.repository.UniversidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UniversidadService {
    @Autowired
    UniversidadRepository universidadRepository;

    public ArrayList<UniversidadModel> findAll(){
        return (ArrayList<UniversidadModel>) universidadRepository.findAll();
    }

    public ArrayList<UniversidadModel> findByEstadoTrue(){
        return (ArrayList<UniversidadModel>) universidadRepository.findByEstadoTrue();
    }

    public ArrayList<UniversidadModel> findByEstadoFalse(){
        return (ArrayList<UniversidadModel>) universidadRepository.findByEstadoFalse();
    }


    public UniversidadModel save(UniversidadModel universidadModel) {
        return universidadRepository.save(universidadModel);
    }

    public Optional<UniversidadModel> findById(String abreviacion){
        return universidadRepository.findById(abreviacion);
    }

    public UniversidadModel actualizarInformacion(Optional<UniversidadModel> universidadExistente, String nuevoNombre) {
        UniversidadModel universidad = universidadExistente.get();
        universidad.setNombre(nuevoNombre);
        universidadRepository.save(universidad);
        return universidad;
    }

    public UniversidadModel habilitarPorAbreviacion(Optional<UniversidadModel> universidadExistente){
        UniversidadModel universidadActualizada = universidadExistente.get();
        universidadActualizada.setEstado(true);
        universidadRepository.save(universidadActualizada);
        return universidadActualizada;
    }

    public UniversidadModel deshabilitarPorAbreviacion(Optional<UniversidadModel> universidadExistente){
        UniversidadModel universidadActualizada =  universidadExistente.get();
        universidadActualizada.setEstado(false);
        universidadRepository.save(universidadActualizada);
        return universidadActualizada;
    }
}
