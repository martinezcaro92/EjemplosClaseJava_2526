-- DATOS DE PARTIDA para todos los ejercicios del SB4.2
-- Ejecutar ANTES de los ejercicios para tener datos que exportar a fichero.

-- ── tienda_online (E1) ───────────────────────────────────────────────────────
DROP DATABASE IF EXISTS tienda_online;
CREATE DATABASE tienda_online CHARACTER SET utf8mb4;
USE tienda_online;
CREATE TABLE cliente (id INT UNSIGNED NOT NULL AUTO_INCREMENT, nombre VARCHAR(100), email VARCHAR(100), PRIMARY KEY (id));
CREATE TABLE producto (id INT UNSIGNED NOT NULL AUTO_INCREMENT, nombre VARCHAR(100), precio DECIMAL(8,2), stock INT UNSIGNED DEFAULT 0, PRIMARY KEY (id));
CREATE TABLE pedido (id INT UNSIGNED NOT NULL AUTO_INCREMENT, id_cliente INT UNSIGNED, id_producto INT UNSIGNED, cantidad INT UNSIGNED DEFAULT 1, fecha DATE, PRIMARY KEY (id), FOREIGN KEY (id_cliente) REFERENCES cliente(id), FOREIGN KEY (id_producto) REFERENCES producto(id));
INSERT INTO cliente (nombre, email) VALUES ('Ana Garcia','ana@shop.com'),('Luis Perez','luis@correo.es'),('Marta Sanz','marta@email.net');
INSERT INTO producto (nombre, precio, stock) VALUES ('Teclado mecanico',89.99,15),('Monitor 27 pulgadas',299.00,8),('Raton inalambrico',35.50,22),('Auriculares gaming',59.99,10),('Webcam HD',49.95,6),('Disco duro externo',79.00,18),('Hub USB-C',29.99,30),('Alfombrilla XL',19.95,40);
INSERT INTO pedido (id_cliente, id_producto, cantidad, fecha) VALUES (1,1,1,'2025-01-10'),(2,3,2,'2025-01-11'),(3,2,1,'2025-01-13');

-- ── personas (E2) ────────────────────────────────────────────────────────────
DROP DATABASE IF EXISTS personas;
CREATE DATABASE personas CHARACTER SET utf8mb4;
USE personas;
CREATE TABLE Empleado (id INT(11) NOT NULL AUTO_INCREMENT, nombre VARCHAR(100) NOT NULL, apellidos VARCHAR(200), departamento VARCHAR(100), salario DECIMAL(10,2), fecha_alta DATE, PRIMARY KEY (id));
CREATE TABLE Personas (id INT(11) NOT NULL AUTO_INCREMENT, nombre VARCHAR(255) NOT NULL, apellidos VARCHAR(255), edad INT(11), PRIMARY KEY (id));
INSERT INTO Empleado (nombre, apellidos, departamento, salario, fecha_alta) VALUES
    ('Elena','Garcia Ruiz','Informatica',2800.00,'2022-03-01'),
    ('Raul','Perez Molina','Recursos Humanos',2400.00,'2021-06-15'),
    ('Laura','Sanz Torres','Ventas',2100.00,'2023-01-10'),
    ('Carlos','Lopez Blanco','Informatica',3100.00,'2020-09-20'),
    ('Patricia','Ruiz Castillo','Contabilidad',2600.00,'2022-11-05'),
    ('Miguel','Vidal Navarro','Ventas',2250.00,'2023-04-18');

