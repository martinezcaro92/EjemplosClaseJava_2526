import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Subbloque 2.1 - Ejercicio 5
 * Archivo de alumnos de un centro educativo
 * Lee objetos Alumno de alumnos.dat: nia, nombre, curso, notaMedia.
 * Muestra tabla e indica cuántos tienen notaMedia >= 5.
 */
public class Ejercicio5 {

    public static void leerAlumnos(File archivo) throws IOException {
        int contador = 0;
        int aprobados = 0;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(archivo));
            System.out.println("=".repeat(70));
            System.out.printf("%-12s %-25s %-10s %-10s%n",
                    "NIA", "NOMBRE", "CURSO", "NOTA MEDIA");
            System.out.println("=".repeat(70));
            while (true) {
                Object obj = ois.readObject();
                System.out.println(obj.toString());
                // Si la clase Alumno tiene getNotaMedia(), usar:
                // if (((Alumno) obj).getNotaMedia() >= 5) aprobados++;
                contador++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: fichero no encontrado.");
        } catch (EOFException e) {
            System.out.println("=".repeat(70));
            System.out.println("Total de alumnos: " + contador);
            System.out.println("(Adaptar contador de aprobados con el getter getNotaMedia())");
        } catch (Exception e) {
            System.out.println("Error genérico: " + e.getMessage());
        } finally {
            if (ois != null) ois.close();
        }
    }

    public static void main(String[] args) {
        File archivo = new File("src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 2\\Subbloque 2.1\\alumnos.dat");
        if (!archivo.exists()) { System.out.println("Fichero no encontrado."); return; }
        try { leerAlumnos(archivo); } catch (IOException e) { System.out.println("Error: " + e.getMessage()); }
    }
}
