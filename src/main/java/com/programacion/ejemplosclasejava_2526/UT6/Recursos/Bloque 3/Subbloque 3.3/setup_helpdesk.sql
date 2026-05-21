-- Setup para Ejercicio 5 del SB 3.3
-- Crea la BD helpdesk con la tabla incidencia vacía

DROP DATABASE IF EXISTS helpdesk;
CREATE DATABASE helpdesk CHARACTER SET utf8mb4;
USE helpdesk;

CREATE TABLE incidencia (
    id               INT UNSIGNED NOT NULL AUTO_INCREMENT,
    descripcion      VARCHAR(200),
    prioridad        ENUM('alta','media','baja') DEFAULT 'media',
    tecnico_asignado VARCHAR(100),
    fecha            DATE,
    PRIMARY KEY (id)
);

-- Arrays de ejemplo para inserción masiva (Ejercicio 5)
-- Usar en el código Java como datos de partida:
-- String[] descripciones = {"Fallo de red", "Impresora sin papel", "Email no funciona"};
-- String[] prioridades   = {"alta", "baja", "media"};
-- String[] tecnicos      = {"Marta", "Luis", "Ana"};
-- String[] fechas        = {"2025-01-10", "2025-01-11", "2025-01-12"};
