-- Ejecutar DESPUES de tienda_online.sql (SB 3.1 E2)
-- Datos de prueba para el Ejercicio 1 del SB 3.2

USE tienda_online;

INSERT INTO cliente (nombre, email) VALUES
    ('Ana Garcia',   'ana.garcia@mail.com'),
    ('Luis Perez',   'luis.perez@correo.es'),
    ('Carmen Ruiz',  'carmen@empresa.com'),
    ('Jorge Blanco', 'jorge.blanco@web.es'),
    ('Maria Lopez',  'mlopez@mail.com');

INSERT INTO producto (nombre, precio, stock) VALUES
    ('Teclado mecanico',    89.99, 15),
    ('Monitor 27 pulgadas',349.00,  6),
    ('Raton inalambrico',   34.50, 22),
    ('Auriculares gaming',  79.95, 10),
    ('Webcam HD',           55.00,  8),
    ('SSD 1TB',             99.00, 30),
    ('Hub USB-C',           29.99, 18);

INSERT INTO pedido (id_cliente, id_producto, cantidad, fecha) VALUES
    (1, 1, 1, '2025-01-10'),
    (2, 2, 1, '2025-01-11'),
    (3, 3, 2, '2025-01-12'),
    (1, 6, 1, '2025-01-13'),
    (4, 4, 1, '2025-01-14'),
    (5, 5, 2, '2025-01-15'),
    (2, 7, 3, '2025-01-16');
