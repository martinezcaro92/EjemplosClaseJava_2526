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
        File nomFich = new File("prueba.csv");
        String [] estudiantes = {"Diego", "Guerrero", "Alexander", "Paola", "Penarrieta",
                                "Aymen", "Josue", "Antonio David", "Adrian", "Pablo",
                                "Miguel", "Pedro Javier"};
        //System.out.println(estudiantes);
        // Abre el fichero (crea los streams y los conecta)
        out = new PrintWriter(new FileWriter(nomFich));
        try {
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