-- ── hotel (E3) ───────────────────────────────────────────────────────────────
DROP DATABASE IF EXISTS hotel;
CREATE DATABASE hotel CHARACTER SET utf8mb4;
USE hotel;
CREATE TABLE habitacion (numero INT UNSIGNED NOT NULL, tipo VARCHAR(30), precio DECIMAL(6,2), PRIMARY KEY (numero));
CREATE TABLE cliente_hotel (id INT UNSIGNED NOT NULL AUTO_INCREMENT, nombre VARCHAR(100), dni VARCHAR(15), PRIMARY KEY (id));
CREATE TABLE reserva (id INT UNSIGNED NOT NULL AUTO_INCREMENT, id_cliente INT UNSIGNED, num_habitacion INT UNSIGNED, fecha_entrada DATE, fecha_salida DATE, PRIMARY KEY (id), FOREIGN KEY (id_cliente) REFERENCES cliente_hotel(id), FOREIGN KEY (num_habitacion) REFERENCES habitacion(numero));
INSERT INTO habitacion VALUES (101,'Individual',65.00),(201,'Doble',95.00),(301,'Suite',180.00);
INSERT INTO cliente_hotel (nombre, dni) VALUES ('Ana Garcia','12345678A'),('Luis Perez','87654321B'),('Marta Sanz','11223344C');
INSERT INTO reserva (id_cliente, num_habitacion, fecha_entrada, fecha_salida) VALUES (1,201,'2025-02-14','2025-02-17'),(2,101,'2025-03-01','2025-03-05'),(3,301,'2025-03-10','2025-03-12');

-- ── instituto (E4) ───────────────────────────────────────────────────────────
DROP DATABASE IF EXISTS instituto;
CREATE DATABASE instituto CHARACTER SET utf8mb4;
USE instituto;
CREATE TABLE alumno (id INT UNSIGNED NOT NULL AUTO_INCREMENT, nombre VARCHAR(100), curso VARCHAR(20), PRIMARY KEY (id));
CREATE TABLE profesor (id INT UNSIGNED NOT NULL AUTO_INCREMENT, nombre VARCHAR(100), especialidad VARCHAR(80), PRIMARY KEY (id));
CREATE TABLE asignatura (id INT UNSIGNED NOT NULL AUTO_INCREMENT, nombre VARCHAR(80), id_profesor INT UNSIGNED, PRIMARY KEY (id), FOREIGN KEY (id_profesor) REFERENCES profesor(id));
CREATE TABLE matricula (id INT UNSIGNED NOT NULL AUTO_INCREMENT, id_alumno INT UNSIGNED, id_asignatura INT UNSIGNED, PRIMARY KEY (id), FOREIGN KEY (id_alumno) REFERENCES alumno(id), FOREIGN KEY (id_asignatura) REFERENCES asignatura(id));
INSERT INTO profesor (nombre, especialidad) VALUES ('Maria Lopez','Informatica');
INSERT INTO asignatura (nombre, id_profesor) VALUES ('Programacion',1),('Bases de Datos',1);
INSERT INTO alumno (nombre, curso) VALUES ('Sofia Torres','DAM1'),('Pablo Mora','DAM1'),('Lucia Fuentes','DAW2'),('Mario Vidal','DAM2'),('Nerea Blanco','DAW1'),('Oscar Molina','DAW2');

-- ── red_bibliotecas (E5) ─────────────────────────────────────────────────────
DROP DATABASE IF EXISTS red_bibliotecas;
CREATE DATABASE red_bibliotecas CHARACTER SET utf8mb4;
USE red_bibliotecas;
CREATE TABLE autor (id INT UNSIGNED NOT NULL AUTO_INCREMENT, nombre VARCHAR(100), pais VARCHAR(60), PRIMARY KEY (id));
CREATE TABLE libro (id INT UNSIGNED NOT NULL AUTO_INCREMENT, titulo VARCHAR(150), id_autor INT UNSIGNED, anio YEAR, PRIMARY KEY (id), FOREIGN KEY (id_autor) REFERENCES autor(id));
INSERT INTO autor (nombre, pais) VALUES ('Gabriel Garcia Marquez','Colombia'),('Miguel de Cervantes','Espania'),('Isabel Allende','Chile'),('Mario Vargas Llosa','Peru');
INSERT INTO libro (titulo, id_autor, anio) VALUES ('Cien anios de soledad',1,1967),('El Quijote',2,1605),('La Casa de los Espiritus',3,1982),('La Ciudad y los Perros',4,1963);
