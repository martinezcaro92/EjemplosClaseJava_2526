/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author josem
 */
public class TestFileWriter {
    public static void main(String[] args) throws IOException {
        PrintWriter out = null;
        // Fichero en carpeta por defecto
        //File nomFich = new File("prueba.csv");
        // Fichero en carpeta de destino con ruta estática
        //File nomFich = new File("C:\\Users\\josem\\Repositorio\\Programacion\\EjemplosClaseJava_2526\\src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\IO\\prueba.csv");
        // Fichero en carpeta de destino con ruta dinámica
        File nomFich = new File("src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\IO\\prueba.csv");
        
        // Codifica la información de los diferentes estudiantes en el aula
        String [] estudiantes = {"Diego", "Guerrero", "Alexander", "Paola", "Penarrieta",
                                "Aymen", "Josue", "Antonio David", "Adrian", "Pablo",
                                "Miguel", "Pedro Javier", "Jose Manuel"};
        //System.out.println(estudiantes);
        // Genera un nuevo fichero (crea los streams y los conecta)
        // out = new PrintWriter(new FileWriter(nomFich));
        // A partir de un fichero existente, introduce una nueva línea al final del mismo
        out = new PrintWriter(new FileWriter(nomFich, true));
        try {
            out.println();
            for (String s : estudiantes)
            {
               out.print(s+";"); 
            }
            
        } finally {
            if (out != null)
            out.close(); // cierra el fichero (cierra el stream)
        }
    }
}
