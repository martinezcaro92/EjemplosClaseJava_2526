-- Script completo a replicar desde Java - Ejercicio 4

DROP DATABASE IF EXISTS plataforma_cursos;
CREATE DATABASE plataforma_cursos CHARACTER SET utf8mb4;
USE plataforma_cursos;

CREATE TABLE profesor_online (
    id     INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100),
    email  VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE curso (
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    titulo      VARCHAR(150),
    duracion_h  INT UNSIGNED,
    id_profesor INT UNSIGNED DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_profesor) REFERENCES profesor_online(id)
);

INSERT INTO profesor_online (nombre, email) VALUES ('Elena Ruiz',  'elena@plataforma.com');
INSERT INTO profesor_online (nombre, email) VALUES ('Carlos Mora', 'cmora@plataforma.com');

INSERT INTO curso (titulo, duracion_h, id_profesor) VALUES ('Java desde cero',      40, 1);
INSERT INTO curso (titulo, duracion_h, id_profesor) VALUES ('SQL avanzado',         20, 1);
INSERT INTO curso (titulo, duracion_h, id_profesor) VALUES ('Desarrollo web con HTML/CSS', 30, 2);
INSERT INTO curso (titulo, duracion_h, id_profesor) VALUES ('Python para datos',    35, 2);
