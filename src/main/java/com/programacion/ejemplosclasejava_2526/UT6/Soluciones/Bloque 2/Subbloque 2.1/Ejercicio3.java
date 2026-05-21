import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Subbloque 2.1 - Ejercicio 3
 * Listado de productos de un almacén
 * Lee objetos Producto de productos.dat y muestra referencia, descripcion,
 * cantidad, precio y el valor total de línea (cantidad x precio).
 * La clase Producto debe implementar Serializable y estar en el mismo directorio.
 */
public class Ejercicio3 {

    public static void leerProductos(File archivo) throws IOException {
        int contador = 0;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(archivo));
            System.out.println("=".repeat(80));
            System.out.printf("%-12s %-22s %-8s %-10s %-10s%n",
                    "REFERENCIA", "DESCRIPCION", "CANT.", "PRECIO", "TOTAL");
            System.out.println("=".repeat(80));
            while (true) {
                // Cast a la clase Producto definida en el proyecto
                Object obj = ois.readObject();
                // Llamamos toString() genérico — adaptar si se añaden getters
                System.out.println(obj.toString());
                contador++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: fichero no encontrado.");
        } catch (EOFException e) {
            System.out.println("=".repeat(80));
            System.out.println("Total de productos: " + contador);
        } catch (Exception e) {
            System.out.println("Error genérico: " + e.getMessage());
        } finally {
            if (ois != null) ois.close();
        }
    }

    public static void main(String[] args) {
        File archivo = new File("src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 2\\Subbloque 2.1\\productos.dat");
        if (!archivo.exists()) { System.out.println("Fichero no encontrado."); return; }
        try { leerProductos(archivo); } catch (IOException e) { System.out.println("Error: " + e.getMessage()); }
    }
}
