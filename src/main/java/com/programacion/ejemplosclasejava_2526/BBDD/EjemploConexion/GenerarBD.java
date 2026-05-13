package com.programacion.ejemplosclasejava_2526.BBDD.EjemploConexion;
import java.sql.*;

/**
 * Gestiona la creación/recreación del esquema de base de datos.
 *
 * ─── FLUJO DE EJECUCIÓN ─────────────────────────────────────────────────────
 *   1. Conectarse al SERVIDOR MySQL (sin indicar BD) con conectarServidor().
 *   2. Crear la BD si no existe          con crearBaseDeDatos(conn, nombreBD).
 *   3. Reconectarse apuntando a la BD    con conectarBaseDeDatos(nombreBD).
 *   4. Eliminar las tablas previas       con eliminarTabla(conn, nombreTabla).
 *   5. Crear las tablas nuevas           con crearTablaEmpleado/Persona(conn).
 *
 * ─── DISEÑO DE MÉTODOS ──────────────────────────────────────────────────────
 * Los métodos reciben el nombre de la BD o de la tabla como argumento para
 * poder reutilizarse con distintas bases de datos sin modificar el código.
 */
public class GenerarBD {

    // ─── Credenciales del servidor ────────────────────────────────────────────

    /**
     * URL base del servidor MySQL sin nombre de BD.
     * Al omitir el nombre de la BD el driver conecta al motor directamente,
     * evitando el error "Unknown database" cuando ésta todavía no existe.
     */
    private static final String URL_SERVIDOR = "jdbc:mysql://localhost:3306/";

    /** Usuario con permisos de DDL (CREATE DATABASE, CREATE TABLE, DROP TABLE). */
    private static final String USERNAME = "root";

    /** Contraseña del usuario anterior. */
    private static final String PASSWORD = "RootPass123!";


    // ─── Punto de entrada ─────────────────────────────────────────────────────

    /**
     * Demuestra el flujo completo sobre la base de datos "personas":
     * crea la BD (si no existe), elimina las tablas anteriores y las recrea.
     *
     * El nombre de la BD se almacena en una variable local y se pasa como
     * argumento a cada método: así los métodos son reutilizables con
     * cualquier base de datos sin cambiar su código.
     */
    public static void main(String[] args) {

        // Variable local con el nombre de la BD: se pasa como argumento
        // a los métodos en lugar de usar una constante interna.
        String nombreBD = "personas";

        // FASE 1 — Conectar al servidor (sin BD) y crear la BD si no existe.
        // try-with-resources cierra la conexión al salir del bloque sea cual sea
        // el resultado (éxito o excepción).
        try (Connection connServidor = conectarServidor()) {

            crearBaseDeDatos(connServidor, nombreBD);

        } catch (SQLException ex) {
            System.out.println("Error conectando al servidor: " + ex.getMessage());
            return;   // Sin BD no podemos continuar
        }

        // FASE 2 — Reconectarse con la BD ya garantizada y gestionar las tablas.
        try (Connection connBD = conectarBaseDeDatos(nombreBD)) {

            // Eliminamos primero las tablas existentes (si las hubiese)
            eliminarTabla(connBD, "Empleado");
            eliminarTabla(connBD, "Persona");

            // Las creamos de nuevo con la estructura deseada
            crearTablaEmpleado(connBD);
            crearTablaPersona(connBD);

        } catch (SQLException ex) {
            System.out.println("Error gestionando las tablas: " + ex.getMessage());
        }
    }


    // ─── Métodos de conexión ──────────────────────────────────────────────────

    /**
     * Abre una conexión al servidor MySQL SIN seleccionar ninguna base de datos.
     *
     * La URL termina en "/" sin nombre de BD: el driver se conecta al motor
     * aunque la BD todavía no exista, solucionando el error "Unknown database".
     *
     * @return Connection activa apuntando al servidor (sin BD seleccionada).
     * @throws SQLException si el servidor no está disponible o las credenciales
     *                      son incorrectas.
     */
    public static Connection conectarServidor() throws SQLException {
        Connection conn = DriverManager.getConnection(URL_SERVIDOR, USERNAME, PASSWORD);
        System.out.println("Conexión al servidor MySQL establecida.");
        return conn;
    }

    /**
     * Abre una conexión a la base de datos cuyo nombre se indica.
     *
     * Debe llamarse después de {@link #crearBaseDeDatos(Connection, String)}
     * para asegurarse de que la BD ya existe en el servidor.
     *
     * @param nombreBD Nombre de la base de datos a la que conectarse.
     * @return Connection activa con la base de datos seleccionada.
     * @throws SQLException si la BD no existe o las credenciales son incorrectas.
     */
    public static Connection conectarBaseDeDatos(String nombreBD) throws SQLException {
        // Concatenamos el nombre de la BD al final de la URL del servidor
        String urlConBD = URL_SERVIDOR + nombreBD;
        Connection conn = DriverManager.getConnection(urlConBD, USERNAME, PASSWORD);
        System.out.println("Conexión a la base de datos '" + nombreBD + "' establecida.");
        return conn;
    }


