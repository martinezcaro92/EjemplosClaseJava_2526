/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Excepciones.EjercicioValidadorUsuarios;

/**
 *
 * @author josem
 */
public class Usuario {
    private String nombre;
    private int edad;
    private String email;
    
    public Usuario (String nombre, int edad, String email)
    {
        if (nombre.length()<3) throw new IllegalArgumentException("El nombre del usuario debe contener al menos 3 caracteres");
        if (edad < 0 || edad >120) throw new IllegalArgumentException("La edad debe estar contemplada entre 0 y 120 anios");
        if (!email.contains("@") || !email.contains(".")) throw new IllegalArgumentException("El email no contiene los campos necesarios");
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", edad=" + edad + ", email=" + email + '}';
    }
    
    
}
