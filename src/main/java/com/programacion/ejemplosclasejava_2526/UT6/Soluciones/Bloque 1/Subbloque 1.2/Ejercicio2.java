import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Subbloque 1.2 - Ejercicio 2
 * Registro de pacientes de una clínica (JSON)
 * Campos: nombre, fecha_nacimiento, grupo_sanguineo, alergias
 * Lee el fichero, lo muestra en tabla y permite añadir nuevos pacientes.
 * Al guardar se reescribe el fichero completo con el nuevo registro incluido.
 */
public class Ejercicio2 {

    private static JSONArray registros = new JSONArray();
    private static Set<String> claves;

    public static void leerFichero(String fullName) {
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(fullName)));
            registros = new JSONArray(contenido);

            if (registros.isEmpty()) {
                System.out.println("No hay pacientes registrados.");
                return;
            }

            JSONObject primero = registros.getJSONObject(0);
            claves = primero.keySet();

            System.out.println("=".repeat(75));
            for (String clave : claves) System.out.printf("%-18s", clave.toUpperCase());
            System.out.println();
            System.out.println("=".repeat(75));

            for (int i = 0; i < registros.length(); i++) {
                JSONObject obj = registros.getJSONObject(i);
                for (String clave : claves) System.out.printf("%-18s", obj.optString(clave, "N/A"));
                System.out.println();
            }
            System.out.println("=".repeat(75));
            System.out.println("Total de pacientes: " + registros.length());

        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error genérico: " + e.getMessage());
        }
    }

    public static void anadirPaciente(Scanner teclado) {
        JSONObject nuevo = new JSONObject();
        System.out.print("Nombre: ");             nuevo.put("nombre",           teclado.nextLine());
        System.out.print("Fecha de nacimiento: "); nuevo.put("fecha_nacimiento", teclado.nextLine());
        System.out.print("Grupo sanguíneo: ");     nuevo.put("grupo_sanguineo",  teclado.nextLine());
        System.out.print("Alergias: ");            nuevo.put("alergias",         teclado.nextLine());
        registros.put(nuevo);
    }

    public static void guardarFichero(String fullName) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(fullName)); // sobreescribe todo
            pw.println(registros.toString(2));
            System.out.println("Paciente guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        } finally {
            if (pw != null) pw.close();
        }
    }

    public static void main(String[] args) {
        String fullName = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\UT6\\Bloque 1\\Subbloque 1.1\\pacientes.json";
        Scanner teclado = new Scanner(System.in);

        leerFichero(fullName);

        String respuesta;
        do {
            System.out.print("\n¿Desea añadir un nuevo paciente? (s/n): ");
            respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                anadirPaciente(teclado);
                guardarFichero(fullName);
                leerFichero(fullName);
            }
        } while (respuesta.equalsIgnoreCase("s"));

        teclado.close();
    }
}
