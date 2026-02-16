/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Examenes.Parcial_20260213_estudiantes;

public class SalaCine {

    // Declarar los atributos de la clase SalaCine, teniendo en cuenta que una sala de cine se caracteriza por:
    // - Su número de sala (numSala)
    // - La película asignada a la sala (pelicula)
    // - La matriz booleana de asientos (asientos)
    // - La categoría (String) de la sala (categoria)    
    // Añadir el código correspondiente aquí





    // Constructor
    public SalaCine(int numSala, int filas, int butacas) {
        // El constructor recibirá el número de sala, el número de filas y el número de columnas de la sala.
        // A partir de las filas y butacas recibidas en el constructor, se inicializará la matriz 
        // de asientos de la sala, estableciendo todos los asientos como libres (false) - Utilizar el método inicializarAsientos() para ello.
        // Añadir el código correspondiente aquí
        

    }

    // Método privado para inicializar los asientos
    private void inicializarAsientos() {
        // El método se encargará de inicializar la matriz de asientos de la sala, 
        // estableciendo todos los asientos como libres (false).
        // Añadir el código correspondiente aquí



    }

    // Método asignarPelicula
    public void asignarPelicula(Pelicula pelicula) {
        // El método recibirá una película y se encargará de asignarla a la sala, estableciendo también el estado de la película como asignada (true).
        // Añadir el código correspondiente aquí
        


    }

    // Método reservarAsiento
    public void reservarAsiento(int fila, int butaca) {
        // El método recibirá el número de fila y el número de butaca que se desea reservar.
        // El método se encargará de reservar el asiento indicado, siempre y cuando se cumplan las siguientes condiciones:
        // - El asiento indicado debe estar libre.
        // - El número de fila y el número de butaca deben ser válidos (dentro de las dimensiones de la sala).
        // En caso de que la reserva se realice correctamente, se mostrará un mensaje indicando el número de fila y el número de butaca reservado.
        // En caso de que no se cumpla alguna de las condiciones, se mostrará un mensaje indicando el motivo por el cual no se ha podido realizar la reserva.
        // Añadir el código correspondiente aquí
        






    }

    // Método liberarAsiento
    public void liberarAsiento(int fila, int butaca) {
        // El método recibirá el número de fila y el número de butaca que se desea liberar.
        // El método se encargará de liberar el asiento indicado, siempre y cuando se cumplan las siguientes condiciones:
        // - El asiento indicado debe estar ocupado.
        // - El número de fila y el número de butaca deben ser válidos (dentro de las dimensiones de la sala).
        // En caso de que la liberación se realice correctamente, se mostrará un mensaje
        // indicando el número de fila y el número de butaca liberado.
        // En caso de que no se cumpla alguna de las condiciones, se mostrará un mensaje indicando el motivo por el cual no se ha podido realizar la liberación.
        // Añadir el código correspondiente aquí

        



        
    }

    // Realizar un método toString() que codificará la información de la sala del siguiente modo:
    // "Sala [número de sala] - Película: [título de la película asignada a la sala o "SIN ASIGNAR" si no tiene película asignada]"
    // Añadir el código correspondiente aquí







    // Método pintar, representando la distribución de los asientos
    public void pintar() {
        System.out.println("SALA NUMERO " + numSala);
        System.out.println("--------------------------");
        System.out.println("| " + (pelicula != null ? pelicula.getTitulo() : "SIN PELICULA") + " |");
        System.out.println("--------------------------");

        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                System.out.print(asientos[i][j] ? "[" + ((i+1) +""+ (j+1)) + " X]" : "[" + ((i+1) +""+ (j+1)) + "  ]");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("[XY]Recuerde que el primer valor identifica la fila (X) y el segundo la columna (Y)");
        System.out.println("El número de butacas disponibles es: " + contarButacasDisponibles());
    }
    // Método para contar el número de butacas disponibles en la sala
    public int contarButacasDisponibles() {
        // El método se encargará de contar el número de butacas disponibles (libres) en la sala y devolverá dicho número.
        // Añadir el código correspondiente aquí



        
    }

    //Método getDimensiones() que devuelve las dimensiones de la sala creada en un array de dos posiciones, 
    // la primera con el número de filas y la segunda con el número de columnas
    // Añadir el código correspondiente aquí
    

}
