DROP DATABASE IF EXISTS empresa_nominas;
CREATE DATABASE empresa_nominas CHARACTER SET utf8mb4;
USE empresa_nominas;

-- -----------------------------------------------------------------------------
-- Crear la tabla nominas
--
-- Propósito:  Define la estructura que almacenará los datos del CSV.
--             Cada columna se corresponde exactamente con un campo del
--             fichero nominas.csv (mismos nombres, mismo orden).
--
--
-- TIPOS DE DATOS UTILIZADOS (aprende a identificarlos en el CSV):
--   · INT            → número entero sin decimales (empleado_id).
--                      PRIMARY KEY garantiza unicidad: no puede haber dos
--                      empleados con el mismo id.
--   · VARCHAR(n)     → texto de longitud variable, máximo n caracteres.
--                      Usar VARCHAR en vez de CHAR ahorra espacio en disco.
--   · DECIMAL(10,2)  → número decimal con hasta 10 dígitos y 2 decimales.
--                      Ideal para importes monetarios: evita los errores de
--                      redondeo que produciría usar FLOAT o DOUBLE.
--                      Ejemplo: 2800.50 se almacena exactamente como 2800.50.
--   · DATE           → fecha en formato YYYY-MM-DD (ej: 2021-03-15).
--                      MySQL rechaza otros formatos; asegúrate de que el CSV
--                      usa este mismo formato en la columna fecha_alta.
--   · TINYINT(1)     → booleano en MySQL. Java no tiene un tipo SQL BOOLEAN
--                      directo; se mapea a TINYINT(1):
--                        1 → true  (empleado activo)
--                        0 → false (empleado de baja)
--                      En generarInsertPorEmpleado() convierte el boolean
--                      Java a int: activoInt = activo ? 1 : 0;
--
-- NOT NULL → el campo es obligatorio; MySQL rechaza inserciones sin ese valor.
-- -----------------------------------------------------------------------------
CREATE TABLE nominas (
    empleado_id   INT            NOT NULL,   -- Identificador único del empleado
    nombre        VARCHAR(50)    NOT NULL,   -- Nombre de pila
    apellidos     VARCHAR(100)   NOT NULL,   -- Apellidos completos
    departamento  VARCHAR(50)    NOT NULL,   -- Departamento de la empresa
    puesto        VARCHAR(50)    NOT NULL,   -- Cargo o puesto de trabajo
    salario_base  DECIMAL(10,2)  NOT NULL,   -- Salario base mensual (euros)
    complementos  DECIMAL(10,2)  NOT NULL,   -- Complementos salariales (euros)
    fecha_alta    DATE           NOT NULL,   -- Fecha de incorporación
    activo        TINYINT(1)     NOT NULL,   -- 1 = activo | 0 = baja
    PRIMARY KEY (empleado_id)               -- Clave primaria: no permite duplicados
);


-- =============================================================================
-- REFERENCIA: formato del INSERT que generarInsertPorEmpleado() debe producir
--
-- La aplicación Java NO inserta datos desde este script. Los datos vienen del
-- fichero nominas.csv. El método generarInsertPorEmpleado() debe producir
-- sentencias con exactamente este formato (usando String.format()):
--
-- INSERT INTO nominas
--   (nombre, apellidos, departamento, puesto, salario_base, complementos,
--    fecha_alta, activo)
-- VALUES
--   ('Ana', 'Garcia Lopez', 'Desarrollo', 'Programadora', 2800.00, 350.00,
--    '2021-03-15', 1);
--
-- Observaciones:
--   · empleado_id NO aparece en la lista de columnas del INSERT porque en
--     el CSV ya viene asignado y Java puede omitirlo del INSERT si la tabla
--     no lo declara como AUTO_INCREMENT (aquí lo gestiona el propio CSV).
--     Alternativamente puedes incluirlo añadiendo el campo al INSERT:
--       INSERT INTO nominas (empleado_id, nombre, …) VALUES (1, 'Ana', …)
--   · Los valores String van entre comillas simples en SQL.
--   · Los decimales usan punto (.) como separador, nunca coma (,).
--   · El boolean activo se escribe como 1 ó 0, sin comillas.
-- =============================================================================