-- Setup para Ejercicios 1, 2 y 5 del SB 3.3
-- Crea la BD y tablas vacías listas para recibir INSERTs desde Java

DROP DATABASE IF EXISTS tienda_online;
CREATE DATABASE tienda_online CHARACTER SET utf8mb4;
USE tienda_online;

CREATE TABLE cliente (
    id     INT UNSIGNED NOT NULL AUTO_INCREMENT,
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
