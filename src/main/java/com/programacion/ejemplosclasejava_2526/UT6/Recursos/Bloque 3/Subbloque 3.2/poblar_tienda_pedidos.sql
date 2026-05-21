-- Datos adicionales para el Ejercicio 5 del SB 3.2 (historial de pedidos)
-- Requiere poblar_tienda_online.sql ejecutado previamente

USE tienda_online;

-- Pedidos adicionales para tener un historial más completo
INSERT INTO pedido (id_cliente, id_producto, cantidad, fecha) VALUES
    (3, 1, 1, '2025-01-20'),
    (4, 6, 2, '2025-01-21'),
    (5, 2, 1, '2025-01-22'),
    (1, 7, 2, '2025-01-23'),
    (2, 4, 1, '2025-01-24');
