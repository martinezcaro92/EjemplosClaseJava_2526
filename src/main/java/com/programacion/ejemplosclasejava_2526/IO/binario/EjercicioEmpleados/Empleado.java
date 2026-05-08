/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.IO.binario.EjercicioEmpleados;

import java.io.Serializable;

/**
 *
 * @author josem
 */
public class Empleado extends Persona implements Serializable {
    private int numEmpleado;
    private String departamento;

    public Empleado(String dni, String nombre, int numEmpleado, String departamento) {
        super(dni, nombre);
        this.numEmpleado = numEmpleado;
        this.departamento = departamento;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Empleado[" + super.toString() + "Num. Empleado=" + numEmpleado + ", Dept. =" + departamento + ']';
    }
    
    
}
