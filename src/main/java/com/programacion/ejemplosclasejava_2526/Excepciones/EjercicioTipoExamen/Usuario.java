/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Excepciones.EjercicioTipoExamen;

/**
 *
 * @author josem
 */
public class Usuario {
    private String nombre;
    private boolean matriculado;

    public Usuario(String nombre, boolean matriculado) {
        this.nombre = nombre;
        this.matriculado = matriculado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isMatriculado() {
        return matriculado;
    }

    public void setMatriculado(boolean matriculado) {
        this.matriculado = matriculado;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", matriculado=" + matriculado + '}';
    }
    
}
