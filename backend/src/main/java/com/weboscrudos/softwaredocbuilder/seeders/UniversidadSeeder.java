package com.weboscrudos.softwaredocbuilder.seeders;
import com.weboscrudos.softwaredocbuilder.models.UniversidadModel;
import com.weboscrudos.softwaredocbuilder.repository.UniversidadRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversidadSeeder {
    @Autowired
    UniversidadRepository universidadRepository;

    @PostConstruct
    public void seed() {
        if (universidadRepository.count() == 0) {
            List<UniversidadModel> universidades = new ArrayList<>();

            UniversidadModel utal = new UniversidadModel();
            utal.setAbreviacion("UTALCA");
            utal.setNombre("Universidad de Talca");
            universidades.add(utal);

            UniversidadModel uch = new UniversidadModel();
            uch.setAbreviacion("UCH");
            uch.setNombre("Universidad de Chile");
            universidades.add(uch);

            UniversidadModel uc = new UniversidadModel();
            uc.setAbreviacion("UC");
            uc.setNombre("Universidad Catolica");
            universidades.add(uc);

            UniversidadModel usm = new UniversidadModel();
            usm.setAbreviacion("UTFSM");
            usm.setNombre("Universidad Técnica Federico Santa Maria");
            universidades.add(usm);

            universidadRepository.saveAll(universidades);
        }
    }
}
