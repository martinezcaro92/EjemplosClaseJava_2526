
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Subbloque 4.1 - Ejercicio 4
 * Carga de empleados desde JSON a personas
 * BD: personas, tabla destino: Empleado
 * Adaptar los campos leídos del JSON a las columnas de la tabla.
 */
public class Ejercicio4 {

    private static final String URL      = "jdbc:mysql://localhost:3306/personas";
    private static final String USER     = "root";
    private static final String PASSWORD = "RootPass123!";

    public static void cargarDesdeJSON(String fullName) {
        try {
            String contenido = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(fullName)));
            org.json.JSONArray arr = new org.json.JSONArray(contenido);
            int insertados = 0;
            for (int i = 0; i < arr.length(); i++) {
                org.json.JSONObject obj = arr.getJSONObject(i);
                // Adaptar claves y campos a la estructura JSON del enunciado
                String campo1 = obj.optString("campo1");
                String sql = String.format(
                    "INSERT INTO Empleado (...) VALUES ('%s')", campo1);
                try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    conn.createStatement().executeUpdate(sql);
                    System.out.println("Registro insertado en Empleado.");
                    insertados++;
                } catch (SQLException e) {
                    System.out.println("Error en INSERT: " + e.getMessage());
                }
            }
            System.out.println("Total insertados: " + insertados);

        } catch (Exception e) {
            System.out.println("Error genérico: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        cargarDesdeJSON("src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 4\\Subbloque 4.1\\empleados.json");
    }
}
