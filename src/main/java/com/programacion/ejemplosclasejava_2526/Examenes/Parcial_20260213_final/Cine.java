package com.programacion.ejemplosclasejava_2526.Examenes.Parcial_20260213_final;

import java.util.*;

public class Cine {

    private String nombre;
    private ArrayList<Pelicula> peliculasCompradas;
    private ArrayList<SalaCine> salas;
                
    Scanner scan = new Scanner(System.in);

    // Constructor
    public Cine(String nombre) {
        this.nombre = nombre;
        this.peliculasCompradas = new ArrayList<>();
        this.salas = new ArrayList<>();
    }

    // Método para inicializar salas
    protected void inicializarSalas(SalaCine salaCine) {
        salas.add(salaCine); 
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
        System.out.println("LISTA DE SALAS DEL CINE: " + nombre);
        for (int i = 0; i < salas.size(); i++) {
            SalaCine sala = salas.get(i);
            System.out.println("[SALA " + (i + 1) + "] - " + (sala.pelicula!= null ? sala.pelicula.toString() : "SIN PELICULA ASIGNADA") + " - CategoríaSala: " + sala.categoria);
        }
    }

    // Método para mostrar todas las salas
    public void mostrarTodasSalas() {
        if (salas.size() == 0)
        {
            System.out.println();
            System.out.println("El cine Almenara no presenta ninguna sala definida.");
            System.out.println("Pulse Enter para continuar...");
            scan.nextLine();
        }
        else {
            for (SalaCine sala : salas) {
                sala.pintar();
            }
        }
        
    }

    // Método para listar todas las películas compradas
    public void listarPeliculasCompradas() {
        System.out.println("************************ PELICULAS COMPRADAS ************************");
        peliculasCompradas.stream()
                .sorted()
                .forEach(System.out::println);
        
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
    
    public String getNombre () { return this.nombre;}
    public int getNumSalas () {return salas.size();}
}
