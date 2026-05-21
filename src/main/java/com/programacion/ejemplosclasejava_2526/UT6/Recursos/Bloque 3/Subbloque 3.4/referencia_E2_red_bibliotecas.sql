-- SCRIPT DE REFERENCIA - red_bibliotecas (Ejercicio 2 del SB3.4)
-- Este script SQL es el equivalente a lo que el programa Java debe replicar.
-- Puedes ejecutarlo en MySQL Workbench para verificar el resultado.
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
    anio     YEAR,
    PRIMARY KEY (id),
    FOREIGN KEY (id_autor) REFERENCES autor(id)
);

CREATE TABLE prestamo (
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    id_libro    INT UNSIGNED,
    socio       VARCHAR(100),
    fecha_inicio DATE,
    fecha_fin    DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (id_libro) REFERENCES libro(id)
);

INSERT INTO autor (nombre, pais) VALUES ('Gabriel Garcia Marquez','Colombia');
INSERT INTO autor (nombre, pais) VALUES ('Miguel de Cervantes',   'Espania');
INSERT INTO autor (nombre, pais) VALUES ('Isabel Allende',        'Chile');
INSERT INTO autor (nombre, pais) VALUES ('Mario Vargas Llosa',    'Peru');

INSERT INTO libro (titulo, id_autor, anio) VALUES ('Cien anios de soledad', 1, 1967);
INSERT INTO libro (titulo, id_autor, anio) VALUES ('El Quijote',            2, 1605);
INSERT INTO libro (titulo, id_autor, anio) VALUES ('La Casa de los Espiritus',3,1982);
INSERT INTO libro (titulo, id_autor, anio) VALUES ('La Ciudad y los Perros',4, 1963);

INSERT INTO prestamo (id_libro, socio, fecha_inicio, fecha_fin) VALUES
    (1, 'Carlos Ruiz',  '2025-01-10', '2025-01-24'),
    (3, 'Ana Martinez', '2025-01-12', '2025-01-26'),
    (2, 'Luis Perez',   '2025-01-15', '2025-01-29');

SELECT l.titulo, a.nombre AS autor, a.pais
FROM libro l JOIN autor a ON l.id_autor = a.id
ORDER BY a.nombre;
