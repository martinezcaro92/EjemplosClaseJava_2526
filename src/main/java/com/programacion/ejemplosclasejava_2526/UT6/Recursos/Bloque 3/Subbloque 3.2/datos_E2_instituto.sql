-- DATOS DE PRUEBA - instituto (Ejercicio 2)
DROP DATABASE IF EXISTS instituto;
CREATE DATABASE instituto CHARACTER SET utf8mb4;
USE instituto;

CREATE TABLE alumno (
    id     INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    curso  VARCHAR(20),
    PRIMARY KEY (id)
);

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

CREATE TABLE matricula (
    id            INT UNSIGNED NOT NULL AUTO_INCREMENT,
    id_alumno     INT UNSIGNED,
    id_asignatura INT UNSIGNED,
    PRIMARY KEY (id),
    FOREIGN KEY (id_alumno)     REFERENCES alumno(id),
    FOREIGN KEY (id_asignatura) REFERENCES asignatura(id)
);

INSERT INTO profesor (nombre, especialidad) VALUES
    ('Maria Lopez',   'Informatica'),
    ('Juan Martinez', 'Matematicas'),
    ('Sara Gomez',    'Ingles');

INSERT INTO asignatura (nombre, id_profesor) VALUES
    ('Programacion',         1),
    ('Bases de Datos',       1),
    ('Matematicas',          2),
    ('Ingles Tecnico',       3);

INSERT INTO alumno (nombre, curso) VALUES
    ('Sofia Torres',   'DAM1'),
    ('Pablo Mora',     'DAM1'),
    ('Lucia Fuentes',  'DAW2'),
    ('Mario Vidal',    'DAM2'),
    ('Nerea Blanco',   'DAW1'),
    ('Oscar Molina',   'DAW2');

INSERT INTO matricula (id_alumno, id_asignatura) VALUES
    (1,1),(1,2),(1,3),
    (2,1),(2,4),
    (3,1),(3,2),(3,4),
    (4,1),(4,3),
    (5,1),(5,2),
    (6,2),(6,4);
