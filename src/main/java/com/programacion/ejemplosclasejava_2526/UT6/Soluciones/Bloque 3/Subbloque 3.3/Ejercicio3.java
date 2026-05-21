import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Subbloque 3.3 - Ejercicio 3
 * Inserción masiva de alumnos desde arrays (BD: instituto)
 */
public class Ejercicio3 {

    private static final String URL      = "jdbc:mysql://localhost:3306/instituto";
    private static final String USER     = "root";
    private static final String PASSWORD = "RootPass123!";

    private static final String[] NOMBRES = {"Ana Garcia", "Luis Perez", "Marta Sanz", "David Ruiz"};
    private static final String[] CURSOS  = {"DAM1", "DAM2", "DAW1", "DAW1"};

    public static void insertarAlumno(String nombre, String curso) {
        String sql = String.format(
            "INSERT INTO alumno (nombre, curso) VALUES ('%s', '%s')", nombre, curso);
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            System.out.println("Alumno insertado: " + nombre + " (" + curso + ")");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < NOMBRES.length; i++) {
            insertarAlumno(NOMBRES[i], CURSOS[i]);
        }
        System.out.println("Inserción masiva completada.");
    }
}
