/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Excepciones;

/**
 *
 * @author josem
 */
public class Propaga {
    static void metodoC() {
        try {
            int x = 10 / 0; // Se lanza ArithmeticException aquí
        } catch (ArithmeticException e) {
            System.out.println("Excepción capturada en metodoC (ArithmeticException)");
            System.out.println(e);
        } catch (Exception e) {
            System.out.println("Excepción capturada en metodoC (Exception)");
            System.out.println(e);
        }
    }

    static void metodoB() {
        try {
            metodoC(); // No maneja la excepción, se propaga a metodoA
        } catch (Exception e) {
            System.out.println("Excepción capturada en metodoB (Exception)");
            System.out.println(e);
        }
    }

    static void metodoA() {
        try {
            metodoB();
        } catch (Exception e) {
            System.out.println("Excepción capturada en metodoA");
        }
    }

    public static void main(String args[]) {
        metodoA();
    }
}