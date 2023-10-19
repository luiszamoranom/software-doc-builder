package com.weboscrudos.softwaredocbuilder.dto.usuario;

import lombok.Getter;

@Getter
public class UsuarioUpdateDTO {
    private String nombres;
    private String apellidos;
    private String contrasena;
    private String email;
}
