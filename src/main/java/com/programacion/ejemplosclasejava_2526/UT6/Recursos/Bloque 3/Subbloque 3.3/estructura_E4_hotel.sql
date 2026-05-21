-- ESTRUCTURA BASE - hotel (Ejercicio 4 del SB3.3)
-- Incluye habitaciones de muestra para poder realizar reservas.
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

-- Habitaciones de muestra (necesarias para poder insertar reservas)
INSERT INTO habitacion (numero, tipo, precio) VALUES
    (101,'Individual', 65.00),
    (102,'Individual', 65.00),
    (201,'Doble',      95.00),
    (202,'Doble',      95.00),
    (301,'Suite',     180.00);

-- Clientes de muestra
INSERT INTO cliente_hotel (nombre, dni) VALUES
    ('Ana Garcia',   '12345678A'),
    ('Luis Perez',   '87654321B'),
    ('Marta Sanz',   '11223344C');
