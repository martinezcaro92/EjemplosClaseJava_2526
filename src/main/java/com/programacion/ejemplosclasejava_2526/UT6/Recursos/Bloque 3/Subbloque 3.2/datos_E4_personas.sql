-- DATOS DE PRUEBA - personas / tabla Empleado (Ejercicio 4)
-- Compatible con la BD generada en GenerarBD.java del material de clase.
DROP DATABASE IF EXISTS personas;
CREATE DATABASE personas CHARACTER SET utf8mb4;
USE personas;

CREATE TABLE Empleado (
    id           INT(11)       NOT NULL AUTO_INCREMENT,
    nombre       VARCHAR(100)  NOT NULL,
    apellidos    VARCHAR(200)  DEFAULT NULL,
    departamento VARCHAR(100)  DEFAULT NULL,
    salario      DECIMAL(10,2) DEFAULT NULL,
    fecha_alta   DATE          DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Personas (
    id        INT(11)      NOT NULL AUTO_INCREMENT,
    nombre    VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) DEFAULT NULL,
    edad      INT(11)      DEFAULT NULL,
    PRIMARY KEY (id)
);

INSERT INTO Empleado (nombre, apellidos, departamento, salario, fecha_alta) VALUES
    ('Elena',    'Garcia Ruiz',    'Informatica',     2800.00, '2022-03-01'),
    ('Raul',     'Perez Molina',   'Recursos Humanos',2400.00, '2021-06-15'),
    ('Laura',    'Sanz Torres',    'Ventas',          2100.00, '2023-01-10'),
    ('Carlos',   'Lopez Blanco',   'Informatica',     3100.00, '2020-09-20'),
    ('Patricia', 'Ruiz Castillo',  'Contabilidad',    2600.00, '2022-11-05'),
    ('Miguel',   'Vidal Navarro',  'Ventas',          2250.00, '2023-04-18'),
    ('Isabel',   'Moreno Gil',     'Informatica',     2950.00, '2021-02-28'),
    ('Francisco','Jimenez Santos', 'Recursos Humanos',2300.00, '2024-01-07');
