/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Examenes.Parcial_20260213_final;

public class SalaInfantil extends SalaCine {

    private boolean parqueDeBolas;
    private Persona[][] personasResponsables;

    public SalaInfantil(int numSala, int filas, int columnas, boolean parqueDeBolas) {
        super(numSala, filas, columnas);
        this.parqueDeBolas = parqueDeBolas;
        super.categoria = "Infantil";
        this.personasResponsables = new Persona[filas][columnas];
    }

    // Implementación de reservar asiento para sala infantil
    public void reservarAsiento(int fila, int butaca, Persona persona) {
        if (persona.getEdad() < 18) {
            System.out.println("No puedes reservar si no tienes un adulto contigo.");
        } else
        {
            if(!verificarAsientosContiguos(fila, butaca)[0] && !verificarAsientosContiguos(fila, butaca)[1]) {
                System.out.println("No hay asientos contiguos disponibles para el niño/a.");
                return;
            }
            else if (verificarAsientosContiguos(fila, butaca)[0]) {
                asientos[fila - 1][butaca - 1] = true;      // Asiento 1 reservado
                asientos[fila - 1][butaca - 2 ] = true;     // Asiento 2 reservado
                personasResponsables[fila - 1][butaca - 1] = persona; // Guardar la persona responsable en el asiento 1
                personasResponsables[fila - 1][butaca - 2] = persona; // Guardar la persona responsable en el asiento 2

                System.out.println("Asiento[" + fila + "," + (butaca) + "] reservado para " + persona.getNombreCompleto());
                System.out.println("Asiento[" + fila + "," + (butaca-1) + "] reservado para su acompañante");
                System.out.println();
            }
            else if (verificarAsientosContiguos(fila, butaca)[1]) {
                asientos[fila - 1][butaca - 1] = true;      // Asiento 1 reservado
                asientos[fila - 1][butaca] = true;          // Asiento 2 reservado
                personasResponsables[fila - 1][butaca - 1] = persona; // Guardar la persona responsable en el asiento 1
                personasResponsables[fila - 1][butaca] = persona;     // Guardar la persona responsable en el asiento 2

                System.out.println("Asiento[" + fila + "," + butaca + "] reservado para " + persona.getNombreCompleto());
                System.out.println("Asiento[" + fila + "," + (butaca+1) + "] reservado para su acompañante");
                System.out.println();
            }
        }
    }

    // Implementación de liberar asiento para sala infantil
    public void liberarAsiento(int fila, int butaca) {
        if (asientos[fila - 1][butaca - 1] && asientos[fila - 1][butaca-2] && personasResponsables[fila - 1][butaca-1].equals(personasResponsables[fila - 1][butaca-2])) {
            asientos[fila - 1][butaca - 1] = false;
            asientos[fila - 1][butaca-2] = false;
            System.out.println("Asiento[" + fila + "," + (butaca-1) + "] y Asiento[" + fila + "," + (butaca) + "] liberados.");
        }
        else if (asientos[fila - 1][butaca - 1] && asientos[fila - 1][butaca] && personasResponsables[fila - 1][butaca-1].equals(personasResponsables[fila - 1][butaca])) {
            asientos[fila - 1][butaca - 1] = false;
            asientos[fila - 1][butaca] = false;
            System.out.println("Asiento[" + fila + "," + (butaca) + "] y Asiento[" + fila + "," + (butaca+1) + "] liberados.");
        } 
        else {
            System.out.println("Las butacas no están ocupadas para liberarse.");
        }
    }

    // Método que permite ver dada una posición de asiento, si las posiciones contiguas a izquierda o a derecha están libres.
    // Devolverá un array booleano de dos posiciones, la primera con el estado del asiento contiguo a la izquierda y la segunda con el estado del asiento contiguo a la derecha. Si el asiento contiguo a la izquierda o a la derecha no existe, se indicará con un valor null en la posición correspondiente del array.
    public boolean[] verificarAsientosContiguos(int fila, int butaca) {
        boolean[] contiguos = new boolean[2]; // Array de dos posiciones: izquierda y derecha
        int numColumnas = asientos[0].length;
        
        // Verificar asiento contiguo a la izquierda
        if (butaca > 1) {
            contiguos[0] = !asientos[fila - 1][butaca - 2]; // Asiento disponible a la izquierda
        } else {
            contiguos[0] = false; // No hay asiento a la izquierda
        }
        
        // Verificar asiento contiguo a la derecha
        if (butaca < numColumnas) {
            contiguos[1] = !asientos[fila - 1][butaca]; // Asiento a la derecha
        } else {
            contiguos[1] = false; // No hay asiento a la derecha
        }
        
        return contiguos;
    }
}
