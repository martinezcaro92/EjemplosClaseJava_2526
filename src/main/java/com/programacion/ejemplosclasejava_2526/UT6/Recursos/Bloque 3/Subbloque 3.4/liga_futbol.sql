-- Script completo a replicar desde Java - Ejercicio 1

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

INSERT INTO equipo (nombre, ciudad) VALUES ('Atletico',  'Madrid');
INSERT INTO equipo (nombre, ciudad) VALUES ('Villarreal','Villarreal');
INSERT INTO equipo (nombre, ciudad) VALUES ('Levante',   'Valencia');

INSERT INTO jugador (nombre, posicion, id_equipo) VALUES ('Morata',    'Delantero',    1);
INSERT INTO jugador (nombre, posicion, id_equipo) VALUES ('Griezmann', 'Mediocampista',1);
INSERT INTO jugador (nombre, posicion, id_equipo) VALUES ('Oblak',     'Portero',      1);
INSERT INTO jugador (nombre, posicion, id_equipo) VALUES ('Danjuma',   'Delantero',    2);
INSERT INTO jugador (nombre, posicion, id_equipo) VALUES ('Parejo',    'Mediocampista',2);
INSERT INTO jugador (nombre, posicion, id_equipo) VALUES ('Roger',     'Delantero',    3);
INSERT INTO jugador (nombre, posicion, id_equipo) VALUES ('Sin equipo','Delantero',    NULL);
