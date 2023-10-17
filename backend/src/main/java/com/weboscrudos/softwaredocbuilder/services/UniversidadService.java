package com.weboscrudos.softwaredocbuilder.services;

import com.weboscrudos.softwaredocbuilder.models.UniversidadModel;
import com.weboscrudos.softwaredocbuilder.repository.UniversidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

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
}
