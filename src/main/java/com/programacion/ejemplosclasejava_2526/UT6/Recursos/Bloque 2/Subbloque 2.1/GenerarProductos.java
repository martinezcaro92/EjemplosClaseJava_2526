import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * EJECUTAR ESTE FICHERO ANTES DE Ejercicio3.java
 * Genera productos.dat con objetos Producto serializados.
 */
public class GenerarProductos {
    public static void main(String[] args) {
        String fullName = "src/datos/productos.dat";
        new File("src/datos").mkdirs();

        Producto[] productos = {
            new Producto("REF001", "Tornillo M6 inox",     500,  0.05),
            new Producto("REF002", "Tuerca M6 inox",       500,  0.03),
            new Producto("REF003", "Arandela M6",         1000,  0.02),
            new Producto("REF004", "Varilla roscada 1m",    50,  2.40),
            new Producto("REF005", "Cable electrico 2.5mm",200,  1.15),
            new Producto("REF006", "Interruptor simple",   120,  3.50),
        };

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fullName));
            for (Producto p : productos) oos.writeObject(p);
            System.out.println("Fichero productos.dat generado.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try { if (oos != null) oos.close(); } catch (IOException e) { }
        }
    }
}
