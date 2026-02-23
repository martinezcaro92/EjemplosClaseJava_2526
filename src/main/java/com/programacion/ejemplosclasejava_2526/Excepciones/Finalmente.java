/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Excepciones;

/**
 *
 * @author josem
 */
public class Finalmente {
    public static void main(String args[]) {
        try {
            System.out.println("Ejecutando lógica...");
            int dem = 10/0; // Incluso con un return, el bloque finally se ejecutará
        } catch (ArithmeticException e) {
            System.out.println("Error al dividir entre 0");
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println("Error detectado.");
            System.out.println(e.toString());
        } finally {
            System.out.println("Limpieza de recursos completada.");
        }
    }
}