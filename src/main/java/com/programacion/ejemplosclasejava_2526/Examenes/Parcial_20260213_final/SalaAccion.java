/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Examenes.Parcial_20260213_final;

public class SalaAccion extends SalaCine {

    private boolean sonidoEspecial;
    private boolean efectoAgua;
    private boolean ventiladores;

    public SalaAccion(int numSala, int filas, int columnas, boolean sonidoEspecial, boolean efectoAgua, boolean ventiladores) {
        super(numSala, filas, columnas);
        this.sonidoEspecial = sonidoEspecial;
        this.efectoAgua = efectoAgua;
        this.ventiladores = ventiladores;
        super.categoria = "Accion";
    }

    // Implementación de reservar asiento para sala de Accion
    public void reservarAsiento(int fila, int butaca, Persona persona) {
        if (persona.getEdad() < 18) {
            System.out.println("Solo los mayores de edad pueden reservar en esta sala.");
        } else {
            asientos[fila - 1][butaca - 1] = true;
            System.out.println("Asiento[" + fila + "," + (butaca) + "] reservado para " + persona.getNombreCompleto());
        }
    }

    // Implementación de liberar asiento para sala de Accion
    public void liberarAsiento(int fila, int butaca) {
        if (asientos[fila - 1][butaca - 1]) {
            asientos[fila - 1][butaca - 1] = false;
            System.out.println("Butaca liberada correctamente.");
        } else {
            System.out.println("La butaca ya está libre.");
        }
    }
}

