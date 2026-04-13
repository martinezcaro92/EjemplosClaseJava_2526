/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Examenes.Recuperacion2T;

/**
 *
 * @author josem
 */
public class Plato {
    private String nombre;
    private double precio;

    public Plato(String nombre, double precio) {
        if (nombre==null || nombre.trim().isEmpty()) throw new DatosNoValidosException("El nombre del plato no puede estar vacío");
        if (precio <0) throw new DatosNoValidosException("El precio del plato no puede ser menor que 0");
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosNoValidosException("El nombre del plato no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        if (precio < 0) {
            throw new DatosNoValidosException("El precio del plato no puede ser menor que 0");
        }

        this.precio = precio;
    }

    @Override
    public String toString() {
        return "\n        Plato{" + "nombre=" + nombre + ", precio=" + precio + '}';
    }
    
    
}
