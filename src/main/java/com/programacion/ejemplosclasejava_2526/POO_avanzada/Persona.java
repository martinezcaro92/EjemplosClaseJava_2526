/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada;

/**
 *
 * @author josem
 */
public class Persona {
//    private String nombre;
//    private String apellido;
//    private String dni;

// Se puede definir una variable por línea (con todas sus características) o
// todas en la misma línea (compartiendo características)    
    private String nombre, apellido, dni;
    
    
    // Se define un constructor vacío
    public Persona (){}
    
    // Se define un constructor completo
    public Persona (String nombre, String apellido, String dni){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
    
    public String getNombre ()
    {
        return nombre;
        // es equivalente a: 
        // return this.nombre;
    }
    public void setNombre (String nombre)
    {
        this.nombre = nombre;
        // Aquí si es obligatorio el uso de this porque el nombre del atributo 
        // global es igual al nombre del atributo pasado como argumento
    }
    public String getApellido ()
    {
        return this.apellido;
    }
    public void setApellido (String apellido)
    {
        this.apellido = apellido;
    }
    public String getDni ()
    {
        return dni;
    }
    public void setDni (String dni)
    {
        this.dni = dni;
    }
    
    public String getNombreCompleto ()
    {
        // Este método queda implementado y posteriormente será sobreescrito
        return nombre + " " + apellido;
    }
    
    public String toString()
    {
        return "nombre=" + this.nombre + ", apellido=" + apellido + ", dni=" + dni;
    }
}
