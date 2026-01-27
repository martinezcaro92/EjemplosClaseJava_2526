/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada.HerenciaEjercicio1;

/**
 *
 * @author josem
 */
public class Empleado {
    private String dni;
    private String nombre;
    private double salarioBase = 1000;
    private double horasExtra;
    private double precioHoraExtra = 10;
    
    public Empleado () {}
    public Empleado (String dni, String nombre, double horasExtra)
    {
        this.dni = dni;
        this.nombre = nombre;
        this.horasExtra = horasExtra;
    }
    public Empleado (String dni, String nombre)
    {
        this.dni = dni;
        this.nombre = nombre;
        this.horasExtra = 0;
    }
    
    public String getDni (){return dni;}
    public void setDni (String dni) {this.dni = dni;}
    public String getNombre () {return this.nombre; }
    public void setNombre (String nombre) {this.nombre=nombre;}
    public double getHorasExtra () {return horasExtra;}
    public void setHorasExtra(double horasExtra) {this.horasExtra = horasExtra;}
    public double getSalarioBase (){return salarioBase;}
    public double getPrecioHoraExtra () {return precioHoraExtra;}
    
    
    public String toString()
    {
        return nombre + " (DNI:" + dni + ")";
    }
    
    public double calcularSueldo ()
    {
        return salarioBase + (horasExtra * precioHoraExtra);
    }
}
