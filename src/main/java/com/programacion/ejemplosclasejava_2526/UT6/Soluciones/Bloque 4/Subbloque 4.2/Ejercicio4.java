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
 * Subbloque 4.2 - Ejercicio 4
 * Exportación de alumnos a JSON (BD: instituto)
 * Adaptar la sentencia SQL del enunciado y los campos del ResultSet.
 */
public class Ejercicio4 {

    private static final String URL      = "jdbc:mysql://localhost:3306/instituto";
    private static final String USER     = "root";
    private static final String PASSWORD = "RootPass123!";

    public static void exportar(String fullName) {
        // Pega la sentencia SQL del enunciado
        String sql = "SELECT ..."; // <-- reemplazar

        PrintWriter pw = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            JSONArray array = new JSONArray();
            while (rs.next()) {
                JSONObject obj = new JSONObject();
                obj.put("col1", rs.getString(1)); // adaptar
                array.put(obj);
            }
            pw = new PrintWriter(new FileWriter(fullName));
            pw.println(array.toString(2));
            System.out.println("Exportados " + array.length() + " registros a " + fullName);
        } catch (SQLException e) {
            System.out.println("Error BD: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error fichero: " + e.getMessage());
        } finally {
            if (pw != null) pw.close();
        }
    }

    public static void main(String[] args) {
        exportar("src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 4\\Subbloque 4.2\\alumnos_exportados.json");
    }
}
