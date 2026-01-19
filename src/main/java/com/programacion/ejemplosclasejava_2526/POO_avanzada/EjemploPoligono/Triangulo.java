/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada.EjemploPoligono;

/**
 *
 * @author josem
 */
public class Triangulo extends Poligono{
    private double lado1;
    private double lado2;
    private double lado3;
    
    public  Triangulo ()
    {
        super();
    }
    public Triangulo (double lado1, double lado2, double lado3)
    {
        super(3);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }
    @Override
    public double area ()
    {
        return (lado1 + lado2 + lado3)/2;
    }
    
    @Override
    public double perimetro()
    {
        return lado1 + lado2 + lado3;
    }
    
}
