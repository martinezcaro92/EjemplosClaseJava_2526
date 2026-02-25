/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Excepciones;

/**
 *
 * @author josem
 */
class NumberRangeException extends Exception {
    public NumberRangeException() {
        super("Ingresar número entre 20 y 100");
    }
}

public class TestRango {
    public static void main(String args[]) {
        try {
            int x = 10;
            if (x < 20 || x > 100) throw new NumberRangeException();
        } catch (NumberRangeException e) {
            System.out.println(e);
        }
    }
}