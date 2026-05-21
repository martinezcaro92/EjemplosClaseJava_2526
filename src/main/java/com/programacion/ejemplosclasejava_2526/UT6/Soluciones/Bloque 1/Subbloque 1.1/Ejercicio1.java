import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Subbloque 1.1 - Ejercicio 1
 * Lector de catálogo de películas (CSV)
 * Lee un fichero CSV con columnas: titulo, genero, anio, puntuacion
 * y muestra la información en formato tabla.
 */
public class Ejercicio1 {

    public static void leerFichero(String fullName) {
        try {
            Scanner scan = new Scanner(new FileReader(fullName));

            // Leer cabecera
            String cabecera = scan.nextLine();
            String[] campos = cabecera.split(",");

            // Imprimir cabecera de tabla
            System.out.println("=".repeat(70));
            System.out.printf("%-30s %-20s %-8s %-8s%n",
                    campos[0].toUpperCase(), campos[1].toUpperCase(),
                    campos[2].toUpperCase(), campos[3].toUpperCase());
            System.out.println("=".repeat(70));

            int numRegistros = 0;
            while (scan.hasNextLine()) {
                String linea = scan.nextLine();
                if (linea.isBlank()) continue;
                String[] datos = linea.split(",");

                String titulo   = datos[0];
                String genero   = datos[1];
                String anio     = datos[2];
                String punt     = datos[3];

                System.out.printf("%-30s %-20s %-8s %-8s%n", titulo, genero, anio, punt);
                numRegistros++;
            }
            System.out.println("=".repeat(70));
            System.out.println("Total de registros leídos: " + numRegistros);

        } catch (FileNotFoundException e) {
            System.out.println("Error: fichero no encontrado. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error genérico: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Ajusta la ruta al fichero CSV en tu proyecto
        String fileName = "peliculas.csv";
        String path     = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 1\\Subbloque 1.1";
        String fullName = path + "\\" + fileName;

        leerFichero(fullName);
    }
}
