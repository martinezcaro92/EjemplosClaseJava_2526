-- ESTRUCTURA BASE - helpdesk (Ejercicio 5 del SB3.3)
DROP DATABASE IF EXISTS helpdesk;
CREATE DATABASE helpdesk CHARACTER SET utf8mb4;
USE helpdesk;

CREATE TABLE incidencia (
    id               INT UNSIGNED NOT NULL AUTO_INCREMENT,
    descripcion      VARCHAR(200),
    prioridad        VARCHAR(10),
    tecnico_asignado VARCHAR(100),
    fecha            DATE,
    PRIMARY KEY (id)
);
