-- VERIFICACIÓN EJERCICIO 5 - biblioteca_digital
USE biblioteca_digital;
SHOW TABLES;
DESCRIBE autor;
DESCRIBE libro;
DESCRIBE prestamo;

INSERT INTO autor (nombre, pais) VALUES ('Gabriel Garcia Marquez', 'Colombia');
INSERT INTO libro (titulo, id_autor, anio) VALUES ('Cien anios de soledad', 1, 1967);
INSERT INTO prestamo (id_libro, socio, fecha_inicio, fecha_fin)
    VALUES (1, 'Carlos Ruiz', '2025-01-10', '2025-01-24');

SELECT l.titulo, a.nombre AS autor, p.socio, p.fecha_inicio, p.fecha_fin
FROM prestamo p
JOIN libro  l ON p.id_libro  = l.id
JOIN autor  a ON l.id_autor  = a.id;
