import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Subbloque 1.3 - Ejercicio 5
 * Lista de tareas pendientes de un proyecto (CSV)
 * Campos: titulo, responsable, fecha_limite, estado
 */
public class Ejercicio5 {

    private static final String CABECERA = "titulo,responsable,fecha_limite,estado";

    public static String pedirDatosTarea(Scanner teclado) {
        System.out.print("Título de la tarea: ");  String titulo = teclado.nextLine();
        System.out.print("Responsable: ");         String resp   = teclado.nextLine();
        System.out.print("Fecha límite (YYYY-MM-DD): "); String fecha = teclado.nextLine();
        System.out.print("Estado (pendiente/en progreso/completada): "); String estado = teclado.nextLine();
        return titulo + "," + resp + "," + fecha + "," + estado;
    }

    public static void guardar(String linea, String fullName, boolean append) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(fullName, append));
            pw.println(linea);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        } finally {
            if (pw != null) pw.close();
        }
    }

    public static void main(String[] args) {
        String fullName = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 1\\Subbloque 1.3\\tareas_proyecto.csv";
        Scanner teclado = new Scanner(System.in);

        guardar(CABECERA, fullName, false);
        System.out.println("Fichero de tareas creado.");

        String respuesta;
        do {
            System.out.print("\n¿Desea añadir una tarea? (s/n): ");
            respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                guardar(pedirDatosTarea(teclado), fullName, true);
                System.out.println("Tarea registrada.");
            }
        } while (respuesta.equalsIgnoreCase("s"));

        System.out.println("Fichero guardado en: " + fullName);
        teclado.close();
    }
}
