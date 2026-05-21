import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Subbloque 4.2 - Ejercicio 3
 * Exportación de reservas de hotel a CSV (BD: hotel)
 * Adaptar la sentencia SQL del enunciado y los campos del ResultSet.
 */
public class Ejercicio3 {

    private static final String URL      = "jdbc:mysql://localhost:3306/hotel";
    private static final String USER     = "root";
    private static final String PASSWORD = "RootPass123!";

    public static void exportar(String fullName) {
        // Pega la sentencia SQL del enunciado
        String sql = "SELECT ..."; // <-- reemplazar

        PrintWriter pw = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            pw = new PrintWriter(new FileWriter(fullName, false));
            pw.println("col1,col2,..."); // cabecera — adaptar
            int total = 0;
            while (rs.next()) {
                pw.printf("%s,%s%n", rs.getString(1), rs.getString(2)); // adaptar
                total++;
            }
            System.out.println("Exportados " + total + " registros a " + fullName);
        } catch (SQLException e) {
            System.out.println("Error BD: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error fichero: " + e.getMessage());
        } finally {
            if (pw != null) pw.close();
        }
    }

    public static void main(String[] args) {
        exportar("src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 4\\Subbloque 4.2\\reservas_exportadas.csv");
    }
}
