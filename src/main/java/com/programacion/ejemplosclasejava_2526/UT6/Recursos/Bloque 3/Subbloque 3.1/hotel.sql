-- Script SQL de referencia - Ejercicio 3

DROP DATABASE IF EXISTS hotel;
CREATE DATABASE hotel CHARACTER SET utf8mb4;
USE hotel;

CREATE TABLE habitacion (
    numero   INT UNSIGNED NOT NULL,
    tipo     VARCHAR(30),
    precio   DECIMAL(6,2),
    PRIMARY KEY (numero)
);

CREATE TABLE cliente_hotel (
    id     INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    dni    VARCHAR(15),
    PRIMARY KEY (id)
);

CREATE TABLE reserva (
    id             INT UNSIGNED NOT NULL AUTO_INCREMENT,
    id_cliente     INT UNSIGNED,
    num_habitacion INT UNSIGNED,
    fecha_entrada  DATE,
    fecha_salida   DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (id_cliente)     REFERENCES cliente_hotel(id),
    FOREIGN KEY (num_habitacion) REFERENCES habitacion(numero)
);
