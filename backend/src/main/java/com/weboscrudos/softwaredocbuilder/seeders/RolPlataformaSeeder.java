package com.weboscrudos.softwaredocbuilder.seeders;

import com.weboscrudos.softwaredocbuilder.models.RolPlataformaModel;
import com.weboscrudos.softwaredocbuilder.repository.RolPlataformaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RolPlataformaSeeder {
    @Autowired
    RolPlataformaRepository rolPlataformaRepository;

    @PostConstruct
    public void seed() {
        if (rolPlataformaRepository.count() == 0) {
            List<RolPlataformaModel> roles = new ArrayList<>();

            RolPlataformaModel adminRol = new RolPlataformaModel();
            adminRol.setNombre("Administrador");
            roles.add(adminRol);

            RolPlataformaModel jefeUniversidadRol = new RolPlataformaModel();
            jefeUniversidadRol.setNombre("Jefe de Carrera");
            roles.add(jefeUniversidadRol);

            RolPlataformaModel profesorRol = new RolPlataformaModel();
            profesorRol.setNombre("Profesor");
            roles.add(profesorRol);

            RolPlataformaModel estudianteRol = new RolPlataformaModel();
            estudianteRol.setNombre("Estudiante");
            roles.add(estudianteRol);

            rolPlataformaRepository.saveAll(roles);
        }
    }
}
