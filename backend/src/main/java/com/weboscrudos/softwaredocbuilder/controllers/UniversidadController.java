package com.weboscrudos.softwaredocbuilder.controllers;

import com.weboscrudos.softwaredocbuilder.models.UniversidadModel;
import com.weboscrudos.softwaredocbuilder.responses.Universidad.UniversidadResponse;
import com.weboscrudos.softwaredocbuilder.responses.Universidad.UniversidadesResponse;
import com.weboscrudos.softwaredocbuilder.services.UniversidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/universidad")
public class UniversidadController {
    @Autowired
    UniversidadService universidadService;

    @GetMapping("/filtro/{filtro}")
    public UniversidadesResponse findFiltrado(@PathVariable("filtro") String filtro){
        ArrayList<UniversidadModel> universidades;
        if("todas".equals(filtro)){
            universidades= (ArrayList<UniversidadModel>) universidadService.findAll();
        }else if("habilitadas".equals(filtro)){
            universidades= (ArrayList<UniversidadModel>) universidadService.findByEstadoTrue();
        }else if("deshabilitadas".equals(filtro)){
            return UniversidadesResponse.createErrorResponse("PathVariable no válido");
        } else {
            return UniversidadesResponse.createErrorResponse("PathVariable no válido");
        }

        if (universidades.isEmpty()) {
            return UniversidadesResponse.createErrorResponse("No se encontraron universidades");
        } else {
            return UniversidadesResponse.createSuccessResponse("Universidades obtenidas con éxito", universidades);
        }
    }

    @PostMapping
    public UniversidadResponse save(@RequestBody UniversidadModel universidadModel){
        Optional<UniversidadModel> universidadExistente = universidadService.findById(universidadModel.getAbreviacion());
        if (universidadExistente.isPresent()) {
            return UniversidadResponse.createErrorResponse("Ya existe una universidad con ese id");
        }

        UniversidadModel universidadGuardada = universidadService.save(universidadModel);
        return UniversidadResponse.createSuccessResponse("Universidad guardada con éxito", universidadGuardada);
    }

    @GetMapping("/{abreviacion}")
    public UniversidadResponse findById(@PathVariable("abreviacion") String abreviacion){
        Optional<UniversidadModel> universidadExistente = universidadService.findById(abreviacion);
        if (universidadExistente.isEmpty()) {
            return UniversidadResponse.createErrorResponse("No existe una universidad con esa abreviación");
        }
        return UniversidadResponse.createSuccessResponse("Existe una universidad con esa abreviación", universidadExistente.orElse(null));
    }

    @PutMapping("/{abreviacion}")
    public UniversidadResponse update(@PathVariable("abreviacion") String abreviacion,
                                      @RequestBody Map<String, String> campos) {
        Optional<UniversidadModel> universidadExistente = universidadService.findById(abreviacion);
        if (universidadExistente.isEmpty()) {
            return UniversidadResponse.createErrorResponse("No existe una universidad con esa abreviación");
        }

        UniversidadModel universidadActualizada = universidadService.update(universidadExistente, campos.get("nuevoNombre"));
        return UniversidadResponse.createSuccessResponse("Universidad actualizada con éxito", universidadActualizada);
    }

    @PutMapping("/habilitar/{abreviacion}")
    public UniversidadResponse setEstadoTrue(@PathVariable("abreviacion") String abreviacion){
        Optional<UniversidadModel> universidadExistente = universidadService.findById(abreviacion);
        if (universidadExistente.isEmpty()) {
            return UniversidadResponse.createErrorResponse("No existe una universidad con esa abreviación");
        }

        UniversidadModel universidadActualizada = universidadService.setEstadoTrue(universidadExistente);
        return UniversidadResponse.createSuccessResponse("Universidad habilitada con éxito", universidadActualizada);
    }

    @PutMapping("/deshabilitar/{abreviacion}")
    public UniversidadResponse setEstadoFalse(@PathVariable("abreviacion") String abreviacion){
        Optional<UniversidadModel> universidadExistente = universidadService.findById(abreviacion);
        if (universidadExistente.isEmpty()) {
            return UniversidadResponse.createErrorResponse("No existe una universidad con esa abreviación");
        }

        UniversidadModel universidadActualizada = universidadService.setEstadoFalse(universidadExistente);
        return UniversidadResponse.createSuccessResponse("Universidad deshabilitada con éxito", universidadActualizada);
    }
}