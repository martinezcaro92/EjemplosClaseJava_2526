-- VERIFICACIÓN EJERCICIO 4 - instituto
USE instituto;
SHOW TABLES;
DESCRIBE alumno;
DESCRIBE profesor;
DESCRIBE asignatura;
DESCRIBE matricula;

INSERT INTO profesor (nombre, especialidad) VALUES ('Maria Lopez', 'Informatica');
INSERT INTO asignatura (nombre, id_profesor) VALUES ('Programacion', 1);
INSERT INTO alumno (nombre, curso) VALUES ('Sofia Torres', 'DAM1');
INSERT INTO matricula (id_alumno, id_asignatura) VALUES (1, 1);

SELECT al.nombre AS alumno, al.curso, asig.nombre AS asignatura, pr.nombre AS profesor
FROM matricula m
JOIN alumno     al   ON m.id_alumno     = al.id
JOIN asignatura asig ON m.id_asignatura = asig.id
JOIN profesor   pr   ON asig.id_profesor = pr.id;
