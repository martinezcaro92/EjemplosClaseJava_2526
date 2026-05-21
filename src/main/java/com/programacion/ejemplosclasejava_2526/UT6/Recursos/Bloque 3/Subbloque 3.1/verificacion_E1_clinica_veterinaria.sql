-- VERIFICACIÓN EJERCICIO 1 - clinica_veterinaria
-- Ejecutar en MySQL Workbench DESPUÉS de correr Ejercicio1.java
-- para comprobar que la estructura se creó correctamente.

USE clinica_veterinaria;

SHOW TABLES;

DESCRIBE propietario;
DESCRIBE animal;

-- Insertar datos de prueba para verificar las restricciones
INSERT INTO propietario (nombre, telefono) VALUES ('Carlos Ruiz', '600111222');
INSERT INTO propietario (nombre, telefono) VALUES ('Ana Martinez', '611333444');

INSERT INTO animal (nombre, especie, id_propietario) VALUES ('Toby',  'Perro',  1);
INSERT INTO animal (nombre, especie, id_propietario) VALUES ('Miau',  'Gato',   2);
INSERT INTO animal (nombre, especie, id_propietario) VALUES ('Nemo',  'Pez',    1);
INSERT INTO animal (nombre, especie, id_propietario) VALUES ('Libre', 'Conejo', NULL);

SELECT a.id, a.nombre AS animal, a.especie,
       COALESCE(p.nombre, 'Sin propietario') AS propietario
FROM animal a
LEFT JOIN propietario p ON a.id_propietario = p.id;
