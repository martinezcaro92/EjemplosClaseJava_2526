/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Examenes.Recuperacion2T;

/**
 *
 * @author josem
 */
public class Persona {
    private String nombre;

    public Persona(String nombre) {
        if(nombre==null || nombre.trim().isEmpty()) throw new DatosNoValidosException("El nombre no puede ser nulo o vacio");
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre==null || nombre.trim().isEmpty()) throw new DatosNoValidosException("El nombre no puede ser nulo o vacio");
        this.nombre = nombre;
    }
}
