import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Subbloque 4.1 - Ejercicio 2
 * Importación de alumnos desde JSON a la BD instituto.
 * Campos JSON: nombre, curso
 */
public class Ejercicio2 {

    private static final String URL      = "jdbc:mysql://localhost:3306/instituto";
    private static final String USER     = "root";
    private static final String PASSWORD = "RootPass123!";

    public static void cargarAlumnosDesdeJSON(String fullName) {
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(fullName)));
            JSONArray alumnos = new JSONArray(contenido);

            int insertados = 0;
            for (int i = 0; i < alumnos.length(); i++) {
                JSONObject alumno = alumnos.getJSONObject(i);
                String nombre = alumno.optString("nombre");
                String curso  = alumno.optString("curso");

                String sql = String.format(
                    "INSERT INTO alumno (nombre, curso) VALUES ('%s', '%s')", nombre, curso);

                try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    conn.createStatement().executeUpdate(sql);
                    System.out.println("Alumno insertado: " + nombre);
                    insertados++;
                } catch (SQLException e) {
                    System.out.println("Error en INSERT: " + e.getMessage());
                }
            }
            System.out.println("Total de alumnos cargados: " + insertados);

        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error genérico: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        cargarAlumnosDesdeJSON("src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 4\\Subbloque 4.1\\alumnos.json");
    }
}
