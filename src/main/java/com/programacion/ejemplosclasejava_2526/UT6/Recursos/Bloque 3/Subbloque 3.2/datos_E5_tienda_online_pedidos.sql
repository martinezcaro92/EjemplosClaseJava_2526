-- DATOS DE PRUEBA ADICIONALES - tienda_online para pedidos (Ejercicio 5)
-- Ejecutar DESPUÉS de datos_E1_tienda_online.sql si ya se ejecutó antes.
-- (Si la BD ya existe con datos, este script solo añade más pedidos para
--  tener un historial más rico que consultar.)
USE tienda_online;

-- Pedidos adicionales para enriquecer el historial
INSERT INTO pedido (id_cliente, id_producto, cantidad, fecha) VALUES
    (1, 2, 1, '2025-01-18'),
    (3, 1, 2, '2025-01-19'),
    (5, 4, 1, '2025-01-20'),
    (2, 8, 3, '2025-01-21'),
    (4, 3, 1, '2025-01-22');
