-- VERIFICACIÓN EJERCICIO 2 - tienda_online
USE tienda_online;
SHOW TABLES;
DESCRIBE cliente;
DESCRIBE producto;
DESCRIBE pedido;

INSERT INTO cliente (nombre, email) VALUES ('Ana Garcia', 'ana@shop.com');
INSERT INTO producto (nombre, precio, stock) VALUES ('Teclado', 49.99, 20);
INSERT INTO pedido (id_cliente, id_producto, cantidad, fecha) VALUES (1, 1, 2, '2025-01-15');

SELECT p.id, c.nombre AS cliente, pr.nombre AS producto, p.cantidad, p.fecha
FROM pedido p
JOIN cliente c  ON p.id_cliente  = c.id
JOIN producto pr ON p.id_producto = pr.id;
