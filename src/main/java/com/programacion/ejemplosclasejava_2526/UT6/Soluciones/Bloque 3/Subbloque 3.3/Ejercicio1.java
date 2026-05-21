import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Subbloque 3.3 - Ejercicio 1
 * Alta de nuevos productos en tienda_online (String.format)
 */
public class Ejercicio1 {

    private static final String URL      = "jdbc:mysql://localhost:3306/tienda_online";
    private static final String USER     = "root";
    private static final String PASSWORD = "RootPass123!";

    public static void insertarProducto(String nombre, double precio, int stock) {
        String sql = String.format(
            "INSERT INTO producto (nombre, precio, stock) VALUES ('%s', %.2f, %d)",
            nombre, precio, stock);
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement st = conn.createStatement();
            int filas = st.executeUpdate(sql);
            if (filas == 1) System.out.println("Producto '" + nombre + "' insertado.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String respuesta;
        do {
            System.out.print("\n¿Desea añadir un producto? (s/n): ");
            respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                System.out.print("Nombre: ");  String nombre = teclado.nextLine();
                System.out.print("Precio: ");  double precio = Double.parseDouble(teclado.nextLine().trim());
                System.out.print("Stock: ");   int stock     = Integer.parseInt(teclado.nextLine().trim());
                insertarProducto(nombre, precio, stock);
            }
        } while (respuesta.equalsIgnoreCase("s"));
        teclado.close();
    }
}
