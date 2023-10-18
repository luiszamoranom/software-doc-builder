package com.weboscrudos.softwaredocbuilder.seeders;

import com.weboscrudos.softwaredocbuilder.models.UniversidadModel;
import com.weboscrudos.softwaredocbuilder.models.UsuarioModel;
import com.weboscrudos.softwaredocbuilder.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioSeeder {
    @Autowired
    UsuarioRepository usuarioRepository;

    @PostConstruct
    public void seed() {
        if (usuarioRepository.count() == 0) {
            List<UsuarioModel> usuarios = new ArrayList<>();

            UsuarioModel u1 = new UsuarioModel();
            u1.setRut("11.111.111-1");
            u1.setNombres("Luis");
            u1.setApellidos("Zamorano");
            u1.setContrasena("luis123");
            u1.setEmail("lzamorano@utalca.cl");
            usuarios.add(u1);

            UsuarioModel u2 = new UsuarioModel();
            u2.setRut("22.222.222-2");
            u2.setNombres("Bastian");
            u2.setApellidos("Nuñez");
            u2.setContrasena("bastian123");
            u2.setEmail("bnuñez@utalca.cl");
            usuarios.add(u2);

            UsuarioModel u3 = new UsuarioModel();
            u3.setRut("33.333.333-3");
            u3.setNombres("Alonso");
            u3.setApellidos("Orostica");
            u3.setContrasena("alonso123");
            u3.setEmail("aorostica@utalca.cl");
            usuarios.add(u3);

            UsuarioModel u4 = new UsuarioModel();
            u4.setRut("44.444.444-4");
            u4.setNombres("Rodrigo");
            u4.setApellidos("Pavez");
            u4.setContrasena("rodrigo123");
            u4.setEmail("rpavez@utalca.cl");
            usuarios.add(u4);

            UsuarioModel u5 = new UsuarioModel();
            u5.setRut("55.555.555-5");
            u5.setNombres("Daniel");
            u5.setApellidos("Moreno");
            u5.setContrasena("daniel123");
            u5.setEmail("dmoreno@utalca.cl");
            usuarios.add(u5);

            UsuarioModel u6 = new UsuarioModel();
            u6.setRut("66.666.666-6");
            u6.setNombres("Ruth");
            u6.setApellidos("Garrido");
            u6.setContrasena("ruth123");
            u6.setEmail("rgarrido@utalca.cl");
            usuarios.add(u6);

            UsuarioModel u7 = new UsuarioModel();
            u7.setRut("77.777.777-7");
            u7.setNombres("Admin");
            u7.setApellidos("Admin");
            u7.setContrasena("admin123");
            u7.setEmail("admin@utalca.cl");
            usuarios.add(u7);

            usuarioRepository.saveAll(usuarios);
        }
    }

}
