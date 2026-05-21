import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Subbloque 1.1 - Ejercicio 4
 * Registro de temperaturas meteorológicas (JSON)
 * Campos: estacion, fecha, temp_max, temp_min
 * Muestra los datos en tabla calculando la temperatura media de cada registro.
 */
public class Ejercicio4 {

    public static void leerFichero(String fullName) {
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(fullName)));
            JSONArray registros = new JSONArray(contenido);

            if (registros.isEmpty()) {
                System.out.println("No se han encontrado registros.");
                return;
            }

            System.out.println("=".repeat(65));
            System.out.printf("%-15s %-12s %-10s %-10s %-8s%n",
                    "ESTACION", "FECHA", "TEMP_MAX", "TEMP_MIN", "MEDIA");
            System.out.println("=".repeat(65));

            for (int i = 0; i < registros.length(); i++) {
                JSONObject obj = registros.getJSONObject(i);

                String estacion = obj.optString("estacion", "N/A");
                String fecha    = obj.optString("fecha",    "N/A");
                double tmax     = obj.optDouble("temp_max", 0.0);
                double tmin     = obj.optDouble("temp_min", 0.0);
                double media    = (tmax + tmin) / 2.0;

                System.out.printf("%-15s %-12s %-10.1f %-10.1f %-8.1f%n",
                        estacion, fecha, tmax, tmin, media);
            }
            System.out.println("=".repeat(65));

        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error genérico: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String fullName = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 1\\Subbloque 1.1\\temperaturas.json";
        leerFichero(fullName);
    }
}
