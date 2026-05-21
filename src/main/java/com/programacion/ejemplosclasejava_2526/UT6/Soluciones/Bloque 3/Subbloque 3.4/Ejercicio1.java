import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Subbloque 3.4 - Ejercicio 1
 * Sistema de gestión de una liga de fútbol
 * Replica el script SQL completo desde Java usando métodos independientes.
 */
public class Ejercicio1 {

    private static final String URL_SERVIDOR = "jdbc:mysql://localhost:3306/";
    private static final String NOMBRE_BD    = "liga_futbol";
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

    public static void insertarEquipo(String nombre, String ciudad) {
        String sql = String.format(
            "INSERT INTO equipo (nombre, ciudad) VALUES ('%s', '%s')", nombre, ciudad);
        try (Connection conn = DriverManager.getConnection(URL_BD, USER, PASSWORD)) {
            conn.createStatement().executeUpdate(sql);
            System.out.println("Equipo '" + nombre + "' insertado.");
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    public static void insertarJugador(String nombre, String posicion, int idEquipo) {
        String sql = String.format(
            "INSERT INTO jugador (nombre, posicion, id_equipo) VALUES ('%s', '%s', %d)",
            nombre, posicion, idEquipo);
        try (Connection conn = DriverManager.getConnection(URL_BD, USER, PASSWORD)) {
            conn.createStatement().executeUpdate(sql);
            System.out.println("Jugador '" + nombre + "' insertado.");
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    public static void main(String[] args) {
        eliminarBaseDeDatos(NOMBRE_BD);
        crearBaseDeDatos(NOMBRE_BD);

        crearTablas(
            "CREATE TABLE equipo (" +
            "  id     INT UNSIGNED NOT NULL AUTO_INCREMENT," +
            "  nombre VARCHAR(80)," +
            "  ciudad VARCHAR(60)," +
            "  PRIMARY KEY (id))", "equipo");

        crearTablas(
            "CREATE TABLE jugador (" +
            "  id        INT UNSIGNED NOT NULL AUTO_INCREMENT," +
            "  nombre    VARCHAR(100)," +
            "  posicion  VARCHAR(30)," +
            "  id_equipo INT UNSIGNED DEFAULT NULL," +
            "  PRIMARY KEY (id)," +
            "  FOREIGN KEY (id_equipo) REFERENCES equipo(id))", "jugador");

        insertarEquipo("Atletico", "Madrid");
        insertarEquipo("Villarreal", "Villarreal");
        insertarJugador("Morata",     "Delantero",     1);
        insertarJugador("Griezmann",  "Mediocampista", 1);

        System.out.println("Base de datos 'liga_futbol' generada correctamente.");
    }
}
