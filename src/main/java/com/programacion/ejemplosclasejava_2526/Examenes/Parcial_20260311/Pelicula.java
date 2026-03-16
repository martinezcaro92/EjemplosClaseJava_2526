/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Examenes.Parcial_20260311;

/**
 *
 * @author josem
 */
public class Pelicula extends Contenido implements IValorable, IDescargable{
    private final int maxDescargas = 3;
    
    private boolean disponible;
    private int descargasRealizadas;
    private double puntuacionTotal;
    private int numeroValoraciones;

    public Pelicula(int id, String titulo, int duracionMin, boolean disponible) {
        super(id, titulo, duracionMin);
        this.disponible = disponible;
        this.descargasRealizadas = 0;
        this.puntuacionTotal = 0;
        this.numeroValoraciones = 0;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getDescargasRealizadas() {
        return descargasRealizadas;
    }

    public double getPuntuacionTotal() {
        return puntuacionTotal;
    }

    public int getNumeroValoraciones() {
        return numeroValoraciones;
    }


    @Override
    public String toString() {
        return "Pelicula{" + 
                "id=" + super.getId() + 
                ", titulo=" + super.getTitulo() + 
                ", duracion=" + super.getDuracionMin() + 
                ", disponible=" + disponible + 
                ", descargasRealizadas=" + descargasRealizadas +
                ", valoracionMedia" + obtenerValoracionMedia() +'}';
    }

    @Override
    public void reproducir() {
        if (disponible == false) throw new ContenidoNoDisponibleException("La pelicula " + super.getTitulo() + " no esta disponible");
        //if (!disponible) es equivalente a la anterior
        System.out.println("La reproducción se ha iniciado correctamente (" + super.getTitulo() + ")");
    }

    @Override
    public void valorar(int puntuacion) {
        if (puntuacion <1 || puntuacion >10) throw new ValoracionFueraDeRangoException("La valoración incluida está fuera de rango");
        puntuacionTotal += puntuacion;
        numeroValoraciones +=1;
    }

    @Override
    public double obtenerValoracionMedia() {
        if(numeroValoraciones==0) return 0.0;
        //ambas soluciones son equivalentes
        //if(numeroValoraciones==0) throw new ArithmeticException("No se puede dividir entre 0");
        return (double) puntuacionTotal/numeroValoraciones;
    }

    @Override
    public void descargar() {
        if (disponible == false) throw new ContenidoNoDisponibleException("La pelicula " + super.getTitulo() + " no esta disponible");
        if (descargasRealizadas >=3) throw new LimiteDescargasException("Limite de descargas para la película " + super.getTitulo());
        descargasRealizadas++;
        System.out.println("Descarga realizada ("+descargasRealizadas+"/"+maxDescargas+"): ("+super.getTitulo()+")");
    }
    
}
