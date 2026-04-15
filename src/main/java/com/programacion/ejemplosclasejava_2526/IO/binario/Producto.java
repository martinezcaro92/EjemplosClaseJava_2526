/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.IO.binario;

import java.io.Serializable;

/**
 *
 * @author josem
 */
public class Producto implements Serializable {
    private static int contadorId = 1;
    private int id;
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.id = contadorId++;
        this.nombre = nombre;
        if(precio <0)
        {
            this.precio = 0;
        }
        else {
            this.precio = precio;
        }
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if(precio <0)
        {
            this.precio = 0;
        }
        else {
            this.precio = precio;
        }
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
    
    
}
