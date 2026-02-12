/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author josem
 */

public class Clase {
    static ArrayList <Persona> personasClase = new ArrayList<Persona>();
    static Persona posicionesClase [][] = new Persona [5][6];
    static boolean puestosLibresOcupados [][] = new boolean [5][6];
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Scanner scan = new Scanner(System.in);
        
        // Definir personas en puestos y asignar true/false en puestosLibresOcupados
        Persona miguel = new Persona("Miguel", "Re", "11111111A");
        bloquearPuesto(4, 2, miguel);
        
        // Puesto -1 para salir del programa
        do
        {
            // Recuerda que las filas y las columnas en clase empiezan a numerarse por 1
            // Pero en Arrays y ArrayList empiezan a numerarse por 0
            
            System.out.println("Indiqueme la fila del puesto a consultar: ");
            int fila = scan.nextInt();
            System.out.println("Indiqueme la columna del puesto a consultar: ");
            int columna = scan.nextInt();
            
            System.out.println ("El puesto [" + fila+","+columna+"] está ocupado? " + puestosLibresOcupados[fila-1][columna-1]);
            System.out.println ("El puesto [" + fila+","+columna+"] está ocupado por: " + posicionesClase[fila-1][columna-1]);
            
            
            
            
        } while (true);
        
        
       
    
    
    }
    public static void bloquearPuesto (int fila, int columna, Persona p)
    {
        posicionesClase [fila-1][columna-1] = p;
        puestosLibresOcupados [fila-1][columna-1] = true;
    }
    public static void inicializarPuestos ()
    {
        for(int i = 0; i< puestosLibresOcupados.length; i++){
            for(int j = 0; j< puestosLibresOcupados[0].length; j++){
                puestosLibresOcupados[i][j] = false;
                // false es que está libre, true es que está ocupado
            }
        }
    }
    
}
