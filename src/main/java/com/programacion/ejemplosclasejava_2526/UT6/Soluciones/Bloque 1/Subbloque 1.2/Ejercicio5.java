import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Subbloque 1.2 - Ejercicio 5


 * Agenda de eventos culturales (CSV)
 * Campos: nombre_evento, fecha, ubicacion, aforo
 * Lee el fichero, muestra la tabla y permite añadir nuevos registros.
 */
public class Ejercicio5 {

    private static String[] cabeceras;

    public static void leerFichero(String fullName) {
        try {
            Scanner scan = new Scanner(new FileReader(fullName));
            String cabecera = scan.nextLine();
            cabeceras = cabecera.split(",");

            System.out.println("=".repeat(85));
            for (String c : cabeceras) System.out.printf("%-17s", c.toUpperCase());
            System.out.println();
            System.out.println("=".repeat(85));

            int num = 0;
            while (scan.hasNextLine()) {
                String linea = scan.nextLine();
                if (linea.isBlank()) continue;
                String[] datos = linea.split(",", -1);
                for (int i = 0; i < cabeceras.length; i++) {
                    String v = (i < datos.length && !datos[i].isBlank()) ? datos[i] : "N/A";
                    System.out.printf("%-17s", v);
                }
                System.out.println();
                num++;
            }
            System.out.println("=".repeat(85));
            System.out.println("Total de registros: " + num);

        } catch (FileNotFoundException e) {
            System.out.println("Error: fichero no encontrado. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error genérico: " + e.getMessage());
        }
    }

    public static String pedirDatos(Scanner teclado) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cabeceras.length; i++) {
            System.out.print(cabeceras[i] + ": ");
            sb.append(teclado.nextLine());
            if (i < cabeceras.length - 1) sb.append(",");
        }
        return sb.toString();
    }

    public static void guardarFichero(String linea, String fullName) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(fullName, true));
            pw.println(linea);
            System.out.println("Registro añadido correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        } finally {
            if (pw != null) pw.close();
        }
    }

    public static void main(String[] args) {


        String fullName = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 1\\Subbloque 1.2\\eventos.csv";
        Scanner teclado = new Scanner(System.in);

        leerFichero(fullName);

        String respuesta;
        do {
            System.out.print("\n¿Desea añadir un nuevo registro? (s/n): ");
            respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                String nuevaLinea = pedirDatos(teclado);
                guardarFichero(nuevaLinea, fullName);
                leerFichero(fullName);
            }
        } while (respuesta.equalsIgnoreCase("s"));

        teclado.close();
    }
}
