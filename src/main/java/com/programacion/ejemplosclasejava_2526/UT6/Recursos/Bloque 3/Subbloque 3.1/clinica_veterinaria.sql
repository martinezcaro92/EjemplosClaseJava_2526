-- Script SQL de referencia - Ejercicio 1
-- El alumno debe replicar estas sentencias desde Java

DROP DATABASE IF EXISTS clinica_veterinaria;
CREATE DATABASE clinica_veterinaria CHARACTER SET utf8mb4;
USE clinica_veterinaria;

CREATE TABLE propietario (
    id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre   VARCHAR(100) NOT NULL,
    telefono VARCHAR(15),
    PRIMARY KEY (id)
);

CREATE TABLE animal (
    id              INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre          VARCHAR(50),
    especie         VARCHAR(50),
    id_propietario  INT UNSIGNED DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_propietario) REFERENCES propietario(id)
);
