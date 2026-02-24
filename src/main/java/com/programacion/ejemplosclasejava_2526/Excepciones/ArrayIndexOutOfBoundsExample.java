/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Excepciones;

/**
 *
 * @author josem
 */
public class ArrayIndexOutOfBoundsExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Definir un array de 5 posiciones enteras (inicializadas al gusto) y 
        // se tratará de acceder a una posición que no está contemplada (ej. 10)
        int aux[] = {1, 2, 3, 4, 5};

        try {
            System.out.println(aux[10]);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No se puede imprimir la posicion 10 del array (ArrayIndexOutOfBoundsException)");
            System.out.println(e);
        } catch (Exception e) {
            System.out.println("No se puede imprimir la posicion 10 del array (Exception)");
            System.out.println(e);
        }
    }
    
}
