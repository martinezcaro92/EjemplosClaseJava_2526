/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada.EjemploPoligono;

/**
 *
 * @author josem
 */
public class Regulares extends Poligono {
    private double apotema;
    private double lado;
    
    public Regulares ()
    {
        super();
    }
    public Regulares (int numLados)
    {
        super(numLados);
        this.apotema = 0;
        this.lado = 0;
    }
    public Regulares (int numLados, double apotema, double lado){
        super(numLados);
        this.apotema = apotema;
        this.lado = lado;
    }
    
    public double getApotema ()
    {
        return apotema;
    }
    public void setApotema (double apotema)
    {
        this.apotema = apotema;
    }
    
    public double getLado()
    {
        return lado;
    }
    public void setLado(double lado)
    {
        this.lado = lado;
    }
    
    @Override
    public double perimetro()
    {
        return lado * super.getNumLados();
    }
    
    @Override
    public double area()
    {
        return (perimetro()*apotema)/2;
    }
    
}
