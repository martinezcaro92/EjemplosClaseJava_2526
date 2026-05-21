import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * EJECUTAR ESTE FICHERO ANTES DE Ejercicio2.java
 * Genera el fichero pedidos.dat con objetos Pedido serializados.
 * Copiar Pedido.java en el mismo directorio antes de compilar.
 */
public class GenerarPedidos {
    public static void main(String[] args) {
        String fullName = "src/datos/pedidos.dat";
        new File("src/datos").mkdirs();

        Pedido[] pedidos = {
            new Pedido(1, "Ana Garcia",   "Teclado mecanico",   1,  89.99),
            new Pedido(2, "Luis Perez",   "Monitor 27 pulgadas",1, 349.00),
            new Pedido(3, "Carmen Ruiz",  "Raton inalambrico",  2,  69.00),
            new Pedido(4, "Jorge Blanco", "SSD 1TB",            3, 297.00),
            new Pedido(5, "Maria Lopez",  "Auriculares gaming", 1,  79.95),
            new Pedido(6, "David Sanz",   "Webcam HD",          2, 110.00),
        };

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fullName));
            for (Pedido p : pedidos) oos.writeObject(p);
            System.out.println("Fichero pedidos.dat generado con " + pedidos.length + " registros.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try { if (oos != null) oos.close(); } catch (IOException e) { }
        }
    }
}
