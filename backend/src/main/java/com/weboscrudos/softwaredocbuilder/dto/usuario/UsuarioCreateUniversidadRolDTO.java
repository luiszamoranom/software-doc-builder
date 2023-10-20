package com.weboscrudos.softwaredocbuilder.dto.usuario;

import lombok.Getter;

import java.util.List;

@Getter
public class UsuarioCreateUniversidadRolDTO {
    private String rut;
    private String nombres;
    private String apellidos;
    private String contrasena;
    private String email;
    private Long rolId;
    private String universidadId;
}
