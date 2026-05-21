-- Ejecutar DESPUES de hotel.sql (SB 3.1 E3)
-- Datos de prueba para el Ejercicio 3 del SB 3.2

USE hotel;

INSERT INTO habitacion (numero, tipo, precio) VALUES
    (101, 'Individual',  65.00),
    (102, 'Individual',  65.00),
    (201, 'Doble',       95.00),
    (205, 'Doble',       95.00),
    (301, 'Suite',      180.00),
    (312, 'Doble',       95.00),
    (408, 'Suite',      180.00);

INSERT INTO cliente_hotel (nombre, dni) VALUES
    ('Carlos Mendez',   '12345678A'),
    ('Lucia Fernandez', '23456789B'),
    ('Pedro Sanchez',   '34567890C'),
    ('Ana Torres',      '45678901D'),
    ('Jorge Blanco',    '56789012E');

INSERT INTO reserva (id_cliente, num_habitacion, fecha_entrada, fecha_salida) VALUES
    (1, 101, '2025-02-14', '2025-02-17'),
    (2, 205, '2025-02-20', '2025-02-22'),
    (3, 312, '2025-03-01', '2025-03-05'),
    (4, 101, '2025-03-10', '2025-03-12'),
    (5, 408, '2025-03-15', '2025-03-20');
