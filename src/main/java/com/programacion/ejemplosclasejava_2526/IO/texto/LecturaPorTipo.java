/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.IO.texto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author josem
 */
public class LecturaPorTipo {
    private static void muestraContenidoFich(String nomFich) throws FileNotFoundException {
        Scanner in = null;
        try {
            // abre el fichero
            in = new Scanner(new FileReader(nomFich));
            // configura el formato de números
            in.useLocale(Locale.ENGLISH);
            // lee el fichero palabra a palabra
            while (in.hasNext()) {
                // lee primera palabra
                String palabra = in.next();
                System.out.println("Palabra:" + palabra);
                // lee los números después de la palabra
                while (in.hasNextDouble()) {
                    // lee un double
                    double d = in.nextDouble();
                    System.out.println("Número:"+d);
                }
            } // while (in.hasNext())
        } finally {
            if (in != null){
                in.close();
            }
        } // finally
    } // método
    
    public static void main(String[] args) {
        String path = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\IO\\texto\\";
        String nombreFichero = "fichero_prueba.txt";
        
        try {
            muestraContenidoFich(path+nombreFichero);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } 
    }
}
