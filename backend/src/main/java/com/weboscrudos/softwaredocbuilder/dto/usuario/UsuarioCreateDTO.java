package com.weboscrudos.softwaredocbuilder.dto.usuario;

import lombok.Getter;

@Getter
public class UsuarioCreateDTO {
    private String rut;
    private String nombres;
    private String apellidos;
    private String contrasena;
    private String email;
}
