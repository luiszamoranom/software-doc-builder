package com.weboscrudos.softwaredocbuilder.services;

import com.weboscrudos.softwaredocbuilder.models.RolPlataformaModel;
import com.weboscrudos.softwaredocbuilder.repository.RolPlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class RolPlataformaService {
    @Autowired
    RolPlataformaRepository rolPlataformaRepository;

    public ArrayList<RolPlataformaModel> obtenerTodosLosRolPlataforma() {
        return (ArrayList<RolPlataformaModel>) rolPlataformaRepository.findAll();
    }


}
