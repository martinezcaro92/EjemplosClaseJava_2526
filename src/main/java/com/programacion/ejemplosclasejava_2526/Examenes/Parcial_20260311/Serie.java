/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Examenes.Parcial_20260311;

import java.util.ArrayList;

/**
 *
 * @author josem
 */
public class Serie extends Contenido implements IValorable{
    private double puntuacionTotal;
    private int numeroValoraciones;
    
    private ArrayList<Episodio> episodios = new ArrayList<Episodio>();

    public Serie(int id, String titulo, ArrayList<Episodio> listaEpisodios) {
        super(id, titulo, calcularDuracion(listaEpisodios));
        this.puntuacionTotal = 0;
        this.numeroValoraciones = 0;
        this.episodios = listaEpisodios;
    }

    public double getPuntuacionTotal() {
        return puntuacionTotal;
    }

    public void setPuntuacionTotal(double puntuacionTotal) {
        this.puntuacionTotal = puntuacionTotal;
    }

    public int getNumeroValoraciones() {
        return numeroValoraciones;
    }

    public void setNumeroValoraciones(int numeroValoraciones) {
        this.numeroValoraciones = numeroValoraciones;
    }

    public ArrayList<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(ArrayList<Episodio> episodios) {
        this.episodios = episodios;
    }

    @Override
    public String toString() {
        return "Serie{" + 
                super.toString() + 
                ", episodios=" + episodios.size() +
                ", valoracionMedia=" + obtenerValoracionMedia()+'}';
    }
    
    public int calcularDuracion(ArrayList<Episodio> episodios)
    {
        if (episodios.isEmpty() || episodios == null) throw new IllegalArgumentException("La serie no tiene capitulos");
        int duracionTotal = 0;
        for(Episodio e: episodios)
        {
            if (e == null) throw new IllegalArgumentException("El capitulo no existe");
            duracionTotal += e.getDuracion();
        }
        return duracionTotal;
    }
    
    @Override
    public void valorar(int puntuacion) {
        if (puntuacion <1 || puntuacion >5) throw new ValoracionFueraDeRangoException("La valoración incluida está fuera de rango");
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
    public void reproducir() {
        for(Episodio e: episodios)
        {
            if (e.isDisponibilidad()==true)
            {
                System.out.println("Reproduciendo serie: "+ super.getTitulo() + 
                        " - Episodio: " + e.getTitulo());
            }
        }
    }
    
}
