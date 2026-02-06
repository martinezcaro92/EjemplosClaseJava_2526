/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada.Herencia.Ejercicio5;

import java.util.ArrayList;

/**
 *
 * @author josem
 */
public class Ejercicio05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        
        vehiculos.add(new Turismo("1111FFF", "Peugeot 308"));
        vehiculos.add(new Turismo("2222AAA", "Seat Ibiza", 10000));
        vehiculos.add(new Camion("3333GGG", "volvo 500"));
        vehiculos.add(new Camion("5555BBB", "Scania 550", 100000));
    }
    
}
