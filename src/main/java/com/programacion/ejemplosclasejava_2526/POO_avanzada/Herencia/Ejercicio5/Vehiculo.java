/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada.Herencia.Ejercicio5;

/**
 *
 * @author josem
 */
public abstract class Vehiculo {
    private String matricula;
    private String marca_modelo;
    protected int km_motor;
    protected int km_aceite;
    protected int km_ruedas;
    
    public Vehiculo (String matri, String mar_modo)
    {
        this.matricula = matri;
        this.marca_modelo = mar_modo;
        this.km_motor = 0;
        this.km_aceite = 0;
        this.km_ruedas = 0;
    }
    public Vehiculo (String matri, String mar_modo, int km_m)
    {
        this.matricula = matri;
        this.marca_modelo = mar_modo;
        this.km_motor = km_m;
        this.km_aceite = 0;
        this.km_ruedas = 0;
    }
      
    
    public void avanzar(int km)
    {
        this.km_motor += km;
    }
    
    public String toString()
    {
        return  "matricula=" + matricula +
                ", marca_modelo="+marca_modelo +
                ", km_motor="+km_motor +
                ", km_aceite="+km_aceite +
                ", km_ruedas="+km_ruedas;
    }
    
    public abstract boolean checkAceite();
    public abstract boolean checkRuedas();
    
}
