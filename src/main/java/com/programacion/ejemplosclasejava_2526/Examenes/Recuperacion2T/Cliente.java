/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Examenes.Recuperacion2T;

/**
 *
 * @author josem
 */
public class Cliente extends Persona{
    private String telefono, email;

    public Cliente(String nombre, String telefono, String email) {
        super(nombre);
        if (telefono == null || telefono.trim().isEmpty())throw new DatosNoValidosException("El teléfono indicado es incorrecto");
        if (email == null || email.trim().isEmpty())throw new DatosNoValidosException("El email indicado es incorrecto");
        this.telefono = telefono;
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty())throw new DatosNoValidosException("El teléfono indicado es incorrecto");
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new DatosNoValidosException("El email indicado es incorrecto");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return "\n           Cliente{" + "telefono=" + telefono + ", email=" + email + '}';
    }
    
    
    
}
