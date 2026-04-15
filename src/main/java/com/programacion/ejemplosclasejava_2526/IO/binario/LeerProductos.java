/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.IO.binario;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author josem
 */
public class LeerProductos {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = null;
        String path = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\IO\\binario\\";
        
        try {
            in = new ObjectInputStream(new FileInputStream(path+"lista_productos.dat"));
            
            while (true)
            {
                Producto e = (Producto) in.readObject();
                System.out.println(e);
            }
        } catch (EOFException e) {
            System.out.println("Fin del fichero");
        } catch (FileNotFoundException e) {
            System.out.println("El fichero que pretende leer no existe en el directorio especificado");
        } finally {
            if (in != null)
            {
                in.close();
            }
        }
    }
}
