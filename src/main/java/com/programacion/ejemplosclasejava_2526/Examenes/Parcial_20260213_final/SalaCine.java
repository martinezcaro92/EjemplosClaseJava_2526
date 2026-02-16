/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Examenes.Parcial_20260213_final;

public class SalaCine {

    protected int numSala;
    protected Pelicula pelicula;
    protected boolean[][] asientos;
    protected String categoria;

    // Constructor
    public SalaCine(int numSala, int filas, int columnas) {
        this.numSala = numSala;
        this.asientos = new boolean[filas][columnas]; // Asientos por defecto en libre
        this.categoria = "Standard";
        inicializarAsientos();
    }

    // Método privado para inicializar los asientos
    private void inicializarAsientos() {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                asientos[i][j] = false; // Asiento libre (false)
            }
        }
    }

    // Método asignarPelicula
    public void asignarPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
        pelicula.setAsignada(true);
    }

    // Método reservarAsiento
    public void reservarAsiento(int fila, int butaca) {
        // Verificamos si la butaca está libre
        if (!asientos[fila - 1][butaca - 1]) {
            // Reservamos la butaca
            asientos[fila - 1][butaca - 1] = true;
            System.out.println("Asiento " + fila + butaca + " reservado correctamente.");
        } else {
            System.out.println("Error: El asiento " + fila + "-" + butaca + " ya está ocupado.");
        }
    }

    // Método liberarAsiento
    public void liberarAsiento(int fila, int butaca) {
        // Verificamos si la butaca está ocupada
        if (asientos[fila - 1][butaca - 1]) {
            // Liberamos la butaca
            asientos[fila - 1][butaca - 1] = false;
            System.out.println("Asiento " + fila + "-" + butaca + " liberado correctamente.");
        } else {
            System.out.println("Error: El asiento " + fila + "-" + butaca + " no está ocupado, no se puede liberar.");
        }
    }

    // Método toString para mostrar información de la sala
    @Override
    public String toString() {
        return "Sala " + numSala + " - Película: " + (pelicula != null ? pelicula.toString() : "SIN ASIGNAR");
    }

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
        public int contarButacasDisponibles() {
        int disponibles = 0;
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                if (!asientos[i][j]) {  // Si el asiento está libre
                    disponibles++;
                }
            }
        }
        return disponibles;
    }

    //Método que devuelve las dimensiones de la sala creada en un array de dos posiciones, la primera con el número de filas y la segunda con el número de columnas
    public int[] getDimensiones() {
        return new int[]{asientos.length, asientos[0].length};
    }

}
