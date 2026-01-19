/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada.EjemploAnimal;

/**
 *
 * @author josem
 */
public class Perro extends Animal {
    public Perro()
    {
        super();
    }
    public Perro (String nombre)
    {
        super(nombre);
    }
    
    public void ladrar ()
    {
        System.out.println("guau, guau");
    }
}
