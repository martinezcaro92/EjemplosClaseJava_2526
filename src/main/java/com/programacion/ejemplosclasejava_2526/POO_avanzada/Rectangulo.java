/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada;

/**
 *
 * @author josem
 */
public class Rectangulo extends Poligono {
    private double lado1;
    private double lado2;
    
    public Rectangulo()
    {
        super();
    }
    public Rectangulo (double lado1, double lado2)
    {
        super(4);
        this.lado1 = lado1;
        this.lado2 = lado2;
    }
    @Override
    public double area()
    {
        return lado1*lado2;
    }
    
    @Override
    public double perimetro()
    {
        return 2*lado1 + 2*lado2;
    }
}
