/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada.HerenciaEjercicio1;

/**
 *
 * @author josem
 */
public class Contable extends Empleado {
    private double plusSalario = 200;
    
    public Contable ()
    {
        super();
    }
    public Contable (String dni, String nombre, double horasExtra)
    {
        super(dni, nombre, horasExtra);
    }
    public Contable (String dni, String nombre)
    {
        super(dni, nombre);
        //super(dni, nombre, 0); // En este caso, este constructor es equivalente al anterior
    }
    
    public void contabilizar()
    {
        System.out.println("Estoy contabilizando...");
    }
    
    public double calcularSueldo()
    {
        //return super.getSalarioBase() + plusSalario + (super.getHorasExtra() * super.getPrecioHoraExtra());
        //Otra forma equivalente de calcular sueldo es:
        return super.calcularSueldo() + plusSalario;
    }
}
