/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Excepciones;

/**
 *
 * @author josem
 */
public class NumberFormatExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Tome una varible String que esté inicializada con el valor 2 y trate
        // de realizar un casting (o parse) a tipo de dato entero.
        
        String test = "abc123";
        int aux = 0;
        try {
            aux = Integer.parseInt(test);
        } catch (NumberFormatException e) {
            System.out.println("No se puede realizar el parse de los datos (NumberFormatException)");
            System.out.println(e);
            aux = 2;
        } catch (Exception e) {
            System.out.println("No se puede realizar el parse de los datos (Exception)");
            System.out.println(e);
            aux = 4;
        } finally {
            System.out.println("El valor de aux*aux es: " + (aux*aux));
        }
        
        
        
        
        
    }
    
}
