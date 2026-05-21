import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Subbloque 3.4 - Ejercicio 3
 * Base de datos de restaurante (BD: restaurante)
 * Replica el script SQL del enunciado desde Java usando métodos independientes,
 * cada uno con su propia gestión de conexión mediante try-with-resources.
 */
public class Ejercicio3 {

    private static final String URL_SERVIDOR = "jdbc:mysql://localhost:3306/";
    private static final String NOMBRE_BD    = "restaurante";
    private static final String URL_BD       = URL_SERVIDOR + NOMBRE_BD;
    private static final String USER         = "root";
    private static final String PASSWORD     = "RootPass123!";

    public static void eliminarBaseDeDatos(String nombreBD) {
        try (Connection conn = DriverManager.getConnection(URL_SERVIDOR, USER, PASSWORD)) {
            conn.createStatement().executeUpdate("DROP DATABASE IF EXISTS " + nombreBD);
            System.out.println("BD '" + nombreBD + "' eliminada.");
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    public static void crearBaseDeDatos(String nombreBD) {
        try (Connection conn = DriverManager.getConnection(URL_SERVIDOR, USER, PASSWORD)) {
            conn.createStatement().executeUpdate(
                "CREATE DATABASE " + nombreBD + " CHARACTER SET utf8mb4");
            System.out.println("BD '" + nombreBD + "' creada.");
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    public static void crearTablas(String sql, String nombreTabla) {
        try (Connection conn = DriverManager.getConnection(URL_BD, USER, PASSWORD)) {
            conn.createStatement().executeUpdate(sql);
            System.out.println("Tabla '" + nombreTabla + "' creada.");
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    public static void insertar(String sql, String descripcion) {
        try (Connection conn = DriverManager.getConnection(URL_BD, USER, PASSWORD)) {
            conn.createStatement().executeUpdate(sql);
            System.out.println("Insertado: " + descripcion);
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    public static void main(String[] args) {
        eliminarBaseDeDatos(NOMBRE_BD);
        crearBaseDeDatos(NOMBRE_BD);

        // Añadir aquí las llamadas a crearTablas() e insertar()
        // con las sentencias SQL del enunciado correspondiente.
        // Ejemplo:
        // crearTablas("CREATE TABLE nombre (...)", "nombre");
        // insertar("INSERT INTO nombre (...) VALUES (...)", "descripcion");

        System.out.println("Base de datos 'restaurante' generada correctamente.");
    }
}
