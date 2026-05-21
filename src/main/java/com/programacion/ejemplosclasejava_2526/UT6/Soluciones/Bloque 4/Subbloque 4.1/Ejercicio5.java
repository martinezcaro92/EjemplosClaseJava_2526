import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Subbloque 4.1 - Ejercicio 5
 * Carga de reservas desde CSV a restaurante
 * BD: restaurante, tabla destino: reserva_rest
 * Adaptar los campos leídos del CSV a las columnas de la tabla.
 */
public class Ejercicio5 {

    private static final String URL      = "jdbc:mysql://localhost:3306/restaurante";
    private static final String USER     = "root";
    private static final String PASSWORD = "RootPass123!";

    public static void cargarDesdeCSV(String fullName) {
        try {
            java.util.Scanner scan = new java.util.Scanner(new java.io.FileReader(fullName));
            scan.nextLine(); // descartar cabecera
            int insertados = 0;
            while (scan.hasNextLine()) {
                String linea = scan.nextLine();
                if (linea.isBlank()) continue;
                String[] datos = linea.split(",");
                // Adaptar índices y campos a la estructura del CSV del enunciado
                String campo1 = datos[0].trim();
                String campo2 = datos[1].trim();
                String sql = String.format(
                    "INSERT INTO reserva_rest (...) VALUES ('%s','%s')", campo1, campo2);
                try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    conn.createStatement().executeUpdate(sql);
                    System.out.println("Registro insertado en reserva_rest.");
                    insertados++;
                } catch (SQLException e) {
                    System.out.println("Error en INSERT: " + e.getMessage());
                }
            }
            System.out.println("Total insertados: " + insertados);

        } catch (Exception e) {
            System.out.println("Error genérico: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        cargarDesdeCSV("src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 4\\Subbloque 4.1\\reservas.csv");
    }
}
