/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada.HerenciaEjercicio1;

/**
 *
 * @author josem
 */
public class Director extends Empleado {
    private int despacho;
    private double precioHoraExtra = 20;
    private double plusSalario = 400;
    
    public Director ()
    {
        super();
    }
    public Director (String dni, String nombre, double horasExtra, int despacho)
    {
        super(dni, nombre, horasExtra);
        this.despacho = despacho;
    }
    public Director (String dni, String nombre, int despacho)
    {
        super(dni, nombre, 0);
        //super(dni, nombre) // Esta llamada al constructor padre sería equivalente
        this.despacho = despacho;
    }
    
    public void analizar()
    {
        System.out.println("Estoy analizando muchos datos...");
    }
    
    public double calcularSueldo()
    {
        // El llamar a calcularSueldo de la clase padre no sería válido en este caso
        // porque el precio de la hora es diferente
        //return super.calcularSueldo() + plusSalario;
        return super.getSalarioBase() + plusSalario + (super.getHorasExtra() * this.precioHoraExtra);
    }
}
