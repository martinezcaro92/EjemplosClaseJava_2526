/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Excepciones.EjercicioValidadorUsuarios;

/**
 *
 * @author josem
 */
public class Empleado extends Usuario {
    private String empresa;
    private int nuss;
    private Fecha fecha;

    public Empleado(String empresa, int nuss, int fecha, String nombre, int edad, String email) {
        
        super(nombre, edad, email);
        
        if (empresa.length()<5) throw new IllegalArgumentException("El nombre de la empresa debe tener al menos 5 caracteres");
        if (nuss<1000 || nuss > 1000000) throw new IllegalArgumentException("El NUSS debe estar comprendido entre 1000 y 1000000");
        String empresaMinuscula = empresa.toLowerCase();
        if (!email.contains("@"+empresaMinuscula+".es") || !email.contains("@"+empresaMinuscula+".com")) throw new IllegalArgumentException("El correo debe contener el dominio de la empresa (.es o .com)");
        
        this.empresa = empresa;
        this.nuss = nuss;
        this.fecha = fecha;
    }
    
    
}
