/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Examenes.Parcial_20260311;

/**
 *
 * @author josem
 */
public class Episodio {
    private String titulo;
    private int duracion;
    private boolean disponibilidad;

    public Episodio(String titulo, int duracion, boolean disponibilidad) {
        if (duracion <=0) throw new IllegalArgumentException("La duracion debe ser mayor que 0");
        if (titulo==null || titulo.isEmpty()) throw new IllegalArgumentException("El título no puede ser nulo o estar vacio");
        this.titulo = titulo;
        this.duracion = duracion;
        this.disponibilidad = disponibilidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("El título no puede ser nulo o estar vacio");
        }
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if (duracion <= 0) {
            throw new IllegalArgumentException("La duracion debe ser mayor que 0");
        }
        this.duracion = duracion;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Episodio{" + "titulo=" + titulo + ", duracion=" + duracion + ", disponibilidad=" + disponibilidad + '}';
    }
    
    
}
