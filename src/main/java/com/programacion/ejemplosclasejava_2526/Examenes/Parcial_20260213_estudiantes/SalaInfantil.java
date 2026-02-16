/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Examenes.Parcial_20260213_estudiantes;

public class SalaInfantil {

    // Declarar los atributos de la clase SalaInfantil, teniendo en cuenta que una sala infantil se caracteriza por:
    // - Su número de sala (numSala)
    // - La película asignada a la sala (pelicula)
    // - La matriz booleana de asientos (asientos)
    // - La categoría (String) de la sala (categoria)
    // - Un booleano que indique si la sala tiene parque de bolas (parqueDeBolas)
    // - Una matriz de objetos de tipo Persona que registre la persona responsable de cada asiento reservado
    // Tenga en cuenta si alguna de las variables anteriores han sido heredadas. En caso contrario añadir el código correspondiente para declarar los atributos necesarios en esta clase.
    // Añadir el código correspondiente aquí


    

    // Constructor
    public SalaInfantil(int numSala, int filas, int columnas, boolean parqueDeBolas) {
        // El constructor recibirá el número de sala, el número de filas, el número de columnas y un booleano que indique si la sala tiene parque de bolas. 
        // El constructor se encargará de inicializar el número de sala, el número de filas, el número de columnas, la categoría de la sala (que será "Infantil"), 
        // el estado de los asientos (inicialmente todos libres) y si dispone (o no) de parque de bolas en su interior.






    }

    // Implementación de reservar asiento para sala infantil
    public void reservarAsiento(int fila, int butaca, Persona persona) {
        // El método recibirá el número de fila, el número de butaca y la persona que desea reservar.
        // El método se encargará de reservar el asiento indicado para la persona indicada, siempre y cuando se cumplan las siguientes condiciones:
        // - La persona debe ser mayor de edad (18 años o más).
        // - El asiento indicado debe estar libre.
        // - El asiento indicado debe tener al menos un asiento contiguo libre (a la izquierda o a la derecha) para que el niño/a pueda sentarse junto a un adulto responsable.
        // En caso de que la reserva se realice correctamente, se mostrará un mensaje indicando el número de fila, el número de butaca y el nombre completo de la persona para la que se ha realizado la reserva.
        // En caso de que no se cumpla alguna de las condiciones, se mostrará un mensaje indicando el motivo por el cual no se ha podido realizar la reserva.
        if (persona.getEdad() < 18) {
            System.out.println("No puedes reservar si no tienes un adulto contigo.");
        } else
        {
            if(!verificarAsientosContiguos(fila, butaca)[0] && !verificarAsientosContiguos(fila, butaca)[1]) {
                System.out.println("No hay asientos contiguos disponibles para el niño/a.");
                return;
            }
            else if (verificarAsientosContiguos(fila, butaca)[0]) {
                // Reservar el asiento indicado y el asiento contiguo a la izquierda. Si se ha reservado el asiento 23 (fila:2, butaca:3), se reservará también el asiento 22.
                // Se almacenará también la persona responsable en ambos asientos reservados para que posteriormente se pueda verificar que ambos asientos están reservados para la misma persona responsable a la hora de liberar los asientos.
                // Añadir el código correspondiente para realizar la reserva de los asientos (asignados a una personaResponsable) .
                
                
                System.out.println("Asiento[" + fila + "," + (butaca) + "] reservado para " + persona.getNombreCompleto());
                System.out.println("Asiento[" + fila + "," + (butaca-1) + "] reservado para su acompañante");
                System.out.println();
            }
            else if (verificarAsientosContiguos(fila, butaca)[1]) {
                // Reservar el asiento indicado y el asiento contiguo a la derecha. Si se ha reservado el asiento 23 (fila:2, butaca:3), y el asiento 22 está ocupado, se reservará también el asiento 24.
                // Se almacenará también la persona responsable en ambos asientos reservados para que posteriormente se pueda verificar que ambos asientos están reservados para la misma persona responsable a la hora de liberar los asientos.
                // Añadir el código correspondiente para realizar la reserva de los asientos (asignados a una personaResponsable) .
                
                System.out.println("Asiento[" + fila + "," + butaca + "] reservado para " + persona.getNombreCompleto());
                System.out.println("Asiento[" + fila + "," + (butaca+1) + "] reservado para su acompañante");
                System.out.println();
            }
        }
    }

    // Implementación de liberar asiento para sala infantil
    public void liberarAsiento(int fila, int butaca) {
        // El método recibirá el número de fila y el número de butaca que se desea liberar.
        // El método se encargará de liberar el asiento indicado, siempre y cuando se cumplan las siguientes condiciones:
        // - El asiento indicado debe estar ocupado.
        // - El asiento indicado debe tener un asiento contiguo ocupado (a la izquierda o a la derecha) que esté reservado para la misma persona responsable, para que el niño/a pueda sentarse junto a un adulto responsable.
        // En caso de que la liberación se realice correctamente, se mostrará un mensaje indicando el número de fila y el número de butaca que se han liberado.
        // En caso de que no se cumpla alguna de las condiciones, se mostrará un mensaje indicando el motivo por el cual no se ha podido realizar la liberación.
        // Añadir el código necesario para desarrollar esta operación, verificando las condiciones indicadas anteriormente.



    }

    // Método que permite ver dada una posición de asiento, si las posiciones contiguas a izquierda o a derecha están libres.
    // Devolverá un array booleano de dos posiciones, la primera con el estado del asiento contiguo a la izquierda y la segunda con el estado del asiento contiguo a la derecha. Si el asiento contiguo a la izquierda o a la derecha no existe, se indicará con un valor null en la posición correspondiente del array.
    // No es necesario modificar nada de este método, ya que se ha implementado correctamente.
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
