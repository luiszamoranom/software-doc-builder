package com.weboscrudos.softwaredocbuilder.controllers;

import com.weboscrudos.softwaredocbuilder.dto.universidad.UniversidadAgregarModuloDTO;
import com.weboscrudos.softwaredocbuilder.dto.universidad.UniversidadCreateDTO;
import com.weboscrudos.softwaredocbuilder.dto.universidad.UniversidadUpdateDTO;
import com.weboscrudos.softwaredocbuilder.dto.universidad.UniversidadUpdateEstadoModuloDTO;
import com.weboscrudos.softwaredocbuilder.dto.universidad.UniversidadUpdateModuloDTO;
import com.weboscrudos.softwaredocbuilder.models.ModuloModel;
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
@CrossOrigin(origins = "http://localhost:3000")
public class UniversidadController {
    @Autowired
    UniversidadService universidadService;

    @GetMapping("/filtro/{filtro}")
    public UniversidadesResponse findFiltrado(@PathVariable("filtro") String filtro){
        ArrayList<UniversidadModel> universidades;
        if("todas".equals(filtro)){
            universidades= universidadService.findAll();
        }else if("habilitadas".equals(filtro)){
            universidades= universidadService.findByEstadoTrue();
        }else if("deshabilitadas".equals(filtro)){
            universidades= universidadService.findByEstadoFalse();
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
    public UniversidadResponse save(@RequestBody UniversidadCreateDTO universidadCreateDTO){
        Optional<UniversidadModel> universidadExistente = universidadService.findById(universidadCreateDTO.getAbreviacion());
        if (universidadExistente.isPresent()) {
            return UniversidadResponse.createErrorResponse("Ya existe una universidad con ese id");
        }

        UniversidadModel universidadGuardada = universidadService.save(universidadCreateDTO);
        return UniversidadResponse.createSuccessResponse("Universidad creada con éxito", universidadGuardada);
    }

    @GetMapping("/{abreviacion}")
    public UniversidadResponse findById(@PathVariable("abreviacion") String abreviacion){
        Optional<UniversidadModel> universidadExistente = universidadService.findById(abreviacion);
        if (universidadExistente.isEmpty()) {
            return UniversidadResponse.createErrorResponse("No existe una universidad con esa abreviación");
        }
        return UniversidadResponse.createSuccessResponse("Existe una universidad con esa abreviación", universidadExistente.orElse(null));
    }

    @PatchMapping
    public UniversidadResponse update(@RequestBody UniversidadUpdateDTO universidadUpdateDTO) {
        Optional<UniversidadModel> universidadExistente = universidadService.findById(universidadUpdateDTO.getAbreviacion());
        if (universidadExistente.isEmpty()) {
            return UniversidadResponse.createErrorResponse("No existe una universidad con esa abreviación");
        }

        UniversidadModel universidadActualizada = universidadService.update(universidadExistente, universidadUpdateDTO.getNombre());
        return UniversidadResponse.createSuccessResponse("Universidad actualizada con éxito", universidadActualizada);
    }

    @PatchMapping("/habilitar/{abreviacion}")
    public UniversidadResponse setEstadoTrue(@PathVariable("abreviacion") String abreviacion){
        Optional<UniversidadModel> universidadExistente = universidadService.findById(abreviacion);
        if (universidadExistente.isEmpty()) {
            return UniversidadResponse.createErrorResponse("No existe una universidad con esa abreviación");
        }

        UniversidadModel universidadActualizada = universidadService.setEstadoTrue(universidadExistente);
        return UniversidadResponse.createSuccessResponse("Universidad habilitada con éxito", universidadActualizada);
    }

    @PatchMapping("/deshabilitar/{abreviacion}")
    public UniversidadResponse setEstadoFalse(@PathVariable("abreviacion") String abreviacion){
        Optional<UniversidadModel> universidadExistente = universidadService.findById(abreviacion);
        if (universidadExistente.isEmpty()) {
            return UniversidadResponse.createErrorResponse("No existe una universidad con esa abreviación");
        }

        UniversidadModel universidadActualizada = universidadService.setEstadoFalse(universidadExistente);
        return UniversidadResponse.createSuccessResponse("Universidad deshabilitada con éxito", universidadActualizada);
    }

    @PostMapping("/agregar_modulo_universidad")
    public UniversidadResponse agregarModuloAUniversidad(@RequestBody UniversidadAgregarModuloDTO uDTO ){
        Optional<UniversidadModel> universidadExistente = universidadService.findById(uDTO.getAbreviacionUniversidad());
        
         if (universidadExistente.isEmpty()) {
            return UniversidadResponse.createErrorResponse("No existe una universidad con esa abreviación");
        }

        boolean moduloExisteEnUniversidad = universidadService.existeNombreModulo(universidadExistente,uDTO.getNombreModulo());

        if(moduloExisteEnUniversidad){
            return UniversidadResponse.createErrorResponse("No podemos registrar el modulo ya que actualmente existe uno con el mismo nombre");
        }
        
        return UniversidadResponse.createSuccessResponse("Se ha agregado el modulo a la universidad", universidadService.agregarModuloAUniversidad(universidadExistente,uDTO.getNombreModulo(),uDTO.getDescripcionModulo()));
    }

    @PatchMapping("/cambiar_estado_modulo")
    public UniversidadResponse cambiarEstadoModulo(@RequestBody UniversidadUpdateEstadoModuloDTO uDTO ){
        Optional<UniversidadModel> universidadExistente = universidadService.findById(uDTO.getAbreviacionUniversidad());
        if (universidadExistente.isEmpty()) {
            return UniversidadResponse.createErrorResponse("No existe una universidad con esa abreviación");
        }

        UniversidadModel universidadActualizada = universidadService.cambiarEstadoModuloExistente(universidadExistente,uDTO.getNombreModulo(),uDTO.isEstadoModulo());

        if(universidadActualizada==null){
            return UniversidadResponse.createErrorResponse("No podemos cambiar el estado del modulo ya que no existe");
        }
        
        return UniversidadResponse.createSuccessResponse("Se ha actualizado el estado del modulo en la universidad", universidadActualizada);
    }

    @PatchMapping("/actualizar_informacion_modulo")
    public UniversidadResponse updateModulo(@RequestBody UniversidadUpdateModuloDTO uDTO ){
        Optional<UniversidadModel> universidadExistente = universidadService.findById(uDTO.getAbreviacionUniversidad());
        
        if (universidadExistente.isEmpty()) {
            return UniversidadResponse.createErrorResponse("No existe una universidad con esa abreviación");
        }

        UniversidadModel universidadActualizada = universidadService.updateModuloExistente(universidadExistente,uDTO.getNombreModulo(),uDTO.getNuevaDescripcionModulo());

        if(universidadActualizada==null){
            return UniversidadResponse.createErrorResponse("No podemos cambiar la descripción del modulo ya que no existe");
        }
        
        return UniversidadResponse.createSuccessResponse("Se ha actualizado la descripción del modulo en la universidad", universidadActualizada);
    }
}