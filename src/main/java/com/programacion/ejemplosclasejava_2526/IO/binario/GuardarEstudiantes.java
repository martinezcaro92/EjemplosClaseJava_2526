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
public class GuardarEstudiantes {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ObjectOutputStream out = null;
        String path = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\IO\\binario\\";
        
        try {
            // Aquí se crea la estructura para definir un fichero binario en el path con un nombre dado
            out = new ObjectOutputStream(new FileOutputStream(path + "lista_estudiantes.dat"));
            
            // Se instancian 3 estudiantes según las indicaciones dadas en el aula
            Estudiante e1 = new Estudiante("Pepa Ortiz", 40, 9.8);
            Estudiante e2 = new Estudiante("Dario Munoz", 27, 8.1);
            Estudiante e3 = new Estudiante("Jose Manuel Martinez", 19, 4);
            
            // A partir de la funcion writeObject se escribirán estos objetos de tipo Estudiante
            // dentro del fichero binario
            out.writeObject(e1);
            out.writeObject(e2);
            out.writeObject(e3);         
            
        } finally {
            if (out != null)
            {
                out.close();
            }
            System.out.println("Fin del proceso");
        }
    }
}
