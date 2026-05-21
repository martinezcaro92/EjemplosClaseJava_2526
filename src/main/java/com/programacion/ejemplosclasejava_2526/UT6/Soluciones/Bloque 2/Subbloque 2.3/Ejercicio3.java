import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Subbloque 2.3 - Ejercicio 3
 * Archivo de jugadores de un equipo deportivo
 * Verifica si jugadores.dat existe, lee los registros, los muestra en tabla
 * y permite añadir nuevos objetos Jugador al fichero.
 * La clase Jugador debe implementar Serializable y estar en el mismo proyecto.
 * Usa AppendObjectOutputStream para añadir sin corromper el fichero.
 */
public class Ejercicio3 {

    public static void leerObjetos(File archivo) throws IOException {
        int contador = 0;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(archivo));
            System.out.println("=".repeat(65));
            System.out.println("Registros en jugadores.dat:");
            System.out.println("=".repeat(65));
            while (true) {
                Object obj = ois.readObject();
                System.out.println(obj.toString());
                contador++;
            }
        } catch (EOFException e) {
            System.out.println("=".repeat(65));
            System.out.println("Total de registros: " + contador);
        } catch (FileNotFoundException e) {
            System.out.println("Error: fichero no encontrado.");
        } catch (Exception e) {
            System.out.println("Error genérico: " + e.getMessage());
        } finally {
            if (ois != null) ois.close();
        }
    }

    // Adaptar este método para recoger los atributos reales de Jugador
    public static Object pedirDatos(Scanner teclado) {
        System.out.println("Introduce los datos del nuevo Jugador:");
        // Ejemplo — reemplazar por atributos reales y construcción de Jugador:
        // System.out.print("Campo1: "); String c1 = teclado.nextLine();
        // return new Jugador(c1, ...);
        return null;
    }

    public static void escribirObjeto(File archivo, Object obj) throws IOException {
        ObjectOutputStream oos = null;
        try {
            if (archivo.exists()) {
                oos = new AppendObjectOutputStream(new FileOutputStream(archivo, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(archivo));
            }
            oos.writeObject(obj);
            System.out.println("Registro añadido a jugadores.dat.");
        } finally {
            if (oos != null) oos.close();
        }
    }

    public static void main(String[] args) {
        File archivo = new File("src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 2\\Subbloque 2.3\\jugadores.dat");
        Scanner teclado = new Scanner(System.in);

        if (archivo.exists()) {
            try { leerObjetos(archivo); }
            catch (IOException e) { System.out.println("Error al leer: " + e.getMessage()); }
        } else {
            System.out.println("No existe fichero previo. Se creará uno nuevo.");
        }

        String respuesta;
        do {
            System.out.print("\n¿Desea añadir un registro? (s/n): ");
            respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                Object obj = pedirDatos(teclado);
                if (obj != null) {
                    try { escribirObjeto(archivo, obj); }
                    catch (IOException e) { System.out.println("Error al escribir: " + e.getMessage()); }
                }
            }
        } while (respuesta.equalsIgnoreCase("s"));

        teclado.close();
    }
}
