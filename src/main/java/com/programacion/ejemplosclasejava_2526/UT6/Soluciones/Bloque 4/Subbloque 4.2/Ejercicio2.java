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
 * Subbloque 4.2 - Ejercicio 2
 * Exportación de empleados de personas a JSON.
 */
public class Ejercicio2 {

    private static final String URL      = "jdbc:mysql://localhost:3306/personas";
    private static final String USER     = "root";
    private static final String PASSWORD = "RootPass123!";

    public static void exportarAJSON(String fullName) {
        String sql = "SELECT id, nombre, apellidos, departamento, salario FROM Empleado";
        PrintWriter pw = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            JSONArray array = new JSONArray();
            while (rs.next()) {
                JSONObject obj = new JSONObject();
                obj.put("id",           rs.getInt("id"));
                obj.put("nombre",       rs.getString("nombre"));
                obj.put("apellidos",    rs.getString("apellidos"));
                obj.put("departamento", rs.getString("departamento"));
                obj.put("salario",      rs.getDouble("salario"));
                array.put(obj);
            }
            pw = new PrintWriter(new FileWriter(fullName));
            pw.println(array.toString(2));
            System.out.println("Exportados " + array.length() + " empleados a " + fullName);
        } catch (SQLException e) {
            System.out.println("Error BD: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error fichero: " + e.getMessage());
        } finally {
            if (pw != null) pw.close();
        }
    }

    public static void main(String[] args) {
        exportarAJSON("src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 4\\Subbloque 4.2\\empleados_exportados.json");
    }
}
