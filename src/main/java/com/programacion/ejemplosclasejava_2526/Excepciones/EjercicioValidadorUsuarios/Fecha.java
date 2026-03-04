/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Excepciones.EjercicioValidadorUsuarios;

/**
 *
 * @author josem
 */
public class Fecha {

    private int dia;
    private int mes;
    private int ano;
    
    public Fecha (int dia, int mes, int ano)
    {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    // Generar un método que imprima la fecha en el formato utilizado en España
    public String toString()
    {
        return dia + "/" + mes + "/" + ano;
    }
    
    // Generar un método que a partir de una Fecha establezca la diferencia de tiempo
    // en días con otra fecha pasada por argumento
    public int diferenciaDias(Fecha f)
    {
        int aux = (this.ano - f.getAno())*365 + (this.mes - f.getMes())*30 + (this.dia - f.getDia());
        if (aux < 0)
        {
            aux = aux * (-1);
        }
        return aux;
    }
    
    
    // Generar un método que a partir de una Fecha establezca la diferencia de tiempo
    // en meses con otra fecha pasada por argumento
    public int diferenciaMeses(Fecha f)
    {
        double aux = (this.ano - f.getAno())*12 + (this.mes - f.getMes()) + (this.dia - f.getDia())/30;
        if (aux < 0)
        {
            aux = aux * (-1);
        }
        return (int) aux;
    }
    
    // Generar un método que a partir de una Fecha establezca la diferencia de tiempo
    // en años con otra fecha pasada por argumento
    public int diferenciaAnos(Fecha f)
    {
        double aux = (this.ano - f.getAno()) + (this.mes - f.getMes())/12 + (this.dia - f.getDia())/365;
        if (aux < 0)
        {
            aux = aux * (-1);
        }
        return (int) aux;
    }
    
    
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
