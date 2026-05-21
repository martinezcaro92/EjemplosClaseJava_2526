-- SCRIPT DE REFERENCIA - restaurante (Ejercicio 3 del SB3.4)
-- Este script SQL es el equivalente a lo que el programa Java debe replicar.
-- Puedes ejecutarlo en MySQL Workbench para verificar el resultado.
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

INSERT INTO mesa (numero, capacidad) VALUES (1,2),(2,4),(3,4),(4,6),(5,8);

INSERT INTO reserva_rest (id_mesa, cliente, fecha, hora) VALUES
    (2,'Carlos Lopez',  '2025-02-14','21:00:00'),
    (4,'Ana Garcia',    '2025-02-14','21:30:00'),
    (1,'Luis Perez',    '2025-02-15','14:00:00'),
    (3,'Marta Sanz',    '2025-02-15','21:00:00'),
    (5,'David Ruiz',    '2025-02-16','14:30:00');

SELECT r.id, m.numero AS mesa, m.capacidad, r.cliente, r.fecha, r.hora
FROM reserva_rest r JOIN mesa m ON r.id_mesa = m.id
ORDER BY r.fecha, r.hora;
