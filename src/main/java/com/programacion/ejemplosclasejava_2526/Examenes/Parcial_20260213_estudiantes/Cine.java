package com.programacion.ejemplosclasejava_2526.Examenes.Parcial_20260213_estudiantes;

import java.util.*;

import com.programacion.examenes_2526.Parcial_20260213.Pelicula;

public class Cine {

    private String nombre;
    private ArrayList<Pelicula> peliculasCompradas;
    private ArrayList<SalaCine> salas;
                
    Scanner scan = new Scanner(System.in);

    // Constructor
    public Cine(String nombre) {
        // El constructor recibirá el nombre del cine y se encargará de inicializar la lista de películas compradas y la lista de salas.
        

        
    }

    // Método para inicializar salas que registre una sala de cine en el cine. 
    protected void inicializarSalas(SalaCine salaCine) {
        //El método recibirá como parámetro un objeto de tipo SalaCine y lo añadirá a la lista de salas del cine.


    }

    // Método para comprar una película
    public void comprarPelicula(Pelicula pelicula) {
        peliculasCompradas.add(pelicula);
    }

    // Método para asignar una película a una sala
    public void asignarPeliculaASala(int idPelicula, int numSala) {
        Pelicula pelicula = peliculasCompradas.stream().filter(p -> p.getId() == idPelicula).findFirst().orElse(null);
        if (pelicula != null && numSala <= salas.size() && (pelicula.getCategoria().equals(salas.get(numSala-1).categoria) || salas.get(numSala-1).categoria.equals("Standard"))) {
            salas.get(numSala - 1).asignarPelicula(pelicula);
            System.out.println("Película asignada correctamente.");
        } else {
            System.out.println();
            System.out.println("Error: Película no encontrada, sala no válida o película no disponible en dicha sala.");
            System.out.println("Pulse Enter para continuar...");
            scan.nextLine();
        }
    }

    // Método para imprimir la cartelera
    public void imprimirCartelera() {
        // Si no hay salas, mostrar mensaje de error. En caso contrario, mostrar por cada sala la película asignada a la misma, el número de sala y la categoría de la sala.
        // en caso de no tener película asignada a la sala, mostrar el mensaje "SIN PELICULA ASIGNADA" en lugar del título de la película.
        
        
    }

    // Método para mostrar todas las salas
    public void mostrarTodasSalas() {
        // Si no hay salas, mostrar mensaje de error. En caso contrario, mostrar cada sala utilizando el método pintar de SalaCine
        // Desarrollar el método para realizar la operación anteriormente descrita.
        
        
    }

    // Método para listar todas las películas compradas
    public void listarPeliculasCompradas() {
        System.out.println("************************ PELICULAS COMPRADAS ************************");
        // Ordenamos las películas por título antes de imprimir
        // Añadir aquí el código necesario para realizar dicha operación
       
        
        System.out.println("*********************************************************************");
        System.out.println();
        System.out.println("Pulse Enter para continuar...");
        scan.nextLine();
    }

    // Método para obtener una sala por su número
    public SalaCine getSalaCine(int numSala) {
        if (numSala > 0 && numSala <= salas.size()) {
            return salas.get(numSala - 1);
        }
        System.out.println("Sala no encontrada.");
        System.out.println();
        return null;
    }
    
    // Getters. Implementar los métodos necesarios para obtener el nombre del cine (getNombre) y el número de salas disponibles (getNumSalas).
    



}
