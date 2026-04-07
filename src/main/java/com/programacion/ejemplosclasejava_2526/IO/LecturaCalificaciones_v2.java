/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.IO;

import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LecturaCalificaciones_v2 {
    public static void main(String[] args) {
        
        // Declara los objetos necesarios para la lectura
        String path = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\IO\\";
        FileReader fr = null;
        Scanner scan = null;
        try {
            // Inicializa objetos
            fr = new FileReader (path+"informe_calificaciones.txt");
            scan = new Scanner(fr);
            
            // Las variables aux y counter son variables auxiliares para contar líneas o
            // almacenar la información de las diferentes líneas leídas.
            String aux;
            int counter = 0;
            
            System.out.printf("%-25s %s%n", "Nombre", "nota");
            // El bucle while permitirá ver si hay más líneas
            while(scan.hasNextLine()){
                counter++;
                // La siguiente línea es la que cambia el puntero/cursor a la siguiente línea
                // (no lo hace la llamada al método hasNextLine())
                aux = scan.nextLine();
                // El método split divide la información en un array poniendo en la primera posición la
                // información que hay a la izquierda de :, y en la segunda posición la 
                // información que hay a la derecha de :
                String [] aux2 = aux.split(":");
                //Es una buena práctica hacer uso de .trim() para evitar espacios antes y después 
                // del dato que se desea codificar
                String nombre = aux2[0].trim();
                // Se hace el casting utilizando la clase del tipo de datos y el método correspondiente
                double nota = Double.parseDouble(aux2[1].trim());
                
                // Se imprime el dato leído
                System.out.printf("%-25s %4.2f%n", nombre, nota);
            }
        
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Cerrar los recursos
            if (scan != null) {
                scan.close();
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar el archivo: " + e.getMessage());
                }
            }
        }

        // Mensaje de confirmación
        System.out.println("Lectura realizada correctamente");
    }
}