import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Subbloque 2.2 - Ejercicio 2
 * Serialización de objetos Socio en socios.dat.
 * Campos: numSocio(int),nombre,apellidos,fechaAlta
 * La clase Socio debe estar definida en el mismo proyecto (implements Serializable).
 */
public class Ejercicio2 {

    // PLANTILLA GENÉRICA - adaptar los campos al tipo Socio
    // Sustituir el tipo Object por Socio y completar los atributos solicitados
    public static Object pedirDatos(Scanner teclado) {
        System.out.println("Introduce los datos del nuevo Socio:");
        // Ejemplo de recogida de datos — adaptar según los atributos reales:
        // System.out.print("Campo1: "); String campo1 = teclado.nextLine();
        // System.out.print("Campo2: "); String campo2 = teclado.nextLine();
        // return new Socio(campo1, campo2, ...);
        return null; // Reemplazar por instancia de Socio
    }

    public static void escribirObjeto(File archivo, Object obj) throws IOException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(archivo, true));
            oos.writeObject(obj);
            System.out.println("Registro guardado en socios.dat.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (oos != null) oos.close();
        }
    }

    public static void main(String[] args) {
        File archivo = new File("src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 2\\Subbloque 2.2\\socios.dat");
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
