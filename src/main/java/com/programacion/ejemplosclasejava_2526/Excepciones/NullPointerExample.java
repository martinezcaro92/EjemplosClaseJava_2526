/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Excepciones;

/**
 *
 * @author josem
 */
public class NullPointerExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Definir una variable tipo String inicializada a null.
        // Si defino la variable dentro del try, no tengo alcance en el finally
        // Por ello la pongo fuera
        String s = "Jose Manuel Martinez Caro";
        
        try {
            //Imprimir el valor de la variable String (s)
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("La variable a la que se desea acceder es null");
            System.out.println(e);
        } catch (Exception e) {
            System.out.println("Se ha producido un error");
            System.out.println(e);
        } finally {
            System.out.println("El valor de s es: " + s);
        }
        
        
        
    }
    
}
