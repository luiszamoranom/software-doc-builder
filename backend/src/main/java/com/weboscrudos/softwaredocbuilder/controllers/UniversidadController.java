package com.weboscrudos.softwaredocbuilder.controllers;

import com.weboscrudos.softwaredocbuilder.models.UniversidadModel;
import com.weboscrudos.softwaredocbuilder.repository.UniversidadRepository;
import com.weboscrudos.softwaredocbuilder.responses.Universidad.UniversidadResponse;
import com.weboscrudos.softwaredocbuilder.responses.Universidad.UniversidadesResponse;
import com.weboscrudos.softwaredocbuilder.services.UniversidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/universidad")
public class UniversidadController {
    @Autowired
    UniversidadService universidadService;

    @Autowired
    UniversidadRepository universidadRepository;

    @GetMapping
    public UniversidadesResponse obtenerTodasLasUniversidades(){
        UniversidadesResponse response = new UniversidadesResponse();

        ArrayList<UniversidadModel> universidades = (ArrayList<UniversidadModel>) universidadRepository.findAll();
        if (universidades.isEmpty()) {
            response.setExito(false);
            response.setMensaje("No se encontraron universidades");
            response.setUniversidades(null);
        } else {
            response.setExito(true);
            response.setMensaje("Universidades obtenidas con éxito");
            response.setUniversidades(universidades);
        }
        return response;
    }

    @PostMapping
    public UniversidadResponse guardarUniversidad(@RequestBody UniversidadModel universidadModel){
        UniversidadResponse response = new UniversidadResponse();

        Optional<UniversidadModel> universidadExistente = universidadRepository.findById(universidadModel.getAbreviacion());
        if (universidadExistente.isPresent()) {
            response.setExito(false);
            response.setMensaje("Ya existe una universidad con ese id");
            response.setUniversidad(null);
            return response;
        }

        UniversidadModel universidadGuardada = universidadRepository.save(universidadModel);
        response.setExito(true);
        response.setMensaje("Universidad guardada con éxito");
        response.setUniversidad(universidadGuardada);
        return response;
    }

}
