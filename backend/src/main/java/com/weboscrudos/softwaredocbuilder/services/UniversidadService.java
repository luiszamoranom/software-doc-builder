package com.weboscrudos.softwaredocbuilder.services;

import com.weboscrudos.softwaredocbuilder.dto.universidad.UniversidadCreateDTO;
import com.weboscrudos.softwaredocbuilder.models.ModuloModel;
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

    public UniversidadModel agregarModuloAUniversidad(Optional<UniversidadModel> universidadExistente,
            String nombreModulo) {

        ModuloModel moduloModel = new ModuloModel();
        moduloModel.setNombre(nombreModulo);
        moduloModel.setUniversidad(universidadExistente.get());
        universidadExistente.get().getModulos().add(moduloModel);
        universidadRepository.save(universidadExistente.get());
        return universidadExistente.get();
    }

    public boolean existeNombreModulo(Optional<UniversidadModel> universidadExistente, String nombreModulo){
        for(ModuloModel modIt : universidadExistente.get().getModulos() ){
            if(modIt.getNombre().equals(nombreModulo)){
                return true;
            }
        }
        return false;
    }

    public ModuloModel retonarNombreModulo(Optional<UniversidadModel> universidadExistente, String nombreModulo){
        for(ModuloModel modIt : universidadExistente.get().getModulos() ){
            if(modIt.getNombre().equals(nombreModulo)){
                return modIt;
            }
        }
        return null;
    }

    public UniversidadModel cambiarEstadoModuloExistente(Optional<UniversidadModel> universidadExistente,
            String nombreModulo, boolean estadoModulo) {
        for(ModuloModel modIt : universidadExistente.get().getModulos() ){
            if(modIt.getNombre().equals(nombreModulo)){
                modIt.setEstado(estadoModulo);
                universidadRepository.save(universidadExistente.get());
                return universidadExistente.get();
            }
        }
        return null;
    }
}
