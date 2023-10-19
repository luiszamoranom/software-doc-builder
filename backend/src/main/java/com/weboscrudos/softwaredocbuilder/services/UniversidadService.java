package com.weboscrudos.softwaredocbuilder.services;

import com.weboscrudos.softwaredocbuilder.dto.universidad.UniversidadCreateDTO;
import com.weboscrudos.softwaredocbuilder.models.UniversidadModel;
import com.weboscrudos.softwaredocbuilder.repository.UniversidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public UniversidadModel save(UniversidadCreateDTO universidadCreateDTO) {
        UniversidadModel universidadModel = new UniversidadModel();
        universidadModel.setNombre(universidadCreateDTO.getNombre());
        universidadModel.setAbreviacion(universidadCreateDTO.getAbreviacion());
        universidadModel.setEstado(universidadCreateDTO.isEstado());
        return universidadRepository.save(universidadModel);
    }

    public Optional<UniversidadModel> findById(String abreviacion){
        return universidadRepository.findById(abreviacion);
    }

    public UniversidadModel update(Optional<UniversidadModel> universidadExistente, String nuevoNombre) {
        UniversidadModel universidad = universidadExistente.get();
        universidad.setNombre(nuevoNombre);
        universidadRepository.save(universidad);
        return universidad;
    }

    public UniversidadModel setEstadoTrue(Optional<UniversidadModel> universidadExistente){
        UniversidadModel universidadActualizada = universidadExistente.get();
        universidadActualizada.setEstado(true);
        universidadRepository.save(universidadActualizada);
        return universidadActualizada;
    }

    public UniversidadModel setEstadoFalse(Optional<UniversidadModel> universidadExistente){
        UniversidadModel universidadActualizada =  universidadExistente.get();
        universidadActualizada.setEstado(false);
        universidadRepository.save(universidadActualizada);
        return universidadActualizada;
    }
}
