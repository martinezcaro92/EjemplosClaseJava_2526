-- DATOS DE PRUEBA - tienda_online (Ejercicio 1)
-- Ejecutar ANTES de Ejercicio1.java para tener registros que consultar.
-- Requiere haber creado la BD con el Ejercicio 1 del Subbloque 3.1 o equivalente.

DROP DATABASE IF EXISTS tienda_online;
CREATE DATABASE tienda_online CHARACTER SET utf8mb4;
USE tienda_online;

CREATE TABLE cliente (
    id    INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    email  VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE producto (
    id     INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100),
    precio DECIMAL(8,2),
    stock  INT UNSIGNED DEFAULT 0,
    PRIMARY KEY (id)
);

CREATE TABLE pedido (
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    id_cliente  INT UNSIGNED,
    id_producto INT UNSIGNED,
    cantidad    INT UNSIGNED DEFAULT 1,
    fecha       DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (id_cliente)  REFERENCES cliente(id),
    FOREIGN KEY (id_producto) REFERENCES producto(id)
);

INSERT INTO cliente (nombre, email) VALUES
    ('Ana Garcia',      'ana@shop.com'),
    ('Luis Perez',      'luis@correo.es'),
    ('Marta Sanz',      'marta@email.net'),
    ('David Ruiz',      'david@web.com'),
    ('Carmen Lopez',    'carmen@tienda.es');

INSERT INTO producto (nombre, precio, stock) VALUES
    ('Teclado mecanico',    89.99,  15),
    ('Monitor 27 pulgadas', 299.00,  8),
    ('Raton inalambrico',    35.50, 22),
    ('Auriculares gaming',   59.99, 10),
    ('Webcam HD',            49.95,  6),
    ('Disco duro externo',   79.00, 18),
    ('Hub USB-C',            29.99, 30),
    ('Alfombrilla XL',       19.95, 40);

INSERT INTO pedido (id_cliente, id_producto, cantidad, fecha) VALUES
    (1, 1, 1, '2025-01-10'),
    (2, 3, 2, '2025-01-11'),
    (1, 5, 1, '2025-01-12'),
    (3, 2, 1, '2025-01-13'),
    (4, 4, 1, '2025-01-14'),
    (5, 7, 3, '2025-01-15'),
    (2, 6, 1, '2025-01-16'),
    (3, 8, 2, '2025-01-17');
