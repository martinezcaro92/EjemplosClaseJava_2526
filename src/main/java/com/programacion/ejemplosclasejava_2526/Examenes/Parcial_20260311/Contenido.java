/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Examenes.Parcial_20260311;

/**
 *
 * @author josem
 */
public abstract class Contenido {
    private int id;
    private String titulo;
    private int duracionMin;

    public Contenido(int id, String titulo, int duracionMin) {
        if (id <=0) throw new IllegalArgumentException("El valor de id debe ser mayor que 0");
        if (titulo==null || titulo.isEmpty()) throw new IllegalArgumentException("El título no puede ser nulo o estar vacio");
        if (duracionMin <=0) throw new IllegalArgumentException("La duracion ddebe ser mayor que 0");
        
        this.id = id;
        this.titulo = titulo;
        this.duracionMin = duracionMin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <=0) throw new IllegalArgumentException("El valor de id debe ser mayor que 0");
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo==null || titulo.isEmpty()) throw new IllegalArgumentException("El título no puede ser nulo o estar vacio");
        this.titulo = titulo;
    }

    public int getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(int duracionMin) {
        if (duracionMin <= 0) {
            throw new IllegalArgumentException("La duracion ddebe ser mayor que 0");
        }
        this.duracionMin = duracionMin;
    }

    @Override
    public String toString() {
        return "id=" + id + ", titulo=" + titulo + ", duracionMin=" + duracionMin;
    }
    
    public abstract void reproducir();
}
