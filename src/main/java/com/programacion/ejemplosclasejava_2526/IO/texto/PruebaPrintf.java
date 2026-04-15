/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.IO.texto;

/**
 *
 * @author josem
 */
public class PruebaPrintf {
    public static void main(String[] args) {
        String str = "Hola me llamo Jose Manuel";
        double edad = 24.1111111111;
        //System.out.printf("%s - %f", str, edad); // caso más sencillo posible
        System.out.printf("%35s - %11.9f %n", str, edad); // Utilizamos 35 caracteres para el string
        System.out.printf("%-35s - %4.4f %n", str, edad); // Utilizamos 35 caracteres para el string justificado a la derecha
        System.out.printf("%-35s - %9.4f %n", str, edad); // Utilizamos 35 caracteres para el string justificado a la derecha

    }
}
