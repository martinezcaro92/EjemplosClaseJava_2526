-- Setup para Ejercicio 3 del SB 3.3
-- Crea la BD instituto con la tabla alumno vacía

DROP DATABASE IF EXISTS instituto;
CREATE DATABASE instituto CHARACTER SET utf8mb4;
USE instituto;

CREATE TABLE profesor (
    id           INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre       VARCHAR(100) NOT NULL,
    especialidad VARCHAR(80),
    PRIMARY KEY (id)
);

CREATE TABLE asignatura (
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre      VARCHAR(80),
    id_profesor INT UNSIGNED DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_profesor) REFERENCES profesor(id)
);

CREATE TABLE alumno (
    id     INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    curso  VARCHAR(20),
    PRIMARY KEY (id)
);

CREATE TABLE matricula (
    id            INT UNSIGNED NOT NULL AUTO_INCREMENT,
    id_alumno     INT UNSIGNED,
    id_asignatura INT UNSIGNED,
    PRIMARY KEY (id),
    FOREIGN KEY (id_alumno)     REFERENCES alumno(id),
    FOREIGN KEY (id_asignatura) REFERENCES asignatura(id)
);
