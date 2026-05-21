-- VERIFICACIÓN EJERCICIO 3 - hotel
USE hotel;
SHOW TABLES;
DESCRIBE habitacion;
DESCRIBE cliente_hotel;
DESCRIBE reserva;

INSERT INTO habitacion (numero, tipo, precio) VALUES (101, 'Individual', 65.00);
INSERT INTO habitacion (numero, tipo, precio) VALUES (202, 'Doble',      95.00);
INSERT INTO cliente_hotel (nombre, dni) VALUES ('Luis Perez', '12345678A');
INSERT INTO reserva (id_cliente, num_habitacion, fecha_entrada, fecha_salida)
    VALUES (1, 101, '2025-02-14', '2025-02-17');

SELECT r.id, c.nombre, h.tipo, r.fecha_entrada, r.fecha_salida
FROM reserva r
JOIN cliente_hotel c ON r.id_cliente = c.id
JOIN habitacion h    ON r.num_habitacion = h.numero;
