import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Subbloque 3.5 - Ejercicio 2
 * Informe de alumnos del instituto exportado a JSON.
 */
public class Ejercicio2 {

    private static final String URL      = "jdbc:mysql://localhost:3306/instituto";
    private static final String USER     = "root";
    private static final String PASSWORD = "RootPass123!";

    public static void exportarAlumnosAJSON(String fullName) {
        String sql = "SELECT id, nombre, curso FROM alumno ORDER BY curso, nombre";
        PrintWriter pw = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            JSONArray array = new JSONArray();
            while (rs.next()) {
                JSONObject obj = new JSONObject();
                obj.put("id",     rs.getInt("id"));
                obj.put("nombre", rs.getString("nombre"));
                obj.put("curso",  rs.getString("curso"));
                array.put(obj);
            }

            pw = new PrintWriter(new FileWriter(fullName));
            pw.println(array.toString(2));
            System.out.println("Exportados " + array.length() + " alumnos a: " + fullName);
        } catch (SQLException e) {
            System.out.println("Error BD: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error fichero: " + e.getMessage());
        } finally {
            if (pw != null) pw.close();
        }
    }

    public static void main(String[] args) {
        exportarAlumnosAJSON("src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 3\\Subbloque 3.5\\alumnos_exportados.json");
    }
}
