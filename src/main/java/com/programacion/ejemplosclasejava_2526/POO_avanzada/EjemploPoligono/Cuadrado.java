/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada.EjemploPoligono;

/**
 *
 * @author josem
 */
public class Cuadrado extends Regulares{
    // Al no tener ningún atributo propio, no se define en esta clase
    
    // Los dos primeros constructores serían equivalentes, pero el segundo (comentado) 
    // permite cambiar el número de lados de un cuadrado (no recomendable)
    public Cuadrado () {
        super(4);
    }

//    public Cuadrado (int numLados)
//    {
//        super(numLados);
//    }
    
    public Cuadrado (double apotema, double lado)
    {
        super (4, apotema, lado);
    }
    
    public Cuadrado (double lado)
    {
        super(4,0,lado);
    }
    
    @Override
    public double area ()
    {
        // Ambas implementaciones son correctas, pero parece que queda más claro
        // verificar la causa más específica y dejar dentro del else la causa
        // más general
        
        
//        if(super.getApotema() != 0)
//        {
//            return (super.perimetro() * super.getApotema())/2;
//        } else {
//            return Math.pow(super.getLado(), 2); 
//        }

        if(super.getApotema() == 0)
        {
            return Math.pow(super.getLado(), 2);
        } else {
            return (super.perimetro() * super.getApotema())/2;
        }
    }
    
}
