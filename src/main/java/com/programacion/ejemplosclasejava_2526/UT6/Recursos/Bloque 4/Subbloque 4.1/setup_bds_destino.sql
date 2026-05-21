-- Prepara las BDs destino para los ejercicios del Subbloque 4.1
-- Ejecutar ANTES de los ejercicios Java de este subbloque

-- ── E1: tienda_online con tabla producto vacía ──
DROP DATABASE IF EXISTS tienda_online;
CREATE DATABASE tienda_online CHARACTER SET utf8mb4;
USE tienda_online;
CREATE TABLE producto (
    id     INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100),
    precio DECIMAL(8,2),
    stock  INT UNSIGNED DEFAULT 0,
    PRIMARY KEY (id)
);

-- ── E2: instituto con tabla alumno vacía ──
DROP DATABASE IF EXISTS instituto;
CREATE DATABASE instituto CHARACTER SET utf8mb4;
USE instituto;
CREATE TABLE alumno (
    id     INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    curso  VARCHAR(20),
    PRIMARY KEY (id)
);

-- ── E3: hotel con tablas y datos mínimos ──
DROP DATABASE IF EXISTS hotel;
CREATE DATABASE hotel CHARACTER SET utf8mb4;
USE hotel;
CREATE TABLE cliente_hotel (
    id     INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    dni    VARCHAR(15),
    PRIMARY KEY (id)
);

-- ── E4: personas con tabla Empleado vacía ──
-- (Asegurarse de que la BD personas ya existe con la tabla Empleado)
USE personas;
DELETE FROM Empleado;

-- ── E5: restaurante con tablas y datos de mesas ──
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
    id      INT UNSIGNED NOT NULL AUTO_INCREMENT,
    id_mesa INT UNSIGNED,
    cliente VARCHAR(100),
    fecha   DATE,
    hora    TIME,
    PRIMARY KEY (id),
    FOREIGN KEY (id_mesa) REFERENCES mesa(id)
);
INSERT INTO mesa (numero, capacidad) VALUES (1,4),(2,6),(3,2),(4,8);
