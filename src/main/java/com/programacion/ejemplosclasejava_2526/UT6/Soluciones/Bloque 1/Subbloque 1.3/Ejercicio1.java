import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Subbloque 1.3 - Ejercicio 1
 * Alta de nuevos socios de un gimnasio (CSV)
 * Genera desde cero un fichero CSV con: nombre, apellidos, modalidad, fecha_alta.
 * Escribe la cabecera primero y añade socios hasta que el usuario decida parar.
 */
public class Ejercicio1 {

    private static final String CABECERA = "nombre,apellidos,modalidad,fecha_alta";

    public static void inicializarFichero(String fullName) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(fullName, false)); // sobreescribe
            pw.println(CABECERA);
            System.out.println("Fichero inicializado con cabecera.");
        } catch (IOException e) {
            System.out.println("Error al inicializar fichero: " + e.getMessage());
        } finally {
            if (pw != null) pw.close();
        }
    }

    public static String pedirDatosSocio(Scanner teclado) {
        System.out.print("Nombre: ");       String nombre    = teclado.nextLine();
        System.out.print("Apellidos: ");    String apellidos = teclado.nextLine();
        System.out.print("Modalidad (Musculacion/Natacion/Yoga): "); String modalidad = teclado.nextLine();
        System.out.print("Fecha alta (YYYY-MM-DD): "); String fecha = teclado.nextLine();
        return nombre + "," + apellidos + "," + modalidad + "," + fecha;
    }

    public static void guardarSocio(String linea, String fullName) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(fullName, true)); // append
            pw.println(linea);
            System.out.println("Socio registrado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        } finally {
            if (pw != null) pw.close();
        }
    }

    public static void main(String[] args) {
        String fullName = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 1\\Subbloque 1.3\\socios_gimnasio.csv";
        Scanner teclado = new Scanner(System.in);

        inicializarFichero(fullName);

        String respuesta;
        do {
            System.out.print("\n¿Desea añadir un nuevo socio? (s/n): ");
            respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                String linea = pedirDatosSocio(teclado);
                guardarSocio(linea, fullName);
            }
        } while (respuesta.equalsIgnoreCase("s"));

        System.out.println("Fichero guardado en: " + fullName);
        teclado.close();
    }
}
