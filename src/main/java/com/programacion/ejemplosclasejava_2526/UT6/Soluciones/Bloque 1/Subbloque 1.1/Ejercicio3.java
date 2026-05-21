import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Subbloque 1.1 - Ejercicio 3
 * Consulta de resultados deportivos (CSV)
 * Campos: jornada, equipo_local, equipo_visitante, goles_local, goles_visitante
 * Muestra los partidos en tabla indicando el resultado (V.Local / Empate / V.Visitante).
 */
public class Ejercicio3 {

    public static void leerFichero(String fullName) {
        try {
            Scanner scan = new Scanner(new FileReader(fullName));
            String cabecera = scan.nextLine(); // descartar cabecera

            System.out.println("=".repeat(80));
            System.out.printf("%-8s %-22s %-22s %-6s %-6s %-14s%n",
                    "JORNADA", "LOCAL", "VISITANTE", "GL", "GV", "RESULTADO");
            System.out.println("=".repeat(80));

            int numPartidos = 0;
            while (scan.hasNextLine()) {
                String linea = scan.nextLine();
                if (linea.isBlank()) continue;
                String[] d = linea.split(",");

                String jornada   = d[0];
                String local     = d[1];
                String visitante = d[2];
                int gl           = Integer.parseInt(d[3].trim());
                int gv           = Integer.parseInt(d[4].trim());

                String resultado;
                if (gl > gv)      resultado = "Victoria Local";
                else if (gl < gv) resultado = "Victoria Visitante";
                else              resultado = "Empate";

                System.out.printf("%-8s %-22s %-22s %-6d %-6d %-14s%n",
                        jornada, local, visitante, gl, gv, resultado);
                numPartidos++;
            }
            System.out.println("=".repeat(80));
            System.out.println("Total de partidos: " + numPartidos);

        } catch (FileNotFoundException e) {
            System.out.println("Error: fichero no encontrado. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error genérico: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        
        String fullName = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 1\\Subbloque 1.1\\resultados.csv";
        leerFichero(fullName);
    }
}
