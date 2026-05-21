import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Subbloque 1.1 - Ejercicio 2
 * Visor de inventario de una tienda (JSON)
 * Lee un fichero JSON con productos (nombre, categoria, precio, stock)
 * y muestra la información en formato tabla.
 */
public class Ejercicio2 {

    public static void leerFichero(String fullName) {
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(fullName)));
            JSONArray registros = new JSONArray(contenido);

            if (registros.isEmpty()) {
                System.out.println("El fichero no contiene registros.");
                return;
            }

            // Obtener claves del primer objeto para la cabecera
            JSONObject primero = registros.getJSONObject(0);
            Set<String> claves = primero.keySet();

            // Imprimir cabecera
            System.out.println("=".repeat(70));
            for (String clave : claves) {
                System.out.printf("%-18s", clave.toUpperCase());
            }
            System.out.println();
            System.out.println("=".repeat(70));

            // Imprimir filas
            for (int i = 0; i < registros.length(); i++) {
                JSONObject obj = registros.getJSONObject(i);
                for (String clave : claves) {
                    System.out.printf("%-18s", obj.optString(clave, "N/A"));
                }
                System.out.println();
            }
            System.out.println("=".repeat(70));
            System.out.println("Total de registros: " + registros.length());

        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error genérico: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String fileName = "inventario.json";
        String path     = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 1\\Subbloque 1.1";
        String fullName = path + "\\" + fileName;

        leerFichero(fullName);
    }
}
