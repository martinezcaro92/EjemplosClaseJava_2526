/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.IO.texto.EjercicioJSONLibreria;

import static com.programacion.ejemplosclasejava_2526.IO.texto.EjercicioCSV.GestorUsuarios.guardarFichero;
import static com.programacion.ejemplosclasejava_2526.IO.texto.EjercicioCSV.GestorUsuarios.pedirDatosUsuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author josem
 */
public class GestorUsuariosJSON {
    private static String path = "src\\main\\java\\com\\programacion\\Examenes_2526\\IOTexto\\GestorUsuariosJSON";
    private static String nombreJson = "usuarios.json";
    private static final String RUTA_FICHERO = path + "\\" + nombreJson;

    // Almacenamos los nombres de los campos (las "claves" del JSON) dinámicamente
    private static List<String> columnasDinámicas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean continuar = true;

        mostrarDatos();

        while (continuar) {
            System.out.print("\n¿Desea añadir un nuevo registro? (s/n): ");
            String respuesta = teclado.nextLine().trim().toLowerCase();

            if (respuesta.equals("s")) {
                anadirRegistroGenerico(teclado);
                System.out.println("\n--- Tabla actualizada ---");
                mostrarDatos();
            } else if (respuesta.equals("n")) {
                System.out.println("\nSaliendo del programa. ¡Hasta la próxima!");
                continuar = false;
            } else {
                System.out.println("\nRespuesta no válida. Por favor, introduzca 's' o 'n'.");
            }
        }
        
        teclado.close();
    }

    /**
     * Lee el JSON manualmente y crea una lista de mapas.
     * Cada mapa representa un objeto JSON completo con sus pares clave-valor.
     */
    private static List<Map<String, String>> leerFicheroComoMapas() {
        List<Map<String, String>> registros = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_FICHERO))) {
            String linea;
            Map<String, String> registroActual = null;

            while ((linea = br.readLine()) != null) {
                if (linea.contains("{")) {
                    // Iniciamos un nuevo objeto usando LinkedHashMap para mantener el orden de inserción
                    registroActual = new LinkedHashMap<>();
                } 
                else if (linea.contains("}")) {
                    // Final del objeto, lo añadimos a la lista si tiene datos
                    if (registroActual != null && !registroActual.isEmpty()) {
                        registros.add(registroActual);
                    }
                } 
                else if (linea.contains(":") && registroActual != null) {
                    // Dividimos la línea por los dos puntos (límite 2 para no romper si el valor tiene ":")
                    String[] partes = linea.split(":", 2);
                    
                    // Limpiamos la clave y el valor de comillas, comas y espacios
                    String clave = partes[0].replace("\"", "").trim();
                    String valor = partes[1].replace("\"", "").replace(",", "").trim();
                    
                    registroActual.put(clave, valor);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
        
        return registros;
    }

    /**
     * Muestra los datos utilizando la lista de mapas, generando la cabecera
     * en función del primer registro encontrado.
     */
    private static void mostrarDatos() {
        List<Map<String, String>> registros = leerFicheroComoMapas();
        
        if (registros.isEmpty()) {
            System.out.println("No se encontraron registros o el fichero no existe.");
            return;
        }

        // Extraemos las columnas a partir de las claves del primer registro
        columnasDinámicas = new ArrayList<>(registros.get(0).keySet());
        
        // Calculamos un separador dinámico basado en la cantidad de columnas (16 caracteres por columna)
        String separador = "=".repeat(columnasDinámicas.size() * 16);

        System.out.println(separador);
        
        // Imprimimos la cabecera dinámicamente
        for (String columna : columnasDinámicas) {
            System.out.printf("%-15s ", columna.toUpperCase());
        }
        System.out.println("\n" + separador);

        // Imprimimos los datos
        for (Map<String, String> registro : registros) {
            for (String columna : columnasDinámicas) {
                // Obtenemos el valor de la clave, o vacío si esa clave no existe en este registro
                String valor = registro.getOrDefault(columna, "");
                System.out.printf("%-15s ", valor);
            }
            System.out.println();
        }
        
        System.out.println(separador);
        System.out.println("Total de registros leídos: " + registros.size());
    }

    /**
     * Pide los datos de forma iterativa basándose en los campos descubiertos
     * y escribe el JSON resultante en el fichero.
     */
    private static void anadirRegistroGenerico(Scanner teclado) {
        if (columnasDinámicas.isEmpty()) {
            System.out.println("Error: No se han podido identificar las columnas dinámicas para insertar datos.");
            return;
        }

        System.out.println("\n--- Introduce los datos del nuevo registro ---");
        Map<String, String> nuevoDato = new LinkedHashMap<>();
        
        // Iteramos sobre cada columna detectada pidiendo los datos al usuario
        for (String columna : columnasDinámicas) {
            System.out.print(columna + " : ");
            nuevoDato.put(columna, teclado.nextLine().trim());
        }

        // Construcción del bloque JSON dinámicamente
        StringBuilder nuevoObjeto = new StringBuilder();
        nuevoObjeto.append(",\n  {\n");
        
        int contador = 0;
        int totalAtributos = nuevoDato.size();
        
        for (Map.Entry<String, String> entrada : nuevoDato.entrySet()) {
            String clave = entrada.getKey();
            String valor = entrada.getValue();
            
            nuevoObjeto.append("    \"").append(clave).append("\": ");
            
            // Evaluamos si el valor es numérico puramente entero para omitir comillas
            // Esto cumple con el requisito de que "identifier" no lleve comillas
            if (valor.matches("-?\\d+")) {
                nuevoObjeto.append(valor);
            } else {
                nuevoObjeto.append("\"").append(valor).append("\"");
            }

            contador++;
            // Añadimos la coma si no es el último atributo
            if (contador < totalAtributos) {
                nuevoObjeto.append(",");
            }
            nuevoObjeto.append("\n");
        }
        nuevoObjeto.append("  }\n]");

        // Proceso de lectura, reemplazo del corchete final de cierre y sobreescritura
        StringBuilder contenidoFichero = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_FICHERO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenidoFichero.append(linea).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero para su modificación: " + e.getMessage());
            return;
        }

        int indexCierre = contenidoFichero.lastIndexOf("]");
        if (indexCierre != -1) {
            contenidoFichero.replace(indexCierre, contenidoFichero.length(), nuevoObjeto.toString());
        } else {
            System.err.println("Error: Fichero JSON con formato corrupto (falta ']').");
            return;
        }

        try (FileWriter fw = new FileWriter(RUTA_FICHERO)) {
            fw.write(contenidoFichero.toString());
            System.out.println("\nRegistro añadido correctamente al fichero.");
        } catch (IOException e) {
            System.err.println("Error al escribir los cambios en el fichero: " + e.getMessage());
        }
    }
}
