/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Examenes.Parcial_20260213_final;

public class Pelicula implements Comparable<Pelicula> {

    private static int contadorId = 1;  // Generación automática del ID
    private int id;
    private String titulo;
    private int anio;
    private String director;
    private boolean asignada;
    private String categoria;

    // Constructor
    public Pelicula(String titulo, int anio, String director, String categoria) {
        this.id = contadorId++;
        this.titulo = titulo;
        this.anio = anio;
        this.director = director;
        this.asignada = false;  // Al principio no está asignada a ninguna sala
        this.categoria = categoria;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnio() {
        return anio;
    }

    public String getDirector() {
        return director;
    }

    public boolean isAsignada() {
        return asignada;
    }

    public void setAsignada(boolean asignada) {
        this.asignada = asignada;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    // Implementación del método toString
    @Override
    public String toString() {
        return "id:" + id + " - Titulo: " + titulo + " (" + anio + ") - Director: " + director + " - CategoríaPelicula: " + categoria;
    }

    // Implementación de Comparable para ordenar por año y título
    @Override
    public int compareTo(Pelicula otraPelicula) {
        int comparacionAnio = Integer.compare(this.anio, otraPelicula.anio);
        if (comparacionAnio == 0) {
            return this.titulo.compareTo(otraPelicula.titulo);
        }
        return comparacionAnio;
    }
}
