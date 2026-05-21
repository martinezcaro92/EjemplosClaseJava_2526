import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Subbloque 1.2 - Ejercicio 1
 * Gestión de biblioteca (CSV)
 * Campos: titulo, autor, genero, anio_publicacion
 * Lee el fichero, lo muestra en tabla y permite añadir nuevos libros al final.
 */
public class Ejercicio1 {

    public static void leerFichero(String fullName) {
        try {
            Scanner scan = new Scanner(new FileReader(fullName));
            String cabecera = scan.nextLine();
            String[] campos = cabecera.split(",");

            System.out.println("=".repeat(80));
            for (String c : campos) System.out.printf("%-20s", c.toUpperCase());
            System.out.println();
            System.out.println("=".repeat(80));

            int num = 0;
            while (scan.hasNextLine()) {
                String linea = scan.nextLine();
                if (linea.isBlank()) continue;
                for (String dato : linea.split(",", -1)) System.out.printf("%-20s", dato);
                System.out.println();
                num++;
            }
            System.out.println("=".repeat(80));
            System.out.println("Total de libros: " + num);

        } catch (FileNotFoundException e) {
            System.out.println("Error: fichero no encontrado. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error genérico: " + e.getMessage());
        }
    }

    public static String pedirDatosLibro(Scanner teclado) {
        System.out.print("Título: ");        String titulo = teclado.nextLine();
        System.out.print("Autor: ");         String autor  = teclado.nextLine();
        System.out.print("Género: ");        String genero = teclado.nextLine();
        System.out.print("Año publicación: ");String anio  = teclado.nextLine();
        return titulo + "," + autor + "," + genero + "," + anio;
    }

    public static void guardarFichero(String linea, String fullName) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(fullName, true)); // append = true
            pw.println(linea);
            System.out.println("Libro añadido correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        } finally {
            if (pw != null) pw.close();
        }
    }

    public static void main(String[] args) {
        String fullName = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 1\\Subbloque 1.2\\biblioteca.csv";
        Scanner teclado = new Scanner(System.in);

        leerFichero(fullName);

        String respuesta;
        do {
            System.out.print("\n¿Desea añadir un nuevo libro? (s/n): ");
            respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                String nuevaLinea = pedirDatosLibro(teclado);
                guardarFichero(nuevaLinea, fullName);
                leerFichero(fullName);
            }
        } while (respuesta.equalsIgnoreCase("s"));

        teclado.close();
    }
}
