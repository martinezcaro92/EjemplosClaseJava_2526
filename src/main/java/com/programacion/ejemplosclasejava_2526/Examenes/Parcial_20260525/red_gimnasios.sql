-- 1. Recrear la BD desde cero
DROP DATABASE IF EXISTS red_gimnasios;
CREATE DATABASE red_gimnasios CHARACTER SET utf8mb4;
USE red_gimnasios;

-- 2. Tabla de gimnasios (sedes de la cadena)
CREATE TABLE gimnasio (
    id         INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre     VARCHAR(80)  NOT NULL,
    ciudad     VARCHAR(60),
    direccion  VARCHAR(150),
    telefono   VARCHAR(15),
    capacidad  INT UNSIGNED DEFAULT 0,
    PRIMARY KEY (id)
);

-- 3. Tabla de modalidades de suscripción
CREATE TABLE modalidad (
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre      VARCHAR(50)  NOT NULL,
    precio_mes  DECIMAL(6,2) NOT NULL,
    acceso_24h  BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (id)
);

-- 4. Tabla de socios
CREATE TABLE socio (
    id           INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre       VARCHAR(80)  NOT NULL,
    apellidos    VARCHAR(120),
    email        VARCHAR(100),
    fecha_alta   DATE,
    id_gimnasio  INT UNSIGNED,
    id_modalidad INT UNSIGNED,
    PRIMARY KEY (id),
    FOREIGN KEY (id_gimnasio)  REFERENCES gimnasio(id),
    FOREIGN KEY (id_modalidad) REFERENCES modalidad(id)
);

-- 5. Inserción de gimnasios
INSERT INTO gimnasio (nombre, ciudad, direccion, telefono, capacidad) VALUES
    ('FitZone Murcia',   'Murcia',     'Av. Libertad 12',    '968100001', 300),
    ('FitZone Lorca',    'Lorca',      'C/ Gran Via 45',     '968100002', 180),
    ('FitZone Cartagena','Cartagena',  'Paseo Alfonso X 8',  '968100003', 250),
    ('FitZone Molina',   'Molina de Segura','C/ Mayor 3',    '968100004', 120);

-- 6. Inserción de modalidades
INSERT INTO modalidad (nombre, precio_mes, acceso_24h) VALUES
    ('Basica',    29.99, FALSE),
    ('Premium',   49.99, TRUE),
    ('Familiar',  69.99, TRUE),
    ('Estudiante',19.99, FALSE);

-- 7. Inserción de socios
INSERT INTO socio (nombre, apellidos, email, fecha_alta, id_gimnasio, id_modalidad) VALUES
    ('Ana',    'Garcia Lopez',   'ana@mail.es',   '2023-01-10', 1, 2),
    ('Luis',   'Perez Vega',     'luis@mail.es',  '2023-02-15', 1, 1),
    ('Carmen', 'Ruiz Molina',    'carmen@web.es', '2023-03-01', 2, 3),
    ('Jorge',  'Blanco Serrano', 'jorge@mail.es', '2023-03-20', 2, 2),
    ('Maria',  'Lopez Torres',   'mlopez@web.es', '2023-04-05', 3, 1),
    ('David',  'Sanz Ortega',    'david@mail.es', '2023-05-18', 3, 4),
    ('Sofia',  'Torres Reyes',   'sofia@web.es',  '2023-06-01', 1, 2),
    ('Carlos', 'Mendez Gil',     'carlos@web.es', '2023-07-12', 4, 1),
    ('Lucia',  'Fernandez Cruz', 'lucia@mail.es', '2023-08-10', 4, 4),
    ('Pablo',  'Mora Diaz',      'pablo@web.es',  '2024-01-22', 2, 1),
    ('Elena',  'Castillo Rico',  'elena@mail.es', '2024-02-14', 3, 2),
    ('Raul',   'Jimenez Vidal',  'raul@web.es',   '2024-03-05', 1, 1),
    ('Nuria',  'Blanco Saez',    'nuria@mail.es', '2024-04-19', 2, 3),
    ('Ivan',   'Santos Cano',    'ivan@web.es',   '2024-05-01', 4, 2),
    ('Rosa',   'Marin Fuentes',  'rosa@mail.es',  '2024-06-30', 3, 1);

-- 8. Consultas de verificación
-- 8.1 Listado completo de socios con gimnasio y modalidad
SELECT s.id, s.nombre, s.apellidos, g.nombre AS gimnasio, m.nombre AS modalidad,
       m.precio_mes, s.fecha_alta
FROM socio s
JOIN gimnasio g  ON s.id_gimnasio  = g.id
JOIN modalidad m ON s.id_modalidad = m.id
ORDER BY g.nombre, s.apellidos;

-- 8.2 Número de socios por gimnasio
SELECT g.nombre AS gimnasio, COUNT(s.id) AS num_socios,
       SUM(m.precio_mes) AS ingresos_mes
FROM gimnasio g
LEFT JOIN socio s     ON s.id_gimnasio  = g.id
LEFT JOIN modalidad m ON s.id_modalidad = m.id
GROUP BY g.id, g.nombre
ORDER BY num_socios DESC;

-- 8.3 Socios con modalidad Premium o Familiar
SELECT s.nombre, s.apellidos, m.nombre AS modalidad, m.precio_mes
FROM socio s
JOIN modalidad m ON s.id_modalidad = m.id
WHERE m.nombre IN ('Premium','Familiar')
ORDER BY m.nombre, s.apellidos;

-- 8.4 Informacion completa de todos los gimnasios (SELECT *)
SELECT * FROM gimnasio ORDER BY ciudad;
