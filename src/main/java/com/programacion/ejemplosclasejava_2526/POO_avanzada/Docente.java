/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada;

import java.util.Arrays;

/**
 *
 * @author josem
 */
public class Docente extends Persona {
    private String [] modulos;
    private int nrp;
    private String centro;
    
    // Constructor vacío
    public Docente (){
        super();
    }
    
    // Constructor completo
    public Docente (String nombre, String apellido, String dni,
                        String [] modulos, int nrp, String centro)
    {
        super (nombre, apellido, dni);
        this.modulos = modulos;
        this.nrp = nrp;
        this.centro = centro;
    }
    
    public String [] getModulos ()
    {
        return modulos;
    }
    public void setModulos(String modulos [])
    {
        this.modulos = modulos;
    }
    
    public int getNrp ()
    {
        return nrp;
    }
    public void setNrp (int nrp)
    {
        this.nrp = nrp;
    }
    
    public String getCentro()
    {
        return centro;
    }
    public void setCentro(String centro)
    {
        this.centro = centro;
    }
    
    @Override
    public String toString ()
    {
        return super.toString() + ", centro=" + this.centro + ", modulos="+ Arrays.toString(modulos) +
                ", nrp=" + this.nrp;
    }
}
