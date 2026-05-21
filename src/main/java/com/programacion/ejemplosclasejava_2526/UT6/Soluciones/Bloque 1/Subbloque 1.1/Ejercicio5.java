import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Subbloque 1.1 - Ejercicio 5
 * Directorio de contactos (CSV)
 * Campos: nombre, telefono, email, ciudad
 * Imprime la cabecera de forma dinámica y muestra "N/A" para campos vacíos.
 */
public class Ejercicio5 {

    public static void leerFichero(String fullName) {
        try {
            Scanner scan = new Scanner(new FileReader(fullName));

            // Cabecera dinámica
            String cabecera = scan.nextLine();
            String[] campos = cabecera.split(",");

            System.out.println("=".repeat(75));
            for (String campo : campos) {
                System.out.printf("%-18s", campo.toUpperCase());
            }
            System.out.println();
            System.out.println("=".repeat(75));

            int numContactos = 0;
            while (scan.hasNextLine()) {
                String linea = scan.nextLine();
                if (linea.isBlank()) continue;
                String[] datos = linea.split(",", -1); // -1 para conservar campos vacíos

                for (int i = 0; i < campos.length; i++) {
                    String valor = (i < datos.length && !datos[i].isBlank()) ? datos[i] : "N/A";
                    System.out.printf("%-18s", valor);
                }
                System.out.println();
                numContactos++;
            }
            System.out.println("=".repeat(75));
            System.out.println("Total de contactos: " + numContactos);

        } catch (FileNotFoundException e) {
            System.out.println("Error: fichero no encontrado. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error genérico: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String fullName = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 1\\Subbloque 1.1\\contactos.csv";
        leerFichero(fullName);
    }
}
