/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO.Polimorfismo;

/**
 *
 * @author josem
 */
public class Figura {

    public void describir ()
    {
        System.out.println("Soy una figura");
    }
    
    static void mostrar(Figura f) 
    {
        f.describir();
    }
    public static void main(String[] args) {
        
        // Ejercicio1 polimorfismo
        Figura f1 = new Cuadrado();
        Figura f2 = new Circulo();
        f1.describir();
        f2.describir();
        
//        // Ejercicio2 polimorfismo
//        Figura[] figuras = { new Cuadrado(), new Circulo(), new Cuadrado(), new Figura()};
//        for (Figura f : figuras) {
//            f.describir();
//        }

//        //Ejercicio3 polimorfismo
//        mostrar(new Cuadrado());
//        mostrar(new Circulo());


        // Casting tipo datos primitivos
        // Casting implícito (auto-casting)
        int numeroEntero = 10;
        float numeroFloat = numeroEntero;
        double numeroDouble = numeroEntero;
        
        // Casting explicito (down-casting)
        double doubleNumber = 3.14159;
        int pi = (int) doubleNumber;
        
        // Casting de objetos (variables definidas arriba)
        //Casting implícito
        //Figura f1 = new Cuadrado();
        //Figura f2 = new Circulo();
        
        //Casting explicito 
        Cuadrado c1 = (Cuadrado) f1;
        Circulo c2 = (Circulo) f2;
    }
}

class Cuadrado extends Figura {
    public void describir ()
    {
        System.out.println("Soy un Cuadrado");
    } 
}

class Circulo extends Figura {
    public void describir ()
    {
        System.out.println("Soy un Circulo");
    } 
}
