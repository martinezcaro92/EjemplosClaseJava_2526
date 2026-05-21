import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Subbloque 3.2 - Ejercicio 3
 * Informe de reservas de hotel (BD: hotel)
 * Copia aquí la sentencia SQL del enunciado y adapta los campos del ResultSet.
 */
public class Ejercicio3 {

    private static final String URL      = "jdbc:mysql://localhost:3306/hotel";
    private static final String USER     = "root";
    private static final String PASSWORD = "RootPass123!";

    public static void ejecutarConsulta() {
        // Pega aquí la sentencia SQL del enunciado
        String sql = "SELECT * FROM ..."; // <-- reemplazar

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Adaptar la cabecera y el printf a las columnas del SELECT
            System.out.println("=".repeat(70));
            System.out.printf("%-5s %-20s%n", "COL1", "COL2"); // adaptar columnas
            System.out.println("=".repeat(70));

            int total = 0;
            while (rs.next()) {
                // rs.getInt("columna"), rs.getString("columna"), rs.getDouble("columna")
                System.out.printf("%-5d %-20s%n",
                        rs.getInt(1), rs.getString(2)); // adaptar
                total++;
            }
            System.out.println("=".repeat(70));
            System.out.println("Total de registros: " + total);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ejecutarConsulta();
    }
}
