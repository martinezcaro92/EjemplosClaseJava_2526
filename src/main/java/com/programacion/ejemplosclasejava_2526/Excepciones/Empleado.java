/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Excepciones;

/**
 *
 * @author josem
 */

public class Empleado {
    public static class SueldoIncorrecto extends RuntimeException {
        public SueldoIncorrecto() { super("El sueldo no puede ser negativo"); }
    }

    public static void asignaSueldo(double sueldo) {
        if (sueldo < 0) throw new SueldoIncorrecto();
        // ... lógica de asignación
    }
    
    public static void main(String[] args) {
        try {
            asignaSueldo(-1);
        } catch (SueldoIncorrecto e) {
            System.out.println("Se ha producido un error a la hora de asignar un sueldo");
            System.out.println(e);
        }
        
    }
}
