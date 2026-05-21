import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Subbloque 1.3 - Ejercicio 3
 * Inventario inicial de un almacén (CSV)
 * Campos: referencia, descripcion, cantidad, precio_unitario
 */
public class Ejercicio3 {

    private static final String CABECERA = "referencia,descripcion,cantidad,precio_unitario";

    public static String pedirDatosProducto(Scanner teclado) {
        System.out.print("Referencia: ");       String ref  = teclado.nextLine();
        System.out.print("Descripción: ");      String desc = teclado.nextLine();
        System.out.print("Cantidad: ");         String cant = teclado.nextLine();
        System.out.print("Precio unitario: ");  String prec = teclado.nextLine();
        return ref + "," + desc + "," + cant + "," + prec;
    }

    public static void guardar(String linea, String fullName, boolean append) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(fullName, append));
            pw.println(linea);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        } finally {
            if (pw != null) pw.close();
        }
    }

    public static void main(String[] args) {
        String fullName = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 1\\Subbloque 1.3\\inventario_almacen.csv";
        Scanner teclado = new Scanner(System.in);

        guardar(CABECERA, fullName, false); // crear fichero con cabecera
        System.out.println("Fichero de inventario creado.");

        String respuesta;
        do {
            System.out.print("\n¿Desea añadir un producto? (s/n): ");
            respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                guardar(pedirDatosProducto(teclado), fullName, true);
                System.out.println("Producto registrado.");
            }
        } while (respuesta.equalsIgnoreCase("s"));

        System.out.println("Inventario guardado en: " + fullName);
        teclado.close();
    }
}
