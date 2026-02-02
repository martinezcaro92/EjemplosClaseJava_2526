/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.ArrayList.Ejercicio1Coleccion;


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
    private String nombre, dni;
    private int edad;
    
    
    // Se define un constructor vacío
    public Persona (){}
    
    // Se define un constructor completo
    public Persona (String dni, String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
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
    public int getEdad ()
    {
        return this.edad;
    }
    public void setEdad(int edad)
    {
        this.edad = edad;
    }
    public String getDni ()
    {
        return dni;
    }
    public void setDni (String dni)
    {
        this.dni = dni;
    }
    
    
    public String toString()
    {
        return "dni=" + this.dni + " - nombre=" + nombre + " - edad=" + edad;
    }
    
    public int compareTo(Persona p){
        return dni.compareTo(p.getDni());
    }
}
