-- SCRIPT DE REFERENCIA - parking_municipal (Ejercicio 5 del SB3.4)
-- Este script SQL es el equivalente a lo que el programa Java debe replicar.
-- Puedes ejecutarlo en MySQL Workbench para verificar el resultado.
DROP DATABASE IF EXISTS parking_municipal;
CREATE DATABASE parking_municipal CHARACTER SET utf8mb4;
USE parking_municipal;

CREATE TABLE plaza (
    id     INT UNSIGNED NOT NULL AUTO_INCREMENT,
    numero INT UNSIGNED,
    tipo   VARCHAR(30),
    PRIMARY KEY (id)
);

CREATE TABLE registro_parking (
    id        INT UNSIGNED NOT NULL AUTO_INCREMENT,
    matricula VARCHAR(10),
    id_plaza  INT UNSIGNED,
    entrada   DATETIME,
    salida    DATETIME DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_plaza) REFERENCES plaza(id)
);

INSERT INTO plaza (numero, tipo) VALUES
    (1,'Normal'),(2,'Normal'),(3,'Normal'),
    (4,'Minusvalidos'),(5,'Motos');

INSERT INTO registro_parking (matricula, id_plaza, entrada, salida) VALUES
    ('1234ABC', 1, '2025-01-10 08:00:00', '2025-01-10 10:30:00'),
    ('5678DEF', 2, '2025-01-10 08:15:00', '2025-01-10 09:45:00'),
    ('9012GHI', 4, '2025-01-10 09:00:00', NULL),
    ('3456JKL', 1, '2025-01-10 10:45:00', '2025-01-10 12:00:00');

SELECT r.matricula, p.numero AS plaza, p.tipo, r.entrada, r.salida
FROM registro_parking r JOIN plaza p ON r.id_plaza = p.id
ORDER BY r.entrada;
