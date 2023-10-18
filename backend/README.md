# ¿Cómo crear la base de datos local?

mysql -u root -p
CREATE DATABASE softwaredocbuilder;
CREATE USER 'softwaredocbuilder'@'localhost' IDENTIFIED BY 'softwaredocbuilder';
GRANT ALL PRIVILEGES ON softwaredocbuilder.* TO 'softwaredocbuilder'@'localhost';
FLUSH PRIVILEGES;
exit;
