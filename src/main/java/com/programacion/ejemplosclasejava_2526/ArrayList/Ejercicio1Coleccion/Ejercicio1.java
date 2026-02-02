/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.ArrayList.Ejercicio1Coleccion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author josem
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    private static ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
    
    public static void main(String[] args) {
        int opcion;
        Scanner scan = new Scanner(System.in);
        do
        {
            System.out.println("");
            System.out.println("======== MENU ========");
            System.out.println("1. Anadir persona");
            System.out.println("2. Eliminar persona");
            System.out.println("3. Detalles de persona");
            System.out.println("4. Listar todas las personas");
            System.out.println("5. Salir");
            System.out.println("");
            System.out.print("Opcion > ");
            opcion = scan.nextInt();
            
            switch (opcion)
            {
                case 1:
                    anadirPersona();
                    break;
                
                case 2:
                    eliminarPersona();
                    break;
                    
                case 3:
                    detallePersona();
                    break;
                    
                case 4:
                    listarPersonas();
                    break;
                    
                default:
                    System.out.println("Opcion no contemplada. Vuelva a intentarlo. ");
                    break;
            }
        } while (opcion != 5);
    }
    
    public static void anadirPersona()
    {
        Scanner sc = new Scanner(System.in);

        // Solicitando datos
        System.out.print("dni Persona: ");
        String dni = sc.nextLine();  // Leer DNI

        System.out.print("nombre Persona: ");
        String nombre = sc.nextLine();  // Leer nombre

        System.out.print("edad Persona: ");
        int edad = sc.nextInt();  // Leer edad
        
        Persona p = new Persona(dni, nombre, edad);
        listaPersonas.add(p);
        
        listaPersonas.sort(Comparator.comparing(Persona::getEdad));
    }
    
    public static void eliminarPersona ()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("dni Persona (eliminar): ");
        String dni = scan.nextLine();
        
        for(Persona p : listaPersonas)
        {
            if (p.getDni().equals(dni))
            {
                listaPersonas.remove(p);
            }
        }
    }
    public static void detallePersona()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("dni Persona (detalle): ");
        String dni = scan.nextLine();
        
        for(Persona p : listaPersonas)
        {
            if (p.getDni().equals(dni))
            {
                System.out.println(p.toString());
            }
        }
    }
    public static void listarPersonas()
    {
        listaPersonas.forEach(p -> System.out.println(p.toString()));
    }
}
