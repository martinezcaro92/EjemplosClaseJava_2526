-- Ejecutar DESPUES de instituto.sql (SB 3.1 E4)
-- Datos de prueba para el Ejercicio 2 del SB 3.2

USE instituto;

INSERT INTO profesor (nombre, especialidad) VALUES
    ('Elena Ruiz',    'Programacion'),
    ('Carlos Mora',   'Bases de Datos'),
    ('Pilar Vega',    'Redes');

INSERT INTO asignatura (nombre, id_profesor) VALUES
    ('Programacion',             1),
    ('Acceso a Datos',           2),
    ('Sistemas Informaticos',    3),
    ('Entornos de Desarrollo',   1);

INSERT INTO alumno (nombre, curso) VALUES
    ('Ana Garcia',    'DAM1'),
    ('Luis Perez',    'DAM2'),
    ('Marta Sanz',    'DAW1'),
    ('David Ruiz',    'DAW1'),
    ('Sofia Torres',  'DAM1'),
    ('Carlos Mendez', 'DAM2');

INSERT INTO matricula (id_alumno, id_asignatura) VALUES
    (1,1),(1,2),(1,4),
    (2,1),(2,2),
    (3,1),(3,3),
    (4,1),(4,3),(4,4),
    (5,1),(5,2),(5,4),
    (6,1);
