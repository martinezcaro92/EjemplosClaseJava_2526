import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Subbloque 3.1 - Ejercicio 1
 * Configuración de una BD para una clínica veterinaria
 * Crea la BD clinica_veterinaria con las tablas propietario y animal.
 */
public class Ejercicio1 {

    private static final String URL_SERVIDOR = "jdbc:mysql://localhost:3306/";
    private static final String URL_BD       = URL_SERVIDOR + "clinica_veterinaria";
    private static final String USER         = "root";
    private static final String PASSWORD     = "RootPass123!";

    public static Connection conectarServidor() throws SQLException {
        Connection conn = DriverManager.getConnection(URL_SERVIDOR, USER, PASSWORD);
        System.out.println("Conexión al servidor establecida.");
        return conn;
    }

    public static Connection conectarBaseDeDatos(String nombreBD) throws SQLException {
        Connection conn = DriverManager.getConnection(URL_SERVIDOR + nombreBD, USER, PASSWORD);
        System.out.println("Conexión a '" + nombreBD + "' establecida.");
        return conn;
    }

    public static void crearBaseDeDatos(Connection conn, String nombreBD) throws SQLException {
        String sql = "CREATE DATABASE IF NOT EXISTS " + nombreBD + " CHARACTER SET utf8mb4";
        try (Statement st = conn.createStatement()) {
            st.executeUpdate(sql);
            System.out.println("BD '" + nombreBD + "' creada/verificada.");
        }
    }

    public static void eliminarTabla(Connection conn, String tabla) throws SQLException {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("DROP TABLE IF EXISTS " + tabla);
            System.out.println("Tabla '" + tabla + "' eliminada (si existía).");
        }
    }

    public static void crearTabla(Connection conn, String nombreTabla, String sql) throws SQLException {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate(sql);
            System.out.println("Tabla '" + nombreTabla + "' creada.");
        }
    }

    public static void main(String[] args) {
        String nombreBD = "clinica_veterinaria";

        try (Connection connServidor = conectarServidor()) {
            crearBaseDeDatos(connServidor, nombreBD);
        } catch (SQLException e) {
            System.out.println("Error conectando al servidor: " + e.getMessage());
            return;
        }

        String sqlPropietario =
            "CREATE TABLE propietario (" +
            "  id       INT UNSIGNED NOT NULL AUTO_INCREMENT," +
            "  nombre   VARCHAR(100) NOT NULL," +
            "  telefono VARCHAR(15)," +
            "  PRIMARY KEY (id)" +
            ")";

        String sqlAnimal =
            "CREATE TABLE animal (" +
            "  id              INT UNSIGNED NOT NULL AUTO_INCREMENT," +
            "  nombre          VARCHAR(50)," +
            "  especie         VARCHAR(50)," +
            "  id_propietario  INT UNSIGNED DEFAULT NULL," +
            "  PRIMARY KEY (id)," +
            "  FOREIGN KEY (id_propietario) REFERENCES propietario(id)" +
            ")";

        try (Connection connBD = conectarBaseDeDatos(nombreBD)) {
            eliminarTabla(connBD, "animal");
            eliminarTabla(connBD, "propietario");
            crearTabla(connBD, "propietario", sqlPropietario);
            crearTabla(connBD, "animal", sqlAnimal);
        } catch (SQLException e) {
            System.out.println("Error gestionando tablas: " + e.getMessage());
        }
    }
}
