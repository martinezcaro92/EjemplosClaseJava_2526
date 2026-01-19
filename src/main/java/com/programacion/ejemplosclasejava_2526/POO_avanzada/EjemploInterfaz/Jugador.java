/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada.EjemploInterfaz;

/**
 *
 * @author josem
 */
public class Jugador implements IJugador, IPersona{
    private int dorsal;
    private String nombre;
    private String direccion;
    
    public Jugador (int dorsal, String nombre, String direccion)
    {
        this.dorsal = dorsal;
        this.nombre = nombre;
        this.direccion = direccion;
    }
    
    public void marcaGol()
    {
        System.out.println("¡Gooooool!");
    }
    public void esSustituido()
    {
        System.out.println("El jugador " + nombre + " ha sido sustituido");
    }
    public int getDorsal()
    {
        return dorsal;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    public String getDireccion()
    {
        return direccion;
    }
    public void imprimeNombre()
    {
        System.out.println("El nombre del jugador es " + nombre);
    }
    
    public void imprimePeso()
    {
        System.out.println("El peso del jugador es " + peso);
    }
    
    public static void main(String[] args) {
        Jugador j1 = new Jugador (10, "Kilian", "C/ Su casa");
        Jugador j2 = new Jugador (2, "Cubarsí", "C/ Catalana");
        
        
        j1.imprimePeso();
        j2.imprimeNombre();
    }
}
