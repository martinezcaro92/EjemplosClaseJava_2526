-- DATOS DE PRUEBA - hotel (Ejercicio 3)
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
    id              INT UNSIGNED NOT NULL AUTO_INCREMENT,
    id_cliente      INT UNSIGNED,
    num_habitacion  INT UNSIGNED,
    fecha_entrada   DATE,
    fecha_salida    DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (id_cliente)     REFERENCES cliente_hotel(id),
    FOREIGN KEY (num_habitacion) REFERENCES habitacion(numero)
);

INSERT INTO habitacion (numero, tipo, precio) VALUES
    (101,'Individual', 65.00),
    (102,'Individual', 65.00),
    (201,'Doble',      95.00),
    (202,'Doble',      95.00),
    (301,'Suite',     180.00);

INSERT INTO cliente_hotel (nombre, dni) VALUES
    ('Ana Garcia',    '12345678A'),
    ('Luis Perez',    '87654321B'),
    ('Marta Sanz',    '11223344C'),
    ('David Ruiz',    '44332211D'),
    ('Carmen Lopez',  '55667788E');

INSERT INTO reserva (id_cliente, num_habitacion, fecha_entrada, fecha_salida) VALUES
    (1, 201, '2025-02-14','2025-02-17'),
    (2, 101, '2025-03-01','2025-03-05'),
    (3, 301, '2025-03-10','2025-03-12'),
    (4, 102, '2025-04-20','2025-04-25'),
    (5, 202, '2025-05-01','2025-05-03');