    // ─── Métodos DDL sobre la base de datos ──────────────────────────────────

    /**
     * Crea la base de datos indicada si todavía no existe en el servidor.
     *
     * IF NOT EXISTS hace la operación idempotente: ejecutarla varias veces
     * no produce ningún error aunque la BD ya existiera de antes.
     *
     * @param conn     Conexión AL SERVIDOR obtenida con {@link #conectarServidor()}.
     * @param nombreBD Nombre de la base de datos que se desea crear.
     * @throws SQLException si la sentencia DDL no puede ejecutarse.
     */
    public static void crearBaseDeDatos(Connection conn, String nombreBD) throws SQLException {
        String sql = "CREATE DATABASE IF NOT EXISTS " + nombreBD;
        // Statement en try-with-resources: se cierra automáticamente al terminar
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Base de datos '" + nombreBD + "' verificada/creada.");
        }
    }


    // ─── Métodos DDL sobre tablas ─────────────────────────────────────────────

    /**
     * Elimina la tabla indicada si existe en la base de datos activa.
     *
     * Al recibir el nombre como parámetro este método es genérico y puede
     * usarse para borrar cualquier tabla sin duplicar código.
     * DROP TABLE IF EXISTS garantiza que no se lance un error si la tabla
     * no existía todavía.
     *
     * @param conn        Conexión A LA BASE DE DATOS activa.
     * @param nombreTabla Nombre de la tabla que se desea eliminar.
     * @throws SQLException si la sentencia DDL no puede ejecutarse.
     */
    public static void eliminarTabla(Connection conn, String nombreTabla) throws SQLException {
        String sql = "DROP TABLE IF EXISTS " + nombreTabla;
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Tabla '" + nombreTabla + "' eliminada (si existía).");
        }
    }

    /**
     * Crea la tabla Empleado en la base de datos activa.
     *
     * Columnas:
     * <ul>
     *   <li><b>id</b>           – INT AUTO_INCREMENT: PK generada por MySQL.</li>
     *   <li><b>nombre</b>       – VARCHAR(100) NOT NULL: campo obligatorio.</li>
     *   <li><b>apellidos</b>    – VARCHAR(200) opcional.</li>
     *   <li><b>departamento</b> – VARCHAR(100) opcional.</li>
     *   <li><b>salario</b>      – DECIMAL(10,2): 10 dígitos totales, 2 decimales.</li>
     *   <li><b>fecha_alta</b>   – DATE: formato YYYY-MM-DD en SQL.</li>
     * </ul>
     *
     * @param conn Conexión A LA BASE DE DATOS activa.
     * @throws SQLException si la sentencia DDL no puede ejecutarse.
     */
    public static void crearTablaEmpleado(Connection conn) throws SQLException {
        // executeUpdate() se usa para DDL (CREATE, DROP, ALTER) y para DML sin
        // resultado (INSERT, UPDATE, DELETE). No devuelve filas.
        String sql =
            "CREATE TABLE Empleado ("                            +
            "  id           INT(11)       NOT NULL AUTO_INCREMENT," +
            "  nombre       VARCHAR(100)  NOT NULL,"               +
            "  apellidos    VARCHAR(200)  DEFAULT NULL,"           +
            "  departamento VARCHAR(100)  DEFAULT NULL,"           +
            "  salario      DECIMAL(10,2) DEFAULT NULL,"           +
            "  fecha_alta   DATE          DEFAULT NULL,"           +
            "  PRIMARY KEY (id)"                                   +
            ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Tabla 'Empleado' creada correctamente.");
        }
    }

    /**
     * Crea la tabla Persona en la base de datos activa.
     *
     * Columnas:
     * <ul>
     *   <li><b>id</b>        – INT AUTO_INCREMENT: PK generada por MySQL.</li>
     *   <li><b>nombre</b>    – VARCHAR(255) NOT NULL: campo obligatorio.</li>
     *   <li><b>apellidos</b> – VARCHAR(255) opcional.</li>
     *   <li><b>edad</b>      – INT opcional.</li>
     * </ul>
     *
     * @param conn Conexión A LA BASE DE DATOS activa.
     * @throws SQLException si la sentencia DDL no puede ejecutarse.
     */
    public static void crearTablaPersona(Connection conn) throws SQLException {
        String sql =
            "CREATE TABLE Persona ("                             +
            "  id        INT(11)      NOT NULL AUTO_INCREMENT,"  +
            "  nombre    VARCHAR(255) NOT NULL,"                 +
            "  apellidos VARCHAR(255) DEFAULT NULL,"             +
            "  edad      INT(11)      DEFAULT NULL,"             +
            "  PRIMARY KEY (id)"                                 +
            ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Tabla 'Persona' creada correctamente.");
        }
    }
}
