/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Excepciones;

/**
 *
 * @author josem
 */
public class ArithmeticExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Declarar y definir dos variables (num y dem), donde dem tome valor 0.
        // La variable res, tomará el resto de dividir num entre dem.
        
        try {
            int num = 26;
            int dem = 0;

            int res = num % dem;
            
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error (ArithmeticException)");
            System.out.println(e);
        } catch (Exception e) {
            System.out.println("Se ha producido un error (Exception)");
            System.out.println(e);
        }
        
        System.out.println("Esto es una prueba");

    }
    
}
