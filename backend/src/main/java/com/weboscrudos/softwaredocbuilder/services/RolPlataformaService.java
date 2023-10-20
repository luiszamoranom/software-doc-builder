package com.weboscrudos.softwaredocbuilder.services;

import com.weboscrudos.softwaredocbuilder.models.RolPlataformaModel;
import com.weboscrudos.softwaredocbuilder.repository.RolPlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RolPlataformaService {
    @Autowired
    RolPlataformaRepository rolPlataformaRepository;

    public ArrayList<RolPlataformaModel> findAll() {
        return (ArrayList<RolPlataformaModel>) rolPlataformaRepository.findAll();
    }

    public Optional<RolPlataformaModel> findById(Long rolId) {
        return rolPlataformaRepository.findById(rolId);
    }
}
