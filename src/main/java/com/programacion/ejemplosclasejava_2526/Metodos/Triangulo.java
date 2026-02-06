/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Metodos;

/**
 *
 * @author josem
 */
public class Triangulo {

    static int base = 9;
    static double altura = 5;
    
    static double pi = 3.14159;
    
    private static double area (int base, double altura)
    {
        return (base*altura)/2;
    }
    public static void main(String[] args) {
        System.out.println("El triangulo con: ");
        System.out.println("     base=" + base);
        System.out.println("     altura=" + altura);
        System.out.println("El area del triangulo=" + area(base, altura));
        
        System.out.println("");
        int aux = (int) pi;
    }
    
}
