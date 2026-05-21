import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * EJECUTAR ESTE FICHERO ANTES DE Ejercicio5.java
 * Genera alumnos.dat con objetos Alumno serializados.
 */
public class GenerarAlumnos {
    public static void main(String[] args) {
        String fullName = "src/datos/alumnos.dat";
        new File("src/datos").mkdirs();

        Alumno[] alumnos = {
            new Alumno("NIA001", "Ana Garcia",     "DAM1", 8.5),
            new Alumno("NIA002", "Luis Perez",     "DAM2", 4.8),
            new Alumno("NIA003", "Marta Sanz",     "DAW1", 7.2),
            new Alumno("NIA004", "David Ruiz",     "DAW1", 5.0),
            new Alumno("NIA005", "Sofia Torres",   "DAM1", 9.1),
            new Alumno("NIA006", "Carlos Mendez",  "DAM2", 3.9),
            new Alumno("NIA007", "Lucia Fernandez","DAW1", 6.8),
        };

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fullName));
            for (Alumno a : alumnos) oos.writeObject(a);
            System.out.println("Fichero alumnos.dat generado.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try { if (oos != null) oos.close(); } catch (IOException e) { }
        }
    }
}
