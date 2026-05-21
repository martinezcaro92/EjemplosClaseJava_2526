import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Subbloque 3.3 - Ejercicio 2
 * Registro de nuevos clientes en tienda_online (concatenación +)
 */
public class Ejercicio2 {

    private static final String URL      = "jdbc:mysql://localhost:3306/tienda_online";
    private static final String USER     = "root";
    private static final String PASSWORD = "RootPass123!";

    public static void insertarCliente(String nombre, String email) {
        String sql = "INSERT INTO cliente (nombre, email) VALUES ('" + nombre + "','" + email + "')";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            System.out.println("Cliente '" + nombre + "' registrado.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String respuesta;
        do {
            System.out.print("\n¿Desea añadir un cliente? (s/n): ");
            respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                System.out.print("Nombre: "); String nombre = teclado.nextLine();
                System.out.print("Email: ");  String email  = teclado.nextLine();
                insertarCliente(nombre, email);
            }
        } while (respuesta.equalsIgnoreCase("s"));
        teclado.close();
    }
}
