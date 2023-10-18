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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/universidad")
public class UniversidadController {
    @Autowired
    UniversidadService universidadService;

    @GetMapping("/filtro/{filtro}")
    public UniversidadesResponse obtenerTodasLasUniversidades(@PathVariable("filtro") String filtro){
        UniversidadesResponse response = new UniversidadesResponse();
        System.out.println("RequestBody "+filtro);


        ArrayList<UniversidadModel> universidades;
        if(Objects.equals(filtro, "todas")){
            universidades= (ArrayList<UniversidadModel>) universidadService.findAll();
        }else if(Objects.equals(filtro, "habilitadas")){
            universidades= (ArrayList<UniversidadModel>) universidadService.findByEstadoTrue();
        }else if(Objects.equals(filtro, "deshabilitadas")){
            universidades= (ArrayList<UniversidadModel>) universidadService.findByEstadoFalse();
        }else{
            response.setExito(false);
            response.setMensaje("PathVariable no válido");
            response.setUniversidades(null);
            return response;
        }


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

        Optional<UniversidadModel> universidadExistente = universidadService.findById(universidadModel.getAbreviacion());
        if (universidadExistente.isPresent()) {
            response.setExito(false);
            response.setMensaje("Ya existe una universidad con ese id");
            response.setUniversidad(null);
            return response;
        }

        UniversidadModel universidadGuardada = universidadService.save(universidadModel);
        response.setExito(true);
        response.setMensaje("Universidad guardada con éxito");
        response.setUniversidad(universidadGuardada);
        return response;
    }

    @GetMapping("/{abreviacion}")
    public UniversidadResponse buscarPorAbreviacion(@PathVariable("abreviacion") String abreviacion){
        UniversidadResponse response = new UniversidadResponse();
        Optional<UniversidadModel> universidadExistente = universidadService.findById(abreviacion);
        if (universidadExistente.isEmpty()) {
            response.setExito(false);
            response.setMensaje("No existe una universidad con esa abreviación");
            response.setUniversidad(null);
            return response;
        }

        response.setExito(true);
        response.setMensaje("Existe una universidad con esa abreviación");
        response.setUniversidad(universidadExistente.orElse(null));
        return response;
    }

    @PutMapping("/{abreviacion}")
    public UniversidadResponse actualizarInformacion(@PathVariable("abreviacion") String abreviacion,
                                                     @RequestBody Map<String, String> campos) {
        UniversidadResponse response = new UniversidadResponse();

        String nuevoNombre = campos.get("nuevoNombre");

        Optional<UniversidadModel> universidadExistente = universidadService.findById(abreviacion);
        if (universidadExistente.isEmpty()) {
            response.setExito(false);
            response.setMensaje("No existe una universidad con esa abreviación");
            response.setUniversidad(null);
            return response;
        }


        UniversidadModel universidadActualizada = universidadService.actualizarInformacion(universidadExistente,nuevoNombre);
        response.setExito(true);
        response.setMensaje("Universidad actualizada con éxito");
        response.setUniversidad(universidadActualizada);

        return response;
    }

    @PutMapping("/habilitar/{abreviacion}")
    public UniversidadResponse habilitarPorAbreviacion(@PathVariable("abreviacion") String abreviacion){
        UniversidadResponse response = new UniversidadResponse();
        Optional<UniversidadModel> universidadExistente =universidadService.findById(abreviacion);
        if (universidadExistente.isEmpty()) {
            response.setExito(false);
            response.setMensaje("No existe una universidad con esa abreviación");
            response.setUniversidad(null);
            return response;
        }

        UniversidadModel universidadActualizada = universidadService.habilitarPorAbreviacion(universidadExistente);
        response.setExito(true);
        response.setMensaje("Universidad habilitada con éxito");
        response.setUniversidad(universidadActualizada);
        return response;
    }

    @PutMapping("/deshabilitar/{abreviacion}")
    public UniversidadResponse deshabilitarPorAbreviacion(@PathVariable("abreviacion") String abreviacion){
        UniversidadResponse response = new UniversidadResponse();
        Optional<UniversidadModel> universidadExistente =universidadService.findById(abreviacion);
        if (universidadExistente.isEmpty()) {
            response.setExito(false);
            response.setMensaje("No existe una universidad con esa abreviación");
            response.setUniversidad(null);
            return response;
        }

        UniversidadModel universidadActualizada = universidadService.deshabilitarPorAbreviacion(universidadExistente);
        response.setExito(true);
        response.setMensaje("Universidad deshabilitada con éxito");
        response.setUniversidad(universidadActualizada);
        return response;
    }
}
