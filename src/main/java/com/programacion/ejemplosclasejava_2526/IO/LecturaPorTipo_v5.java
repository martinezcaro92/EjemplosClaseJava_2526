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
public class LecturaPorTipo_v5 {
    private static void muestraContenidoFich(String nomFich) throws FileNotFoundException {
        Scanner in = null;
        try {
            // abre el fichero
            in = new Scanner(new FileReader(nomFich));
            // configura el formato de números
            in.useLocale(Locale.ENGLISH);
            // lee el fichero palabra a palabra
            while (in.hasNextLine()) {
                String linea = in.nextLine();
                Scanner scLinea = new Scanner(linea);
                scLinea.useLocale(Locale.ENGLISH);

                double suma = 0;
                int contador = 0;
                String p = "";

                while(scLinea.hasNext()){

                    // Verificamos si el dato es de tipo double
                    if(scLinea.hasNextInt()){
                        int i = scLinea.nextInt();
                        suma += i;
                        contador++;
                        //System.out.println("Numero entero: " + i);
                    }
                    // Verificamos si el dato es de tipo entero (int)
                    else if(scLinea.hasNextDouble()) { 
                        double d = scLinea.nextDouble(); //guardamos el dato e imprimimos
                        suma += d;
                        contador++;
                        //System.out.println("Numero decimal: " + d);
                    }
                    // Verificamos si el dato es de tipo String
                    else {
                        p = p + " " + scLinea.next();
                        // System.out.println("Palabra: " + p);
                    }
                }
                double media = contador > 0 ? suma / contador : 0; 
                System.out.printf("%s(media): %4.2f%n", p, media);
            }    
        } finally {
            if (in != null){
                in.close();
            }
        } // finally
    } // método
    
    public static void main(String[] args) {
        String path = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\IO\\";
        String nombreFichero = "fichero_prueba_v2.txt";
        
        try {
            muestraContenidoFich(path+nombreFichero);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } 
    }
}
