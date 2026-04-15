/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.IO.binario;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


/**
 *
 * @author josem
 */
public class LecturaDatosPrimitivos {
    public static void main(String[] args) throws IOException {
        int i;
        boolean b;
        double d;
        ObjectInputStream in = null;
        String path = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\IO\\binario\\";

        try {
            // abre los streams iniciador y filtro
            in = new ObjectInputStream(new FileInputStream(path + "fich.dat"));
            // lee los datos
            i = in.readInt(); // Debe leer el valor 65
            b = in.readBoolean(); // Debe leer valor true
            d = in.readDouble(); // Debe leer valor 2.0
        } finally {
            if (in != null) {
                in.close(); // cierra los streams
            }
        }
        
        // Imprimimos los valores leídos del fichero fich.dat para verificar que 
        // los datos obtenidos son correctos
        
        System.out.println("i: " + i);
        System.out.println("b: " + b);
        System.out.println("d: " + d);
    }
}
