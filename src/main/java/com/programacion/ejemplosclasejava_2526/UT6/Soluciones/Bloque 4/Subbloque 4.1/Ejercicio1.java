import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Subbloque 4.1 - Ejercicio 1
 * Carga de productos desde CSV a tienda_online.
 * Campos CSV: nombre, precio, stock
 */
public class Ejercicio1 {

    private static final String URL      = "jdbc:mysql://localhost:3306/tienda_online";
    private static final String USER     = "root";
    private static final String PASSWORD = "RootPass123!";

    public static void cargarProductosDesdeCSV(String fullName) {
        try {
            Scanner scan = new Scanner(new FileReader(fullName));
            String cabecera = scan.nextLine(); // descartar cabecera
            String[] campos = cabecera.split(",");

            int insertados = 0;
            while (scan.hasNextLine()) {
                String linea = scan.nextLine();
                if (linea.isBlank()) continue;
                String[] datos = linea.split(",");

                String nombre = datos[0].trim();
                double precio = Double.parseDouble(datos[1].trim());
                int stock     = Integer.parseInt(datos[2].trim());

                String sql = String.format(
                    "INSERT INTO producto (nombre, precio, stock) VALUES ('%s', %.2f, %d)",
                    nombre, precio, stock);

                try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    conn.createStatement().executeUpdate(sql);
                    System.out.println("Producto insertado: " + nombre);
                    insertados++;
                } catch (SQLException e) {
                    System.out.println("Error en INSERT: " + e.getMessage());
                }
            }
            System.out.println("Total de productos cargados: " + insertados);

        } catch (FileNotFoundException e) {
            System.out.println("Error: fichero no encontrado. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error genérico: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        cargarProductosDesdeCSV("src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 4\\Subbloque 4.1\\productos.csv");
    }
}
