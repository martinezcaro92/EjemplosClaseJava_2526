/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Examenes.Recuperacion1T;

/**
 *
 * @author josem
 */
public class ReproductorMusica {
    private String cancionActual;
    private int volumen;
    
    public ReproductorMusica(){}
    
    public ReproductorMusica(String cancionActual, int volumen)
    {
        this.cancionActual = cancionActual;
        this.volumen = volumen;
    }
    
    public String getCancionActual ()
    {
        return cancionActual;
    }
    public void setCancionActual (String cancionActual)
    {
        this.cancionActual = cancionActual;
    }

    public int getVolumen () {
        return volumen;
    }
    
    public void setVolumen (int volumen)
    {
        this.volumen = volumen;
    }
    
    public void subirVolumen (int cantidad)
    {
        if (cantidad <=0){
            System.out.println("El valor introducido es incorrecto");
            return;
        }
        int resultado = volumen + cantidad;
        if (resultado <= 10) volumen = resultado;
    }

    public void bajarVolumen (int cantidad)
    {
        if (cantidad <=0){
            System.out.println("El valor introducido es incorrecto");
            return;
        }
        int resultado = volumen - cantidad;
        if (resultado >= 1) volumen = resultado;
    }
}

