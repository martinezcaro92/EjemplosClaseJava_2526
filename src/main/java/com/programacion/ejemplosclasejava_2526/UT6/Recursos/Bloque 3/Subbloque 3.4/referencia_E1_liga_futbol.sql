-- SCRIPT DE REFERENCIA - liga_futbol (Ejercicio 1 del SB3.4)
-- Este script SQL es el equivalente a lo que el programa Java debe replicar.
-- Puedes ejecutarlo en MySQL Workbench para verificar el resultado.
DROP DATABASE IF EXISTS liga_futbol;
CREATE DATABASE liga_futbol CHARACTER SET utf8mb4;
USE liga_futbol;

CREATE TABLE equipo (
    id     INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(80),
    ciudad VARCHAR(60),
    PRIMARY KEY (id)
);

CREATE TABLE jugador (
    id        INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre    VARCHAR(100),
    posicion  VARCHAR(30),
    id_equipo INT UNSIGNED DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_equipo) REFERENCES equipo(id)
);

INSERT INTO equipo (nombre, ciudad) VALUES ('Atletico',   'Madrid');
INSERT INTO equipo (nombre, ciudad) VALUES ('Villarreal', 'Villarreal');
INSERT INTO equipo (nombre, ciudad) VALUES ('Levante',    'Valencia');

INSERT INTO jugador (nombre, posicion, id_equipo) VALUES ('Morata',    'Delantero',    1);
INSERT INTO jugador (nombre, posicion, id_equipo) VALUES ('Griezmann', 'Mediocampista',1);
INSERT INTO jugador (nombre, posicion, id_equipo) VALUES ('Danjuma',   'Delantero',    2);
INSERT INTO jugador (nombre, posicion, id_equipo) VALUES ('Capoue',    'Mediocampista',2);
INSERT INTO jugador (nombre, posicion, id_equipo) VALUES ('Morales',   'Extremo',      3);
INSERT INTO jugador (nombre, posicion, id_equipo) VALUES ('Sin firma',  'Portero',    NULL);

SELECT j.nombre AS jugador, j.posicion,
       COALESCE(e.nombre, 'Sin equipo') AS equipo
FROM jugador j
LEFT JOIN equipo e ON j.id_equipo = e.id
ORDER BY e.nombre, j.posicion;
