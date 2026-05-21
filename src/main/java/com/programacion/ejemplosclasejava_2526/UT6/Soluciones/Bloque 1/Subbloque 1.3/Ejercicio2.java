import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Subbloque 1.3 - Ejercicio 2
 * Registro de pedidos en una cafetería (JSON)
 * Campos: producto, cantidad, precio
 * Genera el fichero JSON desde cero añadiendo pedidos hasta que el usuario pare.
 */
public class Ejercicio2 {

    public static JSONObject pedirDatosPedido(Scanner teclado) {
        JSONObject pedido = new JSONObject();
        System.out.print("Producto: ");  pedido.put("producto", teclado.nextLine());
        System.out.print("Cantidad: ");  pedido.put("cantidad", Integer.parseInt(teclado.nextLine().trim()));
        System.out.print("Precio (€): "); pedido.put("precio", Double.parseDouble(teclado.nextLine().trim()));
        return pedido;
    }

    public static void guardarFichero(JSONArray pedidos, String fullName) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(fullName)); // sobreescritura total
            pw.println(pedidos.toString(2));
            System.out.println("Fichero guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        } finally {
            if (pw != null) pw.close();
        }
    }

    public static void main(String[] args) {
        String fullName = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 1\\Subbloque 1.3\\pedidos_cafeteria.json";
        Scanner teclado = new Scanner(System.in);
        JSONArray pedidos = new JSONArray();

        System.out.println("--- Registro de pedidos de cafetería ---");
        String respuesta;
        do {
            System.out.print("\n¿Desea añadir un nuevo pedido? (s/n): ");
            respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                JSONObject pedido = pedirDatosPedido(teclado);
                pedidos.put(pedido);
                System.out.println("Pedido añadido al registro.");
            }
        } while (respuesta.equalsIgnoreCase("s"));

        guardarFichero(pedidos, fullName);
        System.out.println("Total de pedidos registrados: " + pedidos.length());
        teclado.close();
    }
}
