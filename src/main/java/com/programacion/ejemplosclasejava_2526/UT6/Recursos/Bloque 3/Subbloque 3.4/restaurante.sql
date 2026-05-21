-- Script completo a replicar desde Java - Ejercicio 3

DROP DATABASE IF EXISTS restaurante;
CREATE DATABASE restaurante CHARACTER SET utf8mb4;
USE restaurante;

CREATE TABLE mesa (
    id        INT UNSIGNED NOT NULL AUTO_INCREMENT,
    numero    INT UNSIGNED,
    capacidad INT UNSIGNED,
    PRIMARY KEY (id)
);

CREATE TABLE reserva_rest (
    id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
    id_mesa  INT UNSIGNED,
    cliente  VARCHAR(100),
    fecha    DATE,
    hora     TIME,
    PRIMARY KEY (id),
    FOREIGN KEY (id_mesa) REFERENCES mesa(id)
);

INSERT INTO mesa (numero, capacidad) VALUES (1, 4);
INSERT INTO mesa (numero, capacidad) VALUES (2, 6);
INSERT INTO mesa (numero, capacidad) VALUES (3, 2);
INSERT INTO mesa (numero, capacidad) VALUES (4, 8);

INSERT INTO reserva_rest (id_mesa, cliente, fecha, hora) VALUES (1,'Carlos Lopez',    '2025-02-14','21:00:00');
INSERT INTO reserva_rest (id_mesa, cliente, fecha, hora) VALUES (2,'Ana Martinez',     '2025-02-14','20:30:00');
INSERT INTO reserva_rest (id_mesa, cliente, fecha, hora) VALUES (3,'Pedro Sanchez',    '2025-02-15','14:00:00');
INSERT INTO reserva_rest (id_mesa, cliente, fecha, hora) VALUES (1,'Lucia Fernandez',  '2025-02-15','21:30:00');
