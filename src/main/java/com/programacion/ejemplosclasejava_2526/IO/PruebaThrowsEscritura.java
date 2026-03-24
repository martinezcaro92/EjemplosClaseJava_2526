/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.IO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author josem
 */
public class PruebaThrowsEscritura {
    
    public static void ejemploEscribeFichTexto(String nomFich,
            int i, double x, String str) throws IOException {
        PrintWriter out = null;
        try {
            // Abre el fichero
            out = new PrintWriter(new FileWriter(nomFich));
            // escribe los datos en el fichero
            out.println("Entero: " + i + " Real: " + x);
            out.println("String: " + str);
        } finally {
            if (out != null) {
                out.close(); // Cierra el fichero
            }
        }
    }
    
    public static void main(String[] args) {
        String path = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\IO\\";
        try {
            ejemploEscribeFichTexto(path + "escribeNumeros.txt", 11, 22.2, "hola");
            // Es una buena práctica hacer el catch del IOException fuera porque si
            // hay un error al cerrar el fichero no se podría identificar
            
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
}
