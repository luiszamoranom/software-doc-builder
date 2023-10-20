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
- **POST**
  - localhost:8080/usuario
    - Para crear un usuario debe tener el body con los siguientes parametros: rut, nombres, apellidos, contrasena, email
    - Ejemplo:
    {
      "rut":"99.999.999-9",
      "nombres":"Pepito",
      "apellidos":"Romero",
      "contrasena":"pepito123",
      "email":"pepito@gmail.com"
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
  - localhost:8080/rol_plataforma
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
- **PATCH**
  - localhost:8080/universidad
    - ara actualizar la información de una universidad, debe tener los siguientes parametros: abreviación y nombre
    - se actualizará únicamente el nombre, por tanto, la abreviación no será editable en su formulario.
    - Ejemplo
      {
      "abreviacion": "UTALCA",
      "nombres": "Universidad de Talka"
      }
  - localhost:8080/universidad/habilitar/{abreviacion}
  - localhost:8080/universidad/deshabilitar/{abreviacion}