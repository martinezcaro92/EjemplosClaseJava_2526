/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.IO.texto.EjercicioJSONLibreria;

import static com.programacion.ejemplosclasejava_2526.IO.texto.EjercicioCSV.GestorUsuarios.guardarFichero;
import static com.programacion.ejemplosclasejava_2526.IO.texto.EjercicioCSV.GestorUsuarios.pedirDatosUsuario;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author josem
 */
public class GestorUsuariosJSONLib {
    private static Set<String> claves;
    private static JSONArray registros;
    
    // método leerFichero
    public static void leerFichero(String fullName)
    {
        try{
            // Se genera un JSONArray a partir de un String para poder navegar
            // por los diferentes elementos del fichero JSON
            registros = new JSONArray(
                new String (Files.readAllBytes(Paths.get(fullName))));
            
            // Entra en el if si el fichero está vacío y no tiene datos.
            if (registros.isEmpty())
            {
                System.out.println("No se han encontrado registros");
                return;
                // Este return finalizaría la ejecución del método leerFichero y 
                // continuaría con la ejecución secuencial del método main
            }
            
            // Extraemos el primer objeto para obtener los nombres de las columnas
            // Estos datos se meten en una variable tipo Set<String>
            JSONObject primerElemento = registros.getJSONObject(0);
            claves = primerElemento.keySet();
            
            // Se comprueba si obtiene correctamente el nombre de las columnas del fichero JSON
            // System.out.println(nombreColumnas);
            
            // Se imprime la cabecera de la tabla con los datos clave
            System.out.println("=============================================================================================");
            for (String campo: claves)
            {
                System.out.printf("%-15s", campo);
            }
            System.out.println(); // Salto de línea al acabar el bucle for
            System.out.println("=============================================================================================");

            // Ahora por cada entrada se leerán los datos de los valores de los objetos JSON
            for (int i = 0; i < registros.length(); i++)
            {
                // Tomo todo el objeto de la posición i
                // registro != registros -- Hay una s de diferencia entre ambos
                JSONObject registro = registros.getJSONObject(i);
                for (String clave: claves)
                {
                    // Como los JSON son pares de clave-valor, para una clave dada,
                    // se obtiene un valor determinado
                    String valor = registro.optString(clave);
                    System.out.printf("%-15s", valor);
                    
                }
                System.out.println();
            }
            System.out.println("=============================================================================================");

            
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } catch (Exception e) {
            System.out.println("Error genérico: " + e);
        }
        
        
    }
    // método recopilarInfo
    public static JSONArray recopilarInfo(Scanner teclado)
    {
        System.out.println("Introduzca los datos del usuario...");
        // La siguiente línea no sería necesaria
        //String [] datosNuevos = new String [claves.size()];
        
        // El Set<String> no tiene un claves.length(), pero si un claves.size()
        // que tiene la misma utilidad
        
        // Pasamos un Set<String> a ArrayList para poder acceder a su posición i
        ArrayList<String> claves_aux = new ArrayList<String>(claves);
        
        // Generamos un JSONObject para codificar la información obtenida por consola
        JSONObject newObject = new JSONObject();
        
        // El siguiente bucle for puede recorrer todas las posiciones desde 0 a 
        // i-1, preguntando el valor a introducir en el nuevo JSON
        for (int i = 0; i< claves_aux.size(); i++)
        {
            System.out.printf("%15s: ", claves_aux.get(i));
            String valorLeido = teclado.nextLine();
            
            // El siguiente if permite identificar si el dato es numérico o no. En caso
            // afirmativo lo codifica como formato Long
            if (valorLeido.matches("-?\\d+"))
            {
                // Identifica dato numérico y lo codifica como Long
                newObject.put(claves_aux.get(i), Long.parseLong(valorLeido));
            } else {
                // La info no es dato numérico y la codifica como String
                newObject.put(claves_aux.get(i), valorLeido);
            }
        }
        System.out.println();
        
        // El nuevo objeto JSON se añade al JSON Array existente para tener toda
        // la información en este objeto y poder generar un fichero nuevo desde 0.
        registros.put(newObject);
        
        // El método retorna el JSONArray con la nueva información incluída
        return registros;
    }
    // método guardarDatosEnFichero
    public static void guardarDatosEnFichero(JSONArray resultante, String fullName)
    {
        PrintWriter pw = null;
        try{
            // Generamos el objeto FileWriter con el fullName recibido como argumento
            // NO SE AÑADE INFORMACIÓN AL FINAL DEL FICHERO, SINO QUE SE GENERA UN NUEVO
            // FICHERO Y SE INTRODUCE TODA LA INFORMACIÓN DESDE 0
            pw = new PrintWriter (new FileWriter(fullName));
            
            // La información de resultante se pasa a String para poder añadirla al fichero
            // y en formato Pretty-Printed con una identación de 2 puntos.
            pw.println(resultante.toString(2));
            
            System.out.println("Registro añadido correctamente al fichero");

        } catch (IOException e) {
            System.out.println("Error: " + e);
        } catch (Exception e) {
            System.out.println("Error genérico: " + e);
        } finally {
            if (pw != null) pw.close();
        }
    }
    
    
    
    
    public static void main(String[] args) {
        // Primero vamos a tomar el nombre del fichero en una variable que contiene el path relativo
        // desde el directorio del proyecto Java
        String fileName = "usuarios.json";
        String path = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\IO\\texto\\EjercicioJSONLibreria";
        String fullName = path + "\\" + fileName;
        
        Scanner teclado = new Scanner (System.in);
        
        // Paso 1 - Leemos el fichero con la librería org.json
        leerFichero(fullName);
        
        // Paso 2 - Añadir información al JSON y guardarlo en el fichero .json
        boolean aux = true;
        
        do {
            System.out.print("¿Desea anadir nueva informacion? (s/n): ");
            String respuesta = teclado.nextLine();

            if (respuesta.equalsIgnoreCase("s")) {
            // if (respuesta.equals("s") || respuesta.equals("S")) { // equivalente a la de arriba
                System.out.println("-- Introduce los datos del nuevo usuario --");
                JSONArray resultante = recopilarInfo(teclado);
                guardarDatosEnFichero(resultante, fullName);
            } else {
                aux = false;
            }
            leerFichero(fullName);
        } while (aux);
    }
}
