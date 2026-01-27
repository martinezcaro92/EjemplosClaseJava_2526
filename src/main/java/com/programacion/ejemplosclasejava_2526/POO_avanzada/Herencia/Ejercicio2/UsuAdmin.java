/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada.Herencia.Ejercicio2;

import java.util.ArrayList;

/**
 *
 * @author josem
 */
public class UsuAdmin extends UsuNormal{
    
    public UsuAdmin (String nombre, String password, String email)
    {
        super(nombre, password, email);
    }
    
    public void listarUsuarios(ArrayList<UsuNormal> usuarios)
    {
        System.out.println("        LISTA DE USUARIOS        ");
        System.out.println("=================================");
        for(UsuNormal user : usuarios)
        {
            if (user instanceof UsuAdmin)
            {
                System.out.println("A    " + user.getNombre() + " " + user.getPassword() + " " + user.getEmail());
            }
            else {
                System.out.println("     " + user.getNombre() + " " + user.getPassword() + " " + user.getEmail());
            }
        }
        System.out.println("");
    }
    
    public void cambiarPassword(String password)
    {
        
    }
}
