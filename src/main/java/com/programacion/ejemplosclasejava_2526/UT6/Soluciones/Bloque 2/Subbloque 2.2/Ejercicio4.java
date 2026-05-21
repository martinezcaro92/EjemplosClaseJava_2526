import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Subbloque 2.2 - Ejercicio 4
 * Serialización de objetos EmpleadoRRHH en empleados_rrhh.dat.
 * Campos: dni,nombre,departamento,salario(double)
 * La clase EmpleadoRRHH debe estar definida en el mismo proyecto (implements Serializable).
 */
public class Ejercicio4 {

    // PLANTILLA GENÉRICA - adaptar los campos al tipo EmpleadoRRHH
    // Sustituir el tipo Object por EmpleadoRRHH y completar los atributos solicitados
    public static Object pedirDatos(Scanner teclado) {
        System.out.println("Introduce los datos del nuevo EmpleadoRRHH:");
        // Ejemplo de recogida de datos — adaptar según los atributos reales:
        // System.out.print("Campo1: "); String campo1 = teclado.nextLine();
        // System.out.print("Campo2: "); String campo2 = teclado.nextLine();
        // return new EmpleadoRRHH(campo1, campo2, ...);
        return null; // Reemplazar por instancia de EmpleadoRRHH
    }

    public static void escribirObjeto(File archivo, Object obj) throws IOException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(archivo, true));
            oos.writeObject(obj);
            System.out.println("Registro guardado en empleados_rrhh.dat.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (oos != null) oos.close();
        }
    }

    public static void main(String[] args) {
        File archivo = new File("src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 2\\Subbloque 2.2\\empleados_rrhh.dat");
        Scanner teclado = new Scanner(System.in);

        String respuesta;
        do {
            System.out.print("\n¿Desea añadir un registro? (s/n): ");
            respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                Object obj = pedirDatos(teclado);
                if (obj != null) {
                    try { escribirObjeto(archivo, obj); }
                    catch (IOException e) { System.out.println("Error: " + e.getMessage()); }
                }
            }
        } while (respuesta.equalsIgnoreCase("s"));

        teclado.close();
    }
}
