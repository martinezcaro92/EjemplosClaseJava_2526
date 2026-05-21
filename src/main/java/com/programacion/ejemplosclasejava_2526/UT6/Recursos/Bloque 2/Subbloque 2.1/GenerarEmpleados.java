import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * EJECUTAR ESTE FICHERO ANTES DE Ejercicio1.java
 * Genera el fichero empleados.dat con objetos Empleado serializados.
 * Copiar Empleado.java en el mismo directorio antes de compilar.
 */
public class GenerarEmpleados {
    public static void main(String[] args) {
        String fullName = "src/datos/empleados.dat";
        new File("src/datos").mkdirs();

        Empleado[] empleados = {
            new Empleado("12345678A", "Ana Garcia",     101, "Informatica"),
            new Empleado("23456789B", "Luis Perez",     102, "Recursos Humanos"),
            new Empleado("34567890C", "Carmen Ruiz",    103, "Contabilidad"),
            new Empleado("45678901D", "Jorge Blanco",   104, "Informatica"),
            new Empleado("56789012E", "Maria Lopez",    105, "Marketing"),
            new Empleado("67890123F", "David Sanz",     106, "Contabilidad"),
            new Empleado("78901234G", "Sofia Torres",   107, "Recursos Humanos"),
        };

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fullName));
            for (Empleado e : empleados) {
                oos.writeObject(e);
            }
            System.out.println("Fichero empleados.dat generado con " + empleados.length + " registros.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try { if (oos != null) oos.close(); } catch (IOException e) { }
        }
    }
}
