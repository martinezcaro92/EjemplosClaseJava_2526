/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada.Herencia.Ejercicio5;

/**
 *
 * @author josem
 */
public class Camion extends Vehiculo{
    private int km_tacografo;
    
    public Camion (String matri, String mar_modo)
    {
        super(matri, mar_modo);
        this.km_tacografo = 0;
    }
    public Camion (String matri, String mar_modo, int km_m)
    {
        super(matri, mar_modo, km_m);
        this.km_tacografo = 0;
    }
    public void avanzar(int km)
    {
        super.avanzar(km);
        System.out.println("Comprobación aceite: " + checkAceite());
        System.out.println("Comprobación ruedas: " + checkRuedas());
        System.out.println("Comprobación tacografo: " + checkTacografo());     
    }
    
    public boolean checkAceite()
    {
        if(km_aceite >= 30000)
        {
            km_aceite = 0;
            return true;
        }
        return false;
    }
    public boolean checkRuedas()
    {
        if(km_ruedas >= 50000)
        {
            km_ruedas = 0;
            return true;
        }
        return false;
    }
    public boolean checkTacografo()
    {
        if(km_tacografo >= 50000)
        {
            km_tacografo = 0;
            return true;
        }
        return false;
    }
}
