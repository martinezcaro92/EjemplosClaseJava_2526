-- Script completo a replicar desde Java - Ejercicio 5

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

INSERT INTO plaza (numero, tipo) VALUES (1, 'Normal');
INSERT INTO plaza (numero, tipo) VALUES (2, 'Normal');
INSERT INTO plaza (numero, tipo) VALUES (3, 'Minusvalidos');
INSERT INTO plaza (numero, tipo) VALUES (4, 'Motos');

INSERT INTO registro_parking (matricula, id_plaza, entrada, salida) VALUES
    ('1234ABC', 1, '2025-01-10 09:00:00', '2025-01-10 11:30:00');
INSERT INTO registro_parking (matricula, id_plaza, entrada, salida) VALUES
    ('5678DEF', 2, '2025-01-10 10:15:00', '2025-01-10 12:00:00');
INSERT INTO registro_parking (matricula, id_plaza, entrada) VALUES
    ('9012GHI', 1, '2025-01-10 14:00:00');
