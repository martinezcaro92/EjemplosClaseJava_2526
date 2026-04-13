/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author josem
 */
public class LecturaPorTipo_v3 {
    private static void muestraContenidoFich(String nomFich) throws FileNotFoundException {
        Scanner in = null;
        try {
            // abre el fichero
            in = new Scanner(new FileReader(nomFich));
            // configura el formato de números
            in.useLocale(Locale.ENGLISH);
            // lee el fichero palabra a palabra
            while (in.hasNext()) {
                // Verificamos si el dato es de tipo double
                if(in.hasNextInt()){
                    int i = in.nextInt();
                    System.out.println("Numero entero: " + i);
                }
                // Verificamos si el dato es de tipo entero (int)
                else if(in.hasNextDouble()) { 
                    double d = in.nextDouble(); //guardamos el dato e imprimimos
                    System.out.println("Numero decimal: " + d);
                }
                // Verificamos si el dato es de tipo String
                else {
                    String p = in.next();
                    System.out.println("Palabra: " + p);
                }
            } // while (in.hasNext())
        } finally {
            if (in != null){
                in.close();
            }
        } // finally
    } // método
    
    public static void main(String[] args) {
        String path = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\IO\\";
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
