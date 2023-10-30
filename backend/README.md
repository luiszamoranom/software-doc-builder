# ¿Cómo crear la base de datos local?

mysql -u root -p

CREATE DATABASE softwaredocbuilder;

CREATE USER 'softwaredocbuilder'@'localhost' IDENTIFIED BY 'softwaredocbuilder';

GRANT ALL PRIVILEGES ON softwaredocbuilder.* TO 'softwaredocbuilder'@'localhost';

FLUSH PRIVILEGES;

exit;

---
# Rutas

---
## Usuario
- **GET**
  - localhost:8080/usuario/filtro/todos
  - localhost:8080/usuario/filtro/habilitados
  - localhost:8080/usuario/filtro/deshabilitados
  - localhost:8080/usuario/login
    - Debe tener body con rut y contrasena, ejemplo =>
      {
      "rut":"11.111.111-1",
      "contrasena":"luis123"
      }
  - localhost:8080/usuario/{rut} 
    - Busca según rut, por tanto, hay que indicarselo, ejemplo => localhost:8080/usuario/11.111.111-1
  - localhost:8080/usuario/buscar_por_rol_en_universidad
    - Busca todos los usuarios con determinado "nombreRol" en determinada universidad identificada por "abreviacionUniversidad", ambos string.
    - Ej:
    {
      "nombreRol":"Profesor",
      "abreviacionUniversidad":"UTALCA"
    }
- **POST**
  - **EN TEORIA, NO DEBERIA USARSE** localhost:8080/usuario/guardar_sin_rol_en_universidad 
    - Para crear un usuario debe tener el body con los siguientes parametros: rut, nombres, apellidos, contrasena, email
    - Ejemplo:
    {
      "rut":"99.999.999-9",
      "nombres":"Pepito",
      "apellidos":"Romero",
      "contrasena":"pepito123",
      "email":"pepito@gmail.com"
    }
  - localhost:8080/usuario/guardar_con_rol_en_universidad
    - Para crear un usuario debe tener el body con los siguientes parametros: rut, nombres, apellidos, contrasena, email, rolId, universidadId
    - Ejemplo:
      {
      "rut":"99.999.999-9",
      "nombres":"Pepito",
      "apellidos":"Romero",
      "contrasena":"pepito123",
      "email":"pepito@gmail.com",
      "rolId":3,
      "universidadId":"UTALCA"
      }
- **PATCH**
  - localhost:8080/usuario
    - Para actualizar la información de un usuario, debe tener los siguientes parametros: rut, nombres, apellidos, contrasena, email
    - se actualizarán todos los parametros indicados, exceptuando el rut, por tanto, este no será editable en su formulario.
    - Ejemplo =>
      {
      "rut":"99.999.999-9",
      "nombres":"Pepito Update",
      "apellidos":"Romero Update",
      "contrasena":"pepitoupdate123",
      "email":"pepitoupdate@gmail.com"
      }
  - localhost:8080/usuario/habilitar/{rut}
  - localhost:8080/usuario/deshabilitar/{rut}
  
---
## RolPlataforma
- **GET**
  - localhost:8080/rol_en_universidad
    - obtiene todos los roles de la app

---
## Universidad
- **GET**
  - localhost:8080/universidad/filtro/todas
  - localhost:8080/universidad/filtro/habilitadas
  - localhost:8080/universidad/filtro/deshabilitadas
  - localhost:8080/universidad/{abreviacion}
    - buscar según id, retornará la información de una universidad
    - Ejemplo => localhost:8080/universidad/UTALCA
- **POST**
  - localhost:8080/universidad
    - Body debe tener "abreviacion" que es un string y "nombre" que es un string.
    - Todas las universidades creadas se crearán con estado true, no es necesario especificarlo.
    - Ejemplo:
      {
      "nombres": "Universidad de la Vida",
      "abreviacion": "UDV"
      }
  - localhost:8080/universidad/agregar_modulo_universidad
    - Agrega un modulo a una universidad, este debe tener un body con "abreviacionUniversidad" y "nombreModulo", ambos string.
    - No se podrán tener más de un modulo con un mismo nombre en una misma universidad.
    - Ejemplo:
      {
        "abreviacionUniversidad":"UTALCA",
        "nombreModulo":"Programación Avanzada",
        "descripcionModulo":"Es un buen ramo si lo da un buen profesor"
      }

- **PATCH**
  - localhost:8080/universidad
    - Para actualizar la información de una universidad, debe tener los siguientes parametros: abreviación y nombre
    - se actualizará únicamente el nombre, por tanto, la abreviación no será editable en su formulario.
    - Ejemplo
      {
      "abreviacion": "UTALCA",
      "nombres": "Universidad de Talka"
      }
  - localhost:8080/universidad/habilitar/{abreviacion}
  - localhost:8080/universidad/deshabilitar/{abreviacion}
  - localhost:8080/universidad/cambiar_estado_modulo
    - Cambia el estado de un modulo en una universidad, señalando la "abreviacionUniversidad", el "nombreModulo" y el estado "estadoModulo" al cual cambiará, todos String. 
    - EJ:
    {
      "abreviacionUniversidad":"UTALCA",
      "nombreModulo":"Programación Avanzada",
      "estadoModulo":"true"
    }
  - localhost:8080/universidad/actualizar_informacion_modulo
    - Sólo se puede actualizar la descripcion del estado (fuera del estado que se hace con la ruta anterior), esto es debido a que la PK no se pueden cambiar.
    - EJ:
    {
      "abreviacionUniversidad":"UTALCA",
      "nombreModulo":"Programación Avanzada",
      "nuevaDescripcionModulo":"nueva descripcion"
    }

## Rol de Usuario en una Universidad
Nota: Cada vez que se imprime un usuario, sale la información relevante al rol que posee en una universidad. Sin embargo, cada una de estas relaciones usuario-universidad-rol esta registrada en la tabla 'usuario_universidad_rol', con su correspondiente id.
- **GET**
  - localhost:8080/rol_de_usuario_en_universidad
    - Obtener todas las relaciones triples de todos los usuarios registrados en la aplicación 
  - localhost:8080/rol_de_usuario_en_universidad/{id} 
    - Obtener la información de esta relación triple de un particular id 