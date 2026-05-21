import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Subbloque 2.1 - Ejercicio 1
 * Visor de expedientes de empleados
 * Lee objetos Empleado serializados de un fichero .dat y los muestra en tabla.
 */
public class Ejercicio1 {

    public static void leerEmpleados(File archivo) throws IOException {
        int contador = 0;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(archivo));

            System.out.println("=".repeat(70));
            System.out.printf("%-12s %-20s %-12s %-15s%n",
                    "DNI", "NOMBRE", "NUM_EMP", "DEPARTAMENTO");
            System.out.println("=".repeat(70));

            while (true) {
                Empleado emp = (Empleado) ois.readObject();
                System.out.printf("%-12s %-20s %-12d %-15s%n",
                        emp.getDni(), emp.getNombre(),
                        emp.getNumEmpleado(), emp.getDepartamento());
                contador++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: fichero no encontrado.");
        } catch (EOFException e) {
            System.out.println("=".repeat(70));
            System.out.println("Fichero leído. Total empleados: " + contador);
        } catch (Exception e) {
            System.out.println("Error genérico: " + e.getMessage());
        } finally {
            if (ois != null) ois.close();
        }
    }

    public static void main(String[] args) {
        String fullName = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 2\\Subbloque 2.1\\empleados.dat";
        File archivo = new File(fullName);

        if (!archivo.exists()) {
            System.out.println("El fichero no existe: " + fullName);
            return;
        }

        try {
            leerEmpleados(archivo);
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }
}
