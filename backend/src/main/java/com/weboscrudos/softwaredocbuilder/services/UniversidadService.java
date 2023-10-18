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

    public ArrayList<UniversidadModel> obtenerTodasLasUniversidades(){
        return (ArrayList<UniversidadModel>) universidadRepository.findAll();
    }

    public UniversidadModel guardarUniversidad(@RequestBody UniversidadModel universidadModel) {
        return universidadRepository.save(universidadModel);
    }

    public Optional<UniversidadModel> buscarPorAbreviacion(String abreviacion){
        return universidadRepository.findById(abreviacion);
    }

    // sólo se puede actualizar el nombre, no la abreviacion
    public UniversidadModel actualizarNombrePorAbreviacion(UniversidadModel request, String abreviacion){
        UniversidadModel universidadActualizada = buscarPorAbreviacion(abreviacion).get();
        universidadActualizada.setNombre(request.getNombre());
        return universidadActualizada;
    }

    public UniversidadModel habilitarPorAbreviacion(Optional<UniversidadModel> request, String abreviacion){
        UniversidadModel universidadActualizada = buscarPorAbreviacion(abreviacion).get();
        universidadActualizada.setEstado(true);
        universidadRepository.save(universidadActualizada);
        return universidadActualizada;
    }

    public UniversidadModel deshabilitarPorAbreviacion(Optional<UniversidadModel> request, String abreviacion){
        UniversidadModel universidadActualizada = buscarPorAbreviacion(abreviacion).get();
        universidadActualizada.setEstado(false);
        universidadRepository.save(universidadActualizada);
        return universidadActualizada;
    }






}
