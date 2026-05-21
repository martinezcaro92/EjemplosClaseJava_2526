-- Script SQL de referencia - Ejercicio 5

DROP DATABASE IF EXISTS biblioteca_digital;
CREATE DATABASE biblioteca_digital CHARACTER SET utf8mb4;
USE biblioteca_digital;

CREATE TABLE autor (
    id     INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100),
    pais   VARCHAR(60),
    PRIMARY KEY (id)
);

CREATE TABLE libro (
    id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
    titulo   VARCHAR(150),
    id_autor INT UNSIGNED DEFAULT NULL,
    anio     YEAR,
    PRIMARY KEY (id),
    FOREIGN KEY (id_autor) REFERENCES autor(id)
);

CREATE TABLE prestamo (
    id           INT UNSIGNED NOT NULL AUTO_INCREMENT,
    id_libro     INT UNSIGNED,
    socio        VARCHAR(100),
    fecha_inicio DATE,
    fecha_fin    DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (id_libro) REFERENCES libro(id)
);
