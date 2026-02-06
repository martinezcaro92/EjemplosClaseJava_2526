/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada.Herencia.Ejercicio5;

/**
 *
 * @author josem
 */
public class Turismo extends Vehiculo{
    
    public Turismo (String matri, String mar_modo)
    {
        super(matri, mar_modo);
    }
    public Turismo (String matri, String mar_modo, int km_m)
    {
        super(matri, mar_modo, km_m);
    }
    
    public boolean checkAceite()
    {
        if(km_aceite >= 15000)
        {
            km_aceite = 0;
            return true;
        }
        return false;
    }
    
    public boolean checkRuedas()
    {
        if(km_ruedas >= 30000)
        {
            km_ruedas = 0;
            return true;
        }
        return false;
    }
}
