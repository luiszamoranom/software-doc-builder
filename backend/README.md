# ¿Cómo crear la base de datos local?

mysql -u root -p
CREATE DATABASE softwaredocbuilder;
CREATE USER 'softwaredocbuilder'@'localhost' IDENTIFIED BY 'softwaredocbuilder';
GRANT ALL PRIVILEGES ON softwaredocbuilder.* TO 'softwaredocbuilder'@'localhost';
FLUSH PRIVILEGES;
exit;

# Rutas
## Usuario
## RolPlataforma
## Universidad
- **GET**
  - localhost:8080/universidad/filtro/todas
  - localhost:8080/universidad/filtro/habilitadas
  - localhost:8080/universidad/filtro/deshabilitadas
  - localhost:8080/universidad/{abreviacion}
- **POST**
  - localhost:8080/universidad
    - Body debe tener "abreviacion" que es un string y "nombre" que es un string.
- **PUT:**
  - localhost:8080/universidad/habilitar/{abreviacion}
  - localhost:8080/universidad/deshabilitar/{abreviacion}
  - localhost:8080/universidad/{abreviacion}
    - Debe tener body que es "nuevoNombre" que es un string, que será el nuevo nombre que se actualizará a la universidad