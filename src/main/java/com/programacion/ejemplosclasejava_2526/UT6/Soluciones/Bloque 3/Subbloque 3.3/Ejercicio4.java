import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Subbloque 3.3 - Ejercicio 4
 * Alta de nuevas reservas en hotel (BD: hotel)
 * Adaptar los campos del INSERT a la estructura de la tabla del enunciado.
 */
public class Ejercicio4 {

    private static final String URL      = "jdbc:mysql://localhost:3306/hotel";
    private static final String USER     = "root";
    private static final String PASSWORD = "RootPass123!";

    public static void insertar(String sql) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement st = conn.createStatement();
            int filas = st.executeUpdate(sql);
            if (filas == 1) System.out.println("Registro insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String respuesta;
        do {
            System.out.print("\n¿Desea añadir un registro? (s/n): ");
            respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                // Recoger campos por teclado y construir sql con String.format()
                // Ejemplo:
                // System.out.print("Campo1: "); String c1 = teclado.nextLine();
                // String sql = String.format("INSERT INTO reserva (...) VALUES ('%s',...)", c1, ...);
                // insertar(sql);
                System.out.println("(Completa la recogida de datos del enunciado)");
            }
        } while (respuesta.equalsIgnoreCase("s"));
        teclado.close();
    }
}
