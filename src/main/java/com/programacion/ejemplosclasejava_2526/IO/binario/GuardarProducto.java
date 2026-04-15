/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.IO.binario;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author josem
 */
public class GuardarProducto {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ObjectOutputStream out = null;
        String path = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\IO\\binario\\";
        
        try {
            // Aquí se crea la estructura para definir un fichero binario en el path con un nombre dado
            out = new ObjectOutputStream(new FileOutputStream(path + "lista_productos.dat"));
            
            // Se instancian 3 estudiantes según las indicaciones dadas en el aula
            Producto p1 = new Producto("Monitor", 285.99);
            Producto p2 = new Producto("Ratón", 11.29);
            Producto p3 = new Producto("Teclado", 21.57);
            Producto p4 = new Producto("Proyector", 499.99);
            Producto p5 = new Producto("Torre", 97.54);
            
            // A partir de la funcion writeObject se escribirán estos objetos de tipo Estudiante
            // dentro del fichero binario
            out.writeObject(p1);
            out.writeObject(p2);
            out.writeObject(p3);   
            out.writeObject(p4);  
            out.writeObject(p5);  
            
        } finally {
            if (out != null)
            {
                out.close();
            }
            System.out.println("Fin del proceso");
        }
    }
}
