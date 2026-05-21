import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Subbloque 1.3 - Ejercicio 4
 * Cuaderno de notas de alumnos (JSON)
 * Campos: nombre_alumno, asignatura, calificacion
 */
public class Ejercicio4 {

    public static JSONObject pedirDatosNota(Scanner teclado) {
        JSONObject nota = new JSONObject();
        System.out.print("Nombre del alumno: "); nota.put("nombre_alumno", teclado.nextLine());
        System.out.print("Asignatura: ");        nota.put("asignatura",    teclado.nextLine());
        System.out.print("Calificación (0-10): ");
        nota.put("calificacion", Double.parseDouble(teclado.nextLine().trim()));
        return nota;
    }

    public static void guardarFichero(JSONArray notas, String fullName) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(fullName));
            pw.println(notas.toString(2));
            System.out.println("Cuaderno guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        } finally {
            if (pw != null) pw.close();
        }
    }

    public static void main(String[] args) {
        String fullName = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 1\\Subbloque 1.3\\notas_alumnos.json";
        Scanner teclado = new Scanner(System.in);
        JSONArray notas = new JSONArray();

        System.out.println("--- Cuaderno de notas ---");
        String respuesta;
        do {
            System.out.print("\n¿Desea añadir una nota? (s/n): ");
            respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                notas.put(pedirDatosNota(teclado));
            }
        } while (respuesta.equalsIgnoreCase("s"));

        guardarFichero(notas, fullName);
        System.out.println("Notas registradas: " + notas.length());
        teclado.close();
    }
}
