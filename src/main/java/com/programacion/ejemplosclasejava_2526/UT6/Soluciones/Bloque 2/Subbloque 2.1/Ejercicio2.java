import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Subbloque 2.1 - Ejercicio 2
 * Consulta de historial de pedidos
 * Lee objetos Pedido serializados de pedidos.dat y los muestra en tabla.
 */
public class Ejercicio2 {

    public static void leerPedidos(File archivo) throws IOException {
        int contador = 0;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(archivo));

            System.out.println("=".repeat(75));
            System.out.printf("%-5s %-18s %-18s %-8s %-10s%n",
                    "ID", "CLIENTE", "PRODUCTO", "CANT.", "TOTAL");
            System.out.println("=".repeat(75));

            while (true) {
                Pedido p = (Pedido) ois.readObject();
                System.out.printf("%-5d %-18s %-18s %-8d %-10.2f%n",
                        p.getId(), p.getCliente(), p.getProducto(),
                        p.getCantidad(), p.getTotal());
                contador++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: fichero no encontrado.");
        } catch (EOFException e) {
            System.out.println("=".repeat(75));
            System.out.println("Total de pedidos leídos: " + contador);
        } catch (Exception e) {
            System.out.println("Error genérico: " + e.getMessage());
        } finally {
            if (ois != null) ois.close();
        }
    }

    public static void main(String[] args) {
        File archivo = new File("src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 2\\Subbloque 2.1\\pedidos.dat");
        if (!archivo.exists()) { System.out.println("Fichero no encontrado."); return; }
        try { leerPedidos(archivo); } catch (IOException e) { System.out.println("Error: " + e.getMessage()); }
    }
}
