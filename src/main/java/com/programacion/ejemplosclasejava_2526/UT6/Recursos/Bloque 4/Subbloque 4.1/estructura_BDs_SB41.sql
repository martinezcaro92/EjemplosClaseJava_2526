-- ESTRUCTURAS DE BD VACÍAS para los ejercicios del SB4.1
-- Ejecutar ANTES de los ejercicios para crear las tablas donde se importarán los datos.

-- ── E1: tienda_online ────────────────────────────────────────────────────────
DROP DATABASE IF EXISTS tienda_online;
CREATE DATABASE tienda_online CHARACTER SET utf8mb4;
USE tienda_online;
CREATE TABLE cliente (id INT UNSIGNED NOT NULL AUTO_INCREMENT, nombre VARCHAR(100), email VARCHAR(100), PRIMARY KEY (id));
CREATE TABLE producto (id INT UNSIGNED NOT NULL AUTO_INCREMENT, nombre VARCHAR(100), precio DECIMAL(8,2), stock INT UNSIGNED DEFAULT 0, PRIMARY KEY (id));
CREATE TABLE pedido (id INT UNSIGNED NOT NULL AUTO_INCREMENT, id_cliente INT UNSIGNED, id_producto INT UNSIGNED, cantidad INT UNSIGNED DEFAULT 1, fecha DATE, PRIMARY KEY (id), FOREIGN KEY (id_cliente) REFERENCES cliente(id), FOREIGN KEY (id_producto) REFERENCES producto(id));

-- ── E2: instituto ────────────────────────────────────────────────────────────
DROP DATABASE IF EXISTS instituto;
CREATE DATABASE instituto CHARACTER SET utf8mb4;
USE instituto;
CREATE TABLE alumno (id INT UNSIGNED NOT NULL AUTO_INCREMENT, nombre VARCHAR(100), curso VARCHAR(20), PRIMARY KEY (id));
CREATE TABLE profesor (id INT UNSIGNED NOT NULL AUTO_INCREMENT, nombre VARCHAR(100), especialidad VARCHAR(80), PRIMARY KEY (id));
CREATE TABLE asignatura (id INT UNSIGNED NOT NULL AUTO_INCREMENT, nombre VARCHAR(80), id_profesor INT UNSIGNED, PRIMARY KEY (id), FOREIGN KEY (id_profesor) REFERENCES profesor(id));
CREATE TABLE matricula (id INT UNSIGNED NOT NULL AUTO_INCREMENT, id_alumno INT UNSIGNED, id_asignatura INT UNSIGNED, PRIMARY KEY (id), FOREIGN KEY (id_alumno) REFERENCES alumno(id), FOREIGN KEY (id_asignatura) REFERENCES asignatura(id));

-- ── E3: hotel ────────────────────────────────────────────────────────────────
DROP DATABASE IF EXISTS hotel;
CREATE DATABASE hotel CHARACTER SET utf8mb4;
USE hotel;
CREATE TABLE habitacion (numero INT UNSIGNED NOT NULL, tipo VARCHAR(30), precio DECIMAL(6,2), PRIMARY KEY (numero));
CREATE TABLE cliente_hotel (id INT UNSIGNED NOT NULL AUTO_INCREMENT, nombre VARCHAR(100), dni VARCHAR(15), PRIMARY KEY (id));
CREATE TABLE reserva (id INT UNSIGNED NOT NULL AUTO_INCREMENT, id_cliente INT UNSIGNED, num_habitacion INT UNSIGNED, fecha_entrada DATE, fecha_salida DATE, PRIMARY KEY (id), FOREIGN KEY (id_cliente) REFERENCES cliente_hotel(id), FOREIGN KEY (num_habitacion) REFERENCES habitacion(numero));
INSERT INTO habitacion VALUES (101,'Individual',65.00),(102,'Individual',65.00),(201,'Doble',95.00),(301,'Suite',180.00);

-- ── E4: personas ─────────────────────────────────────────────────────────────
DROP DATABASE IF EXISTS personas;
CREATE DATABASE personas CHARACTER SET utf8mb4;
USE personas;
CREATE TABLE Empleado (id INT(11) NOT NULL AUTO_INCREMENT, nombre VARCHAR(100) NOT NULL, apellidos VARCHAR(200), departamento VARCHAR(100), salario DECIMAL(10,2), fecha_alta DATE, PRIMARY KEY (id));
CREATE TABLE Personas (id INT(11) NOT NULL AUTO_INCREMENT, nombre VARCHAR(255) NOT NULL, apellidos VARCHAR(255), edad INT(11), PRIMARY KEY (id));

-- ── E5: restaurante ──────────────────────────────────────────────────────────
DROP DATABASE IF EXISTS restaurante;
CREATE DATABASE restaurante CHARACTER SET utf8mb4;
USE restaurante;
CREATE TABLE mesa (id INT UNSIGNED NOT NULL AUTO_INCREMENT, numero INT UNSIGNED, capacidad INT UNSIGNED, PRIMARY KEY (id));
CREATE TABLE reserva_rest (id INT UNSIGNED NOT NULL AUTO_INCREMENT, id_mesa INT UNSIGNED, cliente VARCHAR(100), fecha DATE, hora TIME, PRIMARY KEY (id), FOREIGN KEY (id_mesa) REFERENCES mesa(id));
INSERT INTO mesa (numero, capacidad) VALUES (1,2),(2,4),(3,4),(4,6),(5,8);
