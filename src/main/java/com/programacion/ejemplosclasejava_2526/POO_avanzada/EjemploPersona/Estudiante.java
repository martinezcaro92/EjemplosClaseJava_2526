/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada.EjemploPersona;

/**
 *
 * @author josem
 */
public class Estudiante extends Persona {
    
    private String nivel, centro;
    private int curso, nre;
    
    // Constructor vacío
    public Estudiante ()
    {
        super();
    }
    
    // Constructor completo
    public Estudiante (String nombre, String apellido, String dni,
                        String nivel, int curso, int nre, String centro)
    {
        super (nombre, apellido, dni);
        this.nivel = nivel;
        this.curso = curso;
        this.nre = nre;
        this.centro = centro;
    }
    
    public String getNivel ()
    {
        return nivel;
    }
    public void setNivel (String nivel)
    {
        this.nivel = nivel;
    }
    public int getCurso ()
    {
        return curso;
    }
    public void setCurso(int curso)
    {
        this.curso = curso;
    }
    public int getNre()
    {
        return this.nre;
    }
    public void setNre(int nre)
    {
        this.nre = nre;
    }
    public String getCentro ()
    {
        return centro;
    }
    public void setCentro (String centro)
    {
        this.centro = centro;
    }
    
    @Override
    public String toString ()
    {
        return super.toString() + ", centro="+this.centro + ", curso=" + this.curso
                + ", nivel=" + this.nivel + ", nre=" + this.nre;
    }
}
