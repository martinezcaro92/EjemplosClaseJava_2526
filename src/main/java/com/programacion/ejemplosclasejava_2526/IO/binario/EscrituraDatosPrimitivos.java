/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.IO.binario;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author josem
 */
public class EscrituraDatosPrimitivos {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream sal = null;
        String path = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\IO\\binario\\";
        try {
            // abre los streams iniciador y filtro
            sal = new ObjectOutputStream(new FileOutputStream(path + "fich.dat"));

            // escribe varios datos
            sal.writeInt(65);
            sal.writeBoolean(true);
            sal.writeDouble(2.0);
        } catch (IOException e){
            System.out.println("Error: " +e);
        } catch (Exception e){
            System.out.println("Error: " +e);
        } finally {
            if (sal != null) {
                sal.close(); // cierra los streams
            }
        }
    }
}
