/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Examenes.Recuperacion2T;

/**
 *
 * @author josem
 */
public class Camarero extends Persona {
    private static int cuentaCamareroId = 1;
    private int id;
    
    public Camarero (String nombre)
    {
        super(nombre);
        this.id = cuentaCamareroId++;
    }

    public static int getCuentaCamareroId() {
        return cuentaCamareroId;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Camarero{" + "id=" + id + ", nombre="+ super.getNombre()+"}";
    }
    
    
}
