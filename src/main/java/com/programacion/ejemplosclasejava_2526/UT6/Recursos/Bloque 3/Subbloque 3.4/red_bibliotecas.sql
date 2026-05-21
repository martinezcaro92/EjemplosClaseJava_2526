-- Script completo a replicar desde Java - Ejercicio 2

DROP DATABASE IF EXISTS red_bibliotecas;
CREATE DATABASE red_bibliotecas CHARACTER SET utf8mb4;
USE red_bibliotecas;

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
    PRIMARY KEY (id),
    FOREIGN KEY (id_autor) REFERENCES autor(id)
);

INSERT INTO autor (nombre, pais) VALUES ('Gabriel Garcia Marquez', 'Colombia');
INSERT INTO autor (nombre, pais) VALUES ('Miguel de Cervantes',    'Espana');
INSERT INTO autor (nombre, pais) VALUES ('Jorge Luis Borges',      'Argentina');
INSERT INTO autor (nombre, pais) VALUES ('Isabel Allende',         'Chile');

INSERT INTO libro (titulo, id_autor) VALUES ('Cien anos de soledad',  1);
INSERT INTO libro (titulo, id_autor) VALUES ('El amor en los tiempos del colera', 1);
INSERT INTO libro (titulo, id_autor) VALUES ('El Quijote',            2);
INSERT INTO libro (titulo, id_autor) VALUES ('Ficciones',             3);
INSERT INTO libro (titulo, id_autor) VALUES ('La casa de los espiritus', 4);
