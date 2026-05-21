import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Subbloque 3.2 - Ejercicio 1
 * Consulta de productos de una tienda (BD: tienda_online)
 */
public class Ejercicio1 {

    private static final String URL      = "jdbc:mysql://localhost:3306/tienda_online";
    private static final String USER     = "root";
    private static final String PASSWORD = "RootPass123!";

    public static void mostrarProductos() {
        String sql = "SELECT id, nombre, precio, stock FROM producto ORDER BY nombre";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("=".repeat(60));
            System.out.printf("%-5s %-25s %-10s %-8s%n", "ID", "NOMBRE", "PRECIO", "STOCK");
            System.out.println("=".repeat(60));
            int total = 0;
            while (rs.next()) {
                System.out.printf("%-5d %-25s %-10.2f %-8d%n",
                        rs.getInt("id"), rs.getString("nombre"),
                        rs.getDouble("precio"), rs.getInt("stock"));
                total++;
            }
            System.out.println("=".repeat(60));
            System.out.println("Total de productos: " + total);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        mostrarProductos();
    }
}
