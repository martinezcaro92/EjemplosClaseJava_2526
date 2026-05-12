/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.IO.binario.EjercicioEmpleados;

import static com.programacion.ejemplosclasejava_2526.IO.texto.EjercicioCSV.GestorUsuarios.guardarFichero;
import static com.programacion.ejemplosclasejava_2526.IO.texto.EjercicioCSV.GestorUsuarios.pedirDatosUsuario;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author josem
 */
public class GestorEmpleado {
    // Etapa 1 - Leemos los datos del fichero binario de los empleados
    public static void leerEmpleados (File archivo) throws IOException
    {
        System.out.println("--- Empleados leídos ---");
        int contador = 0;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(archivo));
            while (true)
            {
                Empleado emp = (Empleado) ois.readObject();
                System.out.println(emp.toString());
                contador++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        } catch (EOFException e) {
            System.out.println("Fichero leído correctamente. Número de empleados recibidos: " + contador);
        } catch (Exception e) {
            System.out.println("Error genérico: " + e);
        } finally {
            if (ois != null) ois.close();
        }
    }
    
    // Método solicitar información para nuevos empleados
    
    // Método escribir empleados
    public static void escribirEmpleado (File archivo, Empleado empleado) throws IOException
    {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream (new FileOutputStream (archivo, true));
            oos.writeObject(empleado);
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        } finally {
            if (oos != null) oos.close();
        }
    }
    
    public static void main(String[] args) {
        // Primero vamos a tomar el nombre del fichero en una variable que contiene el path relativo
        // desde el directorio del proyecto Java
        String fileName = "empleados.dat";
        String path = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\IO\\binario\\EjercicioEmpleados";
        String fullName = path + "\\" + fileName;
        
        // Comprobamos si el fichero existe o no
        File archivo = new File(fullName);
        if (archivo.exists())
        {
            
            try {
                leerEmpleados(archivo);
            } catch (IOException ex) {
                System.out.println("Error: " + ex);
            }
        } 
        String respuesta;
        do {
            System.out.print("¿Desea anadir otro empleado? (s/n):");
            Scanner teclado = new Scanner(System.in);
            respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                // if (respuesta.equals("s") || respuesta.equals("S")) { // equivalente a la de arriba
                System.out.print("Introduce el DNI: ");
                String dni = teclado.nextLine();
                System.out.print("Introduce el Nombre: ");
                String nombre = teclado.nextLine();
                System.out.print("Introduce el Número Empleado: ");
                int numEmpleado = teclado.nextInt();
                // En el desarrollo hemos tenido un problema a la hora de tomar el 
                // departamento, y la línea siguiente lo solventa
                teclado.nextLine();

                System.out.print("Introduce el Departamento: ");
                String departamento = teclado.nextLine();
                Empleado empleado = new Empleado (dni, nombre, numEmpleado, departamento);

                try { 
                    escribirEmpleado(archivo, empleado);
                } catch (IOException ex) {
                    System.out.println("Error: " + ex);
                }
            } 
        } while (respuesta.equalsIgnoreCase("s"));
    }
}
