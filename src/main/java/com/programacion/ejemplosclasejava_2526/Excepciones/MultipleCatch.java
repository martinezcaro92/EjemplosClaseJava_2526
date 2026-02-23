/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Excepciones;

/**
 *
 * @author josem
 */
public class MultipleCatch {
    public static void main(String args[]) {
        try {
            int den = Integer.parseInt(args[0]); // Puede lanzar ArrayIndexOutOfBoundsException o NumberFormatException
            System.out.println(10 / den);        // Puede lanzar ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Error matemático: Divisor es cero.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: No se ha proporcionado el parámetro.");
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println("Error genérico: " + e.getMessage());
        }
    }
}