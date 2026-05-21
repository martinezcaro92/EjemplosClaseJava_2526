import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Subbloque 3.1 - Ejercicio 5
 * Preparación del esquema de biblioteca digital (BD: biblioteca_digital)
 * Consulta el enunciado para la estructura exacta de tablas a crear.
 */
public class Ejercicio5 {

    private static final String URL_SERVIDOR = "jdbc:mysql://localhost:3306/";
    private static final String USER         = "root";
    private static final String PASSWORD     = "RootPass123!";

    public static Connection conectarServidor() throws SQLException {
        return DriverManager.getConnection(URL_SERVIDOR, USER, PASSWORD);
    }

    public static Connection conectarBaseDeDatos(String nombreBD) throws SQLException {
        return DriverManager.getConnection(URL_SERVIDOR + nombreBD, USER, PASSWORD);
    }

    public static void crearBaseDeDatos(Connection conn, String nombreBD) throws SQLException {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS " + nombreBD + " CHARACTER SET utf8mb4");
            System.out.println("BD '" + nombreBD + "' creada/verificada.");
        }
    }

    public static void eliminarTabla(Connection conn, String tabla) throws SQLException {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("DROP TABLE IF EXISTS " + tabla);
            System.out.println("Tabla '" + tabla + "' eliminada (si existía).");
        }
    }

    public static void crearTabla(Connection conn, String nombre, String sql) throws SQLException {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate(sql);
            System.out.println("Tabla '" + nombre + "' creada.");
        }
    }

    public static void main(String[] args) {
        String nombreBD = "biblioteca_digital";

        // FASE 1: conectar al servidor y crear BD
        try (Connection connServidor = conectarServidor()) {
            crearBaseDeDatos(connServidor, nombreBD);
        } catch (SQLException e) {
            System.out.println("Error en servidor: " + e.getMessage());
            return;
        }

        // FASE 2: conectar a la BD, eliminar tablas previas y crearlas
        // Completar los String SQL con las sentencias CREATE TABLE del enunciado
        try (Connection connBD = conectarBaseDeDatos(nombreBD)) {
            // eliminarTabla(connBD, "tabla_hija"); // Primero las que tienen FK
            // eliminarTabla(connBD, "tabla_padre");
            // crearTabla(connBD, "tabla_padre", "CREATE TABLE tabla_padre (...)");
            // crearTabla(connBD, "tabla_hija",  "CREATE TABLE tabla_hija  (...)");
            System.out.println("Esquema de 'biblioteca_digital' generado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error gestionando tablas: " + e.getMessage());
        }
    }
}
