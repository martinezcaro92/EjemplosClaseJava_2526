import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Subbloque 3.5 - Ejercicio 1
 * Exportación del catálogo de productos de tienda_online a CSV.
 */
public class Ejercicio1 {

    private static final String URL      = "jdbc:mysql://localhost:3306/tienda_online";
    private static final String USER     = "root";
    private static final String PASSWORD = "RootPass123!";

    public static void exportarProductosACSV(String fullName) {
        String sql = "SELECT id, nombre, precio, stock FROM producto ORDER BY nombre";
        PrintWriter pw = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            pw = new PrintWriter(new FileWriter(fullName, false));
            pw.println("id,nombre,precio,stock"); // cabecera

            int total = 0;
            while (rs.next()) {
                pw.printf("%d,%s,%.2f,%d%n",
                        rs.getInt("id"), rs.getString("nombre"),
                        rs.getDouble("precio"), rs.getInt("stock"));
                total++;
            }
            System.out.println("Exportados " + total + " productos a: " + fullName);
        } catch (SQLException e) {
            System.out.println("Error BD: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error fichero: " + e.getMessage());
        } finally {
            if (pw != null) pw.close();
        }
    }

    public static void main(String[] args) {
        exportarProductosACSV("src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 3\\Subbloque 3.5\\productos_exportados.csv");
    }
}
