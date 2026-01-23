/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.ArrayList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author josem
 */
public class EjerciciosArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    /*Enunciado 1: Crea un ArrayList<String> con cinco nombres y muéstralos 
        por pantalla usando forEach().*/
        ArrayList<String> nombres = new ArrayList<String>(List.of("Pedro", "Maria", "Eva", "Juan", "Jose"));
        nombres.forEach(System.out::println);
        
    /*Enunciado 2: Crea un ArrayList de enteros y añade tres elementos en diferentes líneas
        Muestra su tamaño antes y después de cada operación*/
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        System.out.println("Etapa 1: " + numeros.size());
        numeros.add(1);
        System.out.println("Etapa 2: " + numeros.size());
        numeros.add(2);
        System.out.println("Etapa 3: " + numeros.size());
        numeros.add(3);
        System.out.println("Etapa 4: " + numeros.size());
        
    /*Enunciado 3: Generar una lista de colores que contengan (rojo, verde y azul),
        comprobando posteriormente que existen los colores verde y negro. */
        ArrayList<String> colores = new ArrayList<String>(List.of("rojo", "verde", "azul"));
        System.out.println(colores.contains("verde"));
        System.out.println(colores.contains("negro"));
        
    /*Enunciado 4: Define una lista de valores reales (1.2, 2.5, 3.7 y 4.0) que imprima
        el valor de la posición i=2 y la modifique posteriormente a 9.9 */
        ArrayList<Double> reales = new ArrayList<Double>(List.of(1.2, 2.5, 3.7, 4.0));
        System.out.println("Pos 2 (antes): " + reales.get(2));
        reales.set(2, 9.9);
        System.out.println("Pos 2 (despues): " + reales.get(2));
        
    /*Enunciado 5: Define una lista de Caracteres (A, B, C, D, E, F) e imprimirlos en una 
        misma línea separados por ", "*/
        ArrayList<Character> caracteres = new ArrayList<Character>(List.of('A', 'B', 'C', 'D', 'E', 'F'));
        caracteres.forEach(p -> System.out.print(p + ", "));
        //caracteres.forEach(System.out::print);  // Aquí no se puede emplear esta lína porque no incluye en ", "
        
        System.out.println("");
        
    /*Enunciado 6: Toma el array de valores reales, ordénalo de forma descendente e imprima el resultado en una línea*/
        reales.sort(Comparator.reverseOrder());
        reales.forEach(System.out::println);
        
    /*Enunciado 7: A partir de la lista colores previamente definida, ordenar la lista por la longitud de caracteres
        (menos caracteres antes, más caracteres después) */
        colores.sort(Comparator.comparing(String::length));
        colores.forEach(System.out::println);
        // .comparingInt (p -> p.length())
        
    /*Enunciado 8: Filtrar los nombres que empiezan por la letra J */
        nombres.stream()
               .filter(p -> p.startsWith("J"))
               .forEach(System.out::println);
    
    /*Enunciado 9: Contar el total de nombres de personas que tienen más de 4 caracteres*/
        long cuenta = nombres.stream()
                            .filter(p-> p.length() > 4)
                            .count();
        System.out.println("La condición se cumple (veces): " + cuenta);
               //.forEach(System.out::println); // en este caso no es un forEach, porque no hay que imprimir (hay que contar)
    }
    
}
