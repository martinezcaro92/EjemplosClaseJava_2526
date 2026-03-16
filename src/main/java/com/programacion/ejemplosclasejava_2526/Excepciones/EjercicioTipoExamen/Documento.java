/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Excepciones.EjercicioTipoExamen;

/**
 *
 * @author josem
 */
public class Documento extends Recurso implements IEvaluable{
    private int paginas;
    private String formato;
    private double evaluacion;

    public Documento(int id, String titulo, boolean evaluado, int paginas, String formato) {
        super(id, titulo, evaluado);
        this.paginas = paginas;
        this.formato = formato;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", paginas=" + paginas + 
                ", formato=" + formato;
    }

    @Override
    public void abrir(Usuario u) {
        if (!formato.equals(".pdf") || !formato.equals(".docx") || !formato.equals(".gdoc"))
        {
            throw new FormatoNoValidoException("El Documento no incluye un formato valido");
        }
    }

    @Override
    public void evaluar(double evaluacion) {
        if (evaluacion<1 || evaluacion>100) 
            throw new EvaluacionFueraDeRangoException("El valor "+evaluacion+" no se encuentra en el rango valido");
        if (super.isEvaluado())
            throw new RecursoYaEvaluadoException("El recurso ya ha sido evaluado");
            
        this.evaluacion = evaluacion;
        super.setEvaluado(true);
    }

    @Override
    public double obtenerEvaluacion() {
        return this.evaluacion;
    }
    
    
    
}
