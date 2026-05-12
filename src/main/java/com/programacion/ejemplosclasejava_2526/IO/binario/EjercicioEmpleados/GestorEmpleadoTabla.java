/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.IO.binario.EjercicioEmpleados;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author josem
 */
public class GestorEmpleadoTabla {
    // Etapa 1 - Leemos los datos del fichero binario de los empleados
    public static void leerEmpleados (File archivo) throws IOException
    {
        System.out.println("--- Empleados leídos ---");
        int contador = 0;
        ObjectInputStream ois = null;
        try {
            // Se obtienen los atributos de la clase Persona
            ArrayList<String> campos2 = new ArrayList<String>();
            
            Field [] camposPadre = Empleado.class.getSuperclass().getDeclaredFields();
            for (Field cP : camposPadre)
            {
                campos2.add(cP.getName());
                System.out.println(cP.getName()); // Permite obtener el nombre del campo
            }
            
            // Se obtienen los atributos de la clase Empleado
            Field [] campos = Empleado.class.getDeclaredFields();
            for (Field campo : campos)
            {
                campos2.add(campo.getName());
                System.out.println(campo.getName()); // Permite obtener el nombre del campo
            }
            
            // La información del fichero binario "empleados.dat" se obtiene a partir
            // de las siguiente línea
            ois = new ObjectInputStream(new FileInputStream(archivo));
            while (true)
            {
                // Se realiza un casting implícito de cada objeto encontrado en el fichero
                // binario y se imprime su contenido mediante el método toString()
                Empleado emp = (Empleado) ois.readObject();

                //A partir de aquí hay que codificar la información para imprimirla en formato tabla
                

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
    
    // Método solicitar información para nuevos empleados. Nuevo método incluído
    // Para segmentar esta parte del código de forma específica. Devuelve un objeto 
    // Empleado a partir de los datos recogidos por teclado
    public static Empleado infoNuevosEmpleados (Scanner teclado)
    {
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
        
        Empleado empleado = new Empleado(dni, nombre, numEmpleado, departamento);
        return empleado;
    }
    
    
    // Método escribir empleados en el fichero binario "empleados.dat"
    public static void escribirEmpleado (File archivo, Empleado empleado) throws IOException
    {
        // Los nuevos objetos Empleados generados se añaden al final del fichero existente
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
        
        // Comprobamos si el fichero binario "empleados.dat" existe o no en la ruta
        // marcada previamente
        File archivo = new File(fullName);
        if (archivo.exists())
        {  
            // Si el fichero existe se trata de leer los objetos incluídos
            // en caso contrario se lanza un error
            try {
                leerEmpleados(archivo);
            } catch (IOException ex) {
                System.out.println("Error: " + ex);
            }
        } 
        String respuesta;
        do {
            // Se pregunta si se desea añadir un nuevo empleado. En caso de respuesta
            // Afirmativa se continua con el proceso mientras no se responda n/N
            System.out.print("¿Desea anadir otro empleado? (s/n): ");
            Scanner teclado = new Scanner(System.in);
            respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                // if (respuesta.equals("s") || respuesta.equals("S")) { // equivalente a la de arriba
                // La información del nuevo empleado se recoge en el método infoNuevosEmpleados
                // que devuelve un objeto Empleado
                Empleado empleado = infoNuevosEmpleados(teclado);

                // Si el objeto empleado se ha generado correctamente se escribe el objeto
                // al final del fichero binario
                try { 
                    escribirEmpleado(archivo, empleado);
                } catch (IOException ex) {
                    System.out.println("Error: " + ex);
                }
            } 
        } while (respuesta.equalsIgnoreCase("s"));
    }
}
