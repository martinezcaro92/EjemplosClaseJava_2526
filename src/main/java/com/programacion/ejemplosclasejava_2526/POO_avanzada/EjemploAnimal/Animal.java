/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada.EjemploAnimal;

/**
 *
 * @author josem
 */
public class Animal {
    private String nombre;
    
    public Animal (){}
    public Animal (String nombre)
    {
        this.nombre = nombre;
    }
    
    public void comer ()
    {
        System.out.println("estoy comiendo...");
    }
    public String getNombre()
    {
        return this.nombre;
    }
}
