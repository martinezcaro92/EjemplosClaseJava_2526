/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Excepciones.EjercicioTipoExamen;

/**
 *
 * @author josem
 */
public class Video extends Recurso implements IEvaluable{
    private int duracion;
    private String formato;
    private double evaluacion;

    public Video(int id, String titulo, boolean evaluado, int duracion, String formato) {
        super(id, titulo, evaluado);
        this.duracion = duracion;
        this.formato = formato;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    @Override
    public String toString() {
        return "Video{" + 
               "id="+super.getId() +
               ", titulo=" + super.getTitulo() + 
               ", evaluado=" + super.isEvaluado() + 
               ", evaluacion=" + evaluacion + 
               ", duracion=" + duracion + 
               ", formato=" + formato + '}';
    }

    @Override
    public void abrir(Usuario u) {
        if (formato !=".avi" || formato !=".mkv")
        {
            throw new FormatoNoValidoException("El formato del Video no es valido");
        }
        System.out.println("El video ha sido abierto");
    }  

    @Override
    public void evaluar(double evaluacion) {
        if (evaluacion<1 || evaluacion>10) 
            throw new EvaluacionFueraDeRangoException("El valor "+evaluacion+" no se encuentra en el rango valido");
        if (super.isEvaluado())
            throw new RecursoYaEvaluadoException("El recurso ya ha sido evaluado");
            
        this.evaluacion = evaluacion;
        super.setEvaluado(true);
    }

    @Override
    public double obtenerEvaluacion() {
        return evaluacion;
    }
}
