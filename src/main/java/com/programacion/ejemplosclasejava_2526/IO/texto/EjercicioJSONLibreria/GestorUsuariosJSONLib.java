/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.IO.texto.EjercicioJSONLibreria;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author josem
 */
public class GestorUsuariosJSONLib {
    private static Set<String> nombreColumnas;
    
    // método leerFichero
    public static void leerFichero(String fullName)
    {
        try{
            // Se genera un JSON array a partir de un String para poder navegar
            // por los diferentes elementos del fichero JSON
            JSONArray registros = new JSONArray(
                new String (Files.readAllBytes(Paths.get(fullName))));
            
            // Entra en el if si el fichero está vacío y no tiene datos
            if (registros.isEmpty())
            {
                System.out.println("No se han encontrado registros");
                return;
            }
            
            // Extraemos el primer objeto para obtener los nombres de las columnas
            // Estos datos se meten en una variable tipo Set<String>
            JSONObject primerElemento = registros.getJSONObject(0);
            nombreColumnas = primerElemento.keySet();
            
            // Se comprueba si obtiene correctamente el nombre de las columnas del fichero JSON
            // System.out.println(nombreColumnas);
            
            // Se imprime la cabecera de la tabla con los datos clave
            System.out.println("=============================================================================================");
            for (String campo: nombreColumnas)
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
                for (String campo: nombreColumnas)
                {
                    String valor = registro.optString(campo);
                    System.out.printf("%-15s", valor);
                    
                }
                System.out.println();
            }
            System.out.println("=============================================================================================");

            
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        
        
    }
    
    
    // método recopilarInfo
    
    // método guardarDatosEnFichero
    
    
    
    
    
    public static void main(String[] args) {
        // Primero vamos a tomar el nombre del fichero en una variable que contiene el path relativo
        // desde el directorio del proyecto Java
        String fileName = "usuarios.json";
        String path = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\IO\\texto\\EjercicioJSONLibreria";
        String fullName = path + "\\" + fileName;
        
        leerFichero(fullName);
    }
}
