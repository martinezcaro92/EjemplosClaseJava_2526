/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada.EjemploPoligono;

/**
 *
 * @author josem
 */
public abstract class Poligono {
    
    private int numLados;
    
    public Poligono (){}
    public Poligono (int numLados)
    {
        this.numLados = numLados;
    }
    
    public abstract double area();
    public abstract double perimetro();
    
    public int getNumLados()
    {
        return numLados;
    }
    public void setNumLados (int numLados)
    {
        this.numLados = numLados;
    }
}
