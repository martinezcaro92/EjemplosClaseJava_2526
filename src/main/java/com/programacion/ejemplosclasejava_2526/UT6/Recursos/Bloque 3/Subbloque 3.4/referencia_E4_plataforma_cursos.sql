-- SCRIPT DE REFERENCIA - plataforma_cursos (Ejercicio 4 del SB3.4)
-- Este script SQL es el equivalente a lo que el programa Java debe replicar.
-- Puedes ejecutarlo en MySQL Workbench para verificar el resultado.
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

INSERT INTO profesor_online (nombre, email) VALUES
    ('Elena Ruiz',    'elena@plataforma.com'),
    ('Tomas Gil',     'tomas@plataforma.com');

INSERT INTO curso (titulo, duracion_h, id_profesor) VALUES
    ('Java desde cero',     40, 1),
    ('SQL avanzado',        20, 1),
    ('Python para datos',   35, 2),
    ('Desarrollo web HTML', 30, 2);

SELECT c.titulo, c.duracion_h, p.nombre AS profesor
FROM curso c JOIN profesor_online p ON c.id_profesor = p.id
ORDER BY p.nombre, c.titulo;
