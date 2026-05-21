-- Poblacion de la BD personas para el Ejercicio 4 del SB 3.2
-- Ejecutar en la BD personas (creada con GenerarBD.java o EjemploAccesoBD.java)

USE personas;

-- Limpiar datos previos si los hay
DELETE FROM Empleado;

INSERT INTO Empleado (nombre, apellidos, departamento, salario, fecha_alta) VALUES
    ('Ana',     'Garcia Ruiz',    'Informatica',      2800.00, '2022-03-01'),
    ('Luis',    'Perez Vega',     'Recursos Humanos', 2400.00, '2021-06-15'),
    ('Carmen',  'Ruiz Molina',    'Contabilidad',     2600.00, '2020-09-10'),
    ('Jorge',   'Blanco Serrano', 'Informatica',      3100.00, '2023-01-20'),
    ('Maria',   'Lopez Torres',   'Marketing',        2200.00, '2022-11-05'),
    ('David',   'Sanz Ortega',    'Contabilidad',     2700.00, '2021-04-18'),
    ('Sofia',   'Torres Reyes',   'Recursos Humanos', 2350.00, '2023-07-01'),
    ('Carlos',  'Mendez Gil',     'Informatica',      3400.00, '2019-02-28'),
    ('Lucia',   'Fernandez Cruz', 'Marketing',        2100.00, '2024-01-10');
