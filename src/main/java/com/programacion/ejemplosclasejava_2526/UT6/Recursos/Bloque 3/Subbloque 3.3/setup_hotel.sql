-- Setup para Ejercicio 4 del SB 3.3
-- Crea la BD hotel con datos iniciales de habitaciones necesarios
-- para poder insertar reservas con FK válidas

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

-- Datos mínimos de habitaciones para poder insertar reservas
INSERT INTO habitacion (numero, tipo, precio) VALUES
    (101, 'Individual',  65.00),
    (201, 'Doble',       95.00),
    (301, 'Suite',      180.00);

-- Clientes de ejemplo para asociar reservas
INSERT INTO cliente_hotel (nombre, dni) VALUES
    ('Carlos Mendez',   '12345678A'),
    ('Lucia Fernandez', '23456789B'),
    ('Pedro Sanchez',   '34567890C');
