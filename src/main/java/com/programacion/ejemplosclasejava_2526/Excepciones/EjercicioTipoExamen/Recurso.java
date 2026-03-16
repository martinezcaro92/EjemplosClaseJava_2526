/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Excepciones.EjercicioTipoExamen;

/**
 *
 * @author josem
 */
public abstract class Recurso {
    private int id;
    private String titulo;
    private boolean evaluado;
    
    public Recurso(int id, String titulo, boolean evaluado) {
        this.id = id;
        this.titulo = titulo;
        this.evaluado = evaluado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isEvaluado() {
        return evaluado;
    }

    public void setEvaluado(boolean evaluado) {
        this.evaluado = evaluado;
    }

    @Override
    public String toString() {
        return "id=" + id + ", titulo=" + titulo + ", evaluado=" + evaluado;
    }
    
    public abstract void abrir(Usuario u);
}
