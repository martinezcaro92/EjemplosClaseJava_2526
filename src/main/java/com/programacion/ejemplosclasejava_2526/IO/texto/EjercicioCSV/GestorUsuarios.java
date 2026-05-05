/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.IO.texto.EjercicioCSV;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.FileNameMap;
import java.util.Scanner;

/**
 *
 * @author josem
 */
public class GestorUsuarios {
    // método leerFichero
    private static String [] cabeceras;
    public static void leerFichero(String fullName)
    {
        // Este try contempla sólo la lectura del fichero pasado como argumento
        try {
            //Toma todo el fichero tras leerlo
            Scanner scan = new Scanner(new FileReader(fullName));
            
            // Toma la primera fila (cabecera), que es especial en todo el fichero
            String cabecera = scan.nextLine();
            //System.out.println(cabecera);
            
            //Separa los diferentes campos de la cabecera, poniendo cada uno en 
            // una posición del array generado
            String [] camposCabecera = cabecera.split(";");
            cabeceras = camposCabecera;
            
            // Imprimir la cabecera de la tabla de forma formateada. Todo se realiza
            // de forma dinámica sin incluir manualmente ninguna información
            System.out.println("=============================================================================================");
            for (String campo: camposCabecera)
            {
                System.out.printf("%-15s", campo);
            }
            System.out.println(); // Salto de línea al acabar el bucle for
            System.out.println("=============================================================================================");

            // Esta variable permitirá contar el número de usuarios en el fichero
            int numUsers = 0;
            
            // Mientras que existan líneas para leer, se meterá dentro del bucle while
            while (scan.hasNextLine())
            {
                // Para cada línea de datos de usuarios, se lee la linea y se separan
                // los datos en diferentes posiciones en un array
                String linea = scan.nextLine();
                String [] camposUsuarios = linea.split(";"); 
                
                for (String campo: camposUsuarios)
                {
                    System.out.printf("%-15s", campo);
                }
                numUsers++;
                System.out.println();
            }
            System.out.println("=============================================================================================");
            System.out.println("Total de registros leidos: " + numUsers);
            

        } catch (FileNotFoundException e){
            System.out.println("Error: " + e);
        } catch (IOException e){
            System.out.println("Error: " + e);
        } catch (Exception e) {
            System.out.println("Error genérico: " + e);
        }
        
        // Ahora vamos a leer la primera línea del fichero CSV
        
        
    }
    // método pedirDatosUsuario
    public static String pedirDatosUsuario(Scanner teclado)
    {
        System.out.println("Introduzca los datos del usuario...");
        String [] datosNuevos = new String [cabeceras.length];
        
        for (int i = 0; i< datosNuevos.length; i++)
        {
            System.out.printf("%15s: ", cabeceras[i]);
            datosNuevos[i] = teclado.nextLine();
        }
        
        String resultante = "";
        for (String nuevo : datosNuevos)
        {
            resultante = resultante + nuevo + ";";
        }
        resultante = resultante.substring(0,resultante.length()-1);
        return resultante;
    }
    // método guardarFichero
    public static void guardarFichero(String resultante, String fullName)
    {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(fullName, true));
            pw.println(resultante);
            System.out.println("El usuario se ha añadido correctamente");
        } catch (IOException e){
            System.out.println("Error: " + e);
        } catch (Exception e) {
            System.out.println("Error genérico: " + e);
        } finally {
            if (pw != null) pw.close();
        }     
    }
    
    public static void main(String[] args) {
        // Primero vamos a tomar el nombre del fichero en una variable que contiene el path relativo
        // desde el directorio del proyecto Java
        String fileName = "username-password-recovery-code.csv";
        String path = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\IO\\texto\\EjercicioCSV";
        String fullName = path + "\\" + fileName;
        
        // Etapa 1: Leer fichero pasado como argumento en el método
        leerFichero(fullName);
        
        System.out.println();
        
        // Etapa 2: Añadir datos de usuario (si precisa) y guardar en CSV
        Scanner teclado = new Scanner (System.in);
        
        System.out.print("¿Desea anadir nueva informacion? (s/n): ");
        String respuesta = teclado.nextLine();
        
        if (respuesta.equalsIgnoreCase("s")) {
        // if (respuesta.equals("s") || respuesta.equals("S")) { // equivalente a la de arriba
            System.out.println("-- Introduce los datos del nuevo usuario --");
            String resultante = pedirDatosUsuario(teclado);
            guardarFichero(resultante, fullName);
        }
        teclado.close();
    }   
}
