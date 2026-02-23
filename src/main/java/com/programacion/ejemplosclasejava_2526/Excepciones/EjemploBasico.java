/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Excepciones;

/**
 *
 * @author josem
 */
public class EjemploBasico {
    public static void main(String args[]) {
        try {
            int resultado = 3 / 0; // Provoca ArithmeticException
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: No se puede dividir por cero.");
            System.out.println(e);
        }
    }
}