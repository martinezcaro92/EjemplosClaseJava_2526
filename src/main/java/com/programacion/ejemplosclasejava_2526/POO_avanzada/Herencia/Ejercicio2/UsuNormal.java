/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada.Herencia.Ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author josem
 */
public class UsuNormal {
    // Definición de atributos
    private String nombre;
    private String password;
    private String email;
    
    //Definición de constructores
    //Constructor vacío
    public UsuNormal () {}
    
    // Constructor completo
    public UsuNormal (String nombre, String password, String email)
    {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
    }
            
    //Definición de getters y setters
    public String getNombre() {return nombre;}
    public void setNombre (String nombre) {this.nombre=nombre;}
    
    public String getPassword() {return this.password;}
    public void setPassword (String password) {this.password=password;}
    
    public String getEmail(){return this.email;}
    public void setEmail(String email) {this.email=email;}
    
    //Definición de métodos específicos
    public void cambiarPassword()
    {
        Scanner scan = new Scanner (System.in);
        System.out.print("Introduzca nueva contraseña (UsuNormal): ");
        String aux = scan.nextLine();
        setPassword(aux);
    }
    
    public void listarUsuarios(ArrayList<UsuNormal> usuarios)
    {
        System.out.println("        LISTA DE USUARIOS        ");
        System.out.println("=================================");
        for(UsuNormal user : usuarios)
        {
            if (user instanceof UsuAdmin)
            {
                System.out.println("A    " + user.getNombre() + " ******** " + user.getEmail());
            }
            else {
                System.out.println("     " + user.getNombre() + " ******** " + user.getEmail());
            }
        }
        System.out.println("");
    }
    
    public String toString()
    {
        return "nombre: " + this.nombre + ", password: " + this.password + 
                ", email: " + this.email;
    }
    
}
