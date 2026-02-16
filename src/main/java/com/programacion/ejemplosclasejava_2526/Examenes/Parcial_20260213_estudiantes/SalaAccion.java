/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Examenes.Parcial_20260213_estudiantes;

public class SalaAccion {

    // Declarar los atributos de la clase SalaAccion, teniendo en cuenta que una sala de acción se caracteriza por:
    // - Su número de sala (numSala)
    // - La película asignada a la sala (pelicula)
    // - La matriz booleana de asientos (asientos)
    // - La categoría (String) de la sala (categoria)
    // - Un booleano que indique si la sala tiene sonido especial (sonidoEspecial)
    // - Un booleano que indique si la sala tiene efecto de agua (efectoAgua)
    // - Un booleano que indique si la sala tiene ventiladores (ventiladores)
    // Tenga en cuenta si alguna de las variables anteriores han sido heredadas. En caso contrario añadir el código correspondiente para declarar los atributos necesarios en esta clase.
    // Añadir el código correspondiente aquí





    // Constructor
    public SalaAccion(int numSala, int filas, int columnas, boolean sonidoEspecial, boolean efectoAgua, boolean ventiladores) {
        // El constructor recibirá el número de sala, el número de filas, el número de columnas, un booleano que indique si la sala tiene sonido especial, 
        // un booleano que indique si la sala tiene efecto de agua y un booleano que indique si la sala tiene ventiladores. 
        // El constructor se encargará de inicializar el número de sala, el número de filas, el número de columnas, la categoría de la sala (que será "Accion"), 
        // el estado de los asientos (inicialmente todos libres), si dispone (o no) de sonido especial, si dispone (o no) de efecto de agua y si dispone (o no) de ventiladores en su interior.
        // Añadir el código correspondiente aquí
        



    }

    // Implementación de reservar asiento para sala de Accion
    public void reservarAsiento(int fila, int butaca, Persona persona) {
        // El método recibirá el número de fila, el número de butaca y la persona que desea reservar.
        // El método se encargará de reservar el asiento indicado para la persona indicada, siempre y cuando se cumplan las siguientes condiciones:
        // - La persona debe ser mayor de edad (18 años o más).
        // - El asiento indicado debe estar libre.
        // - El número de fila y el número de butaca deben ser válidos (dentro de las dimensiones de la sala).
        // En caso de que la reserva se realice correctamente, se mostrará un mensaje indicando el número de fila, el número de butaca y el nombre completo de la persona para la que se ha realizado la reserva.
        // En caso de que no se cumpla alguna de las condiciones, se mostrará un mensaje indicando el motivo por el cual no se ha podido realizar la reserva.
        // Añadir el código correspondiente aquí






    }

    // Implementación de liberar asiento para sala de Accion
    public void liberarAsiento(int fila, int butaca) {
        // El método recibirá el número de fila y el número de butaca que se desea liberar.
        // El método se encargará de liberar el asiento indicado, siempre y cuando se cumplan las siguientes condiciones:
        // - El asiento indicado debe estar reservado.
        // - El número de fila y el número de butaca deben ser válidos (dentro de las dimensiones de la sala).
        // En caso de que la liberación se realice correctamente, se mostrará un mensaje indicando el número de fila y el número de butaca liberado.
        // En caso de que no se cumpla alguna de las condiciones, se mostrará un mensaje indicando el motivo por el cual no se ha podido realizar la liberación.
        // Añadir el código correspondiente aquí




        
        
    }
}

