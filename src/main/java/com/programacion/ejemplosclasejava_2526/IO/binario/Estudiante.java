/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.IO.binario;

import java.io.Serializable;

/**
 *
 * @author josem
 */
public class Estudiante implements Serializable {
    private String nombre;
    private int edad;
    private double notaMedia;

    // Esta clase estudiante permitirá instanciar objetos de tipo estudiantes
    // según se ha definido en esta clase. Los objetos Estudiante serán guardados
    // en fichero binario en la clase GuardarEstudiantes.java
    
    public Estudiante(String nombre, int edad, double notaMedia) {
        this.nombre = nombre;
        if(edad <0)
        {
            this.edad = 0;
        }
        else{
            this.edad = edad;
        }
        
        if (notaMedia <0 || notaMedia >10){
            this.notaMedia=0;
        }
        else{
            this.notaMedia = notaMedia;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if(edad <0) this.edad = 0;
        else this.edad = edad;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        if (notaMedia < 0 || notaMedia > 10) {
            this.notaMedia = 0;
        } else {
            this.notaMedia = notaMedia;
        }
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", edad=" + edad + ", notaMedia=" + notaMedia + '}';
    }
    
    
}
