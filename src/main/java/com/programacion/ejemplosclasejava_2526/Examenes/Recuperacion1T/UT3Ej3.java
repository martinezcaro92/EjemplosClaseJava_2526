/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Examenes.Recuperacion1T;

import java.util.Scanner;

/**
 *
 * @author josem
 */
public class UT3Ej3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner (System.in);
        
        int plazas = 15;
        int opcion = 0;
        String parking [] = new String [plazas];
        
        for (int i = 0; i<parking.length; i++)
        {
            parking[i] = "-";
        }
        
        do{
            System.out.println("App para gestionar el parking del IES Ramon Arcas");
            System.out.println("1. Entrar al aparcamiento");
            System.out.println("2. Salir del aparcamiento");
            System.out.println("3. Buscar (libre/ocupada)");
            System.out.println("4. Contabilizar plazas libres");
            System.out.println("5. Salir");
            System.out.print("Seleccione opcion: ");
            opcion = scan.nextInt();
            
            switch (opcion)
            {
                case 1:
                    parking = registrarAparcamiento(parking);
                    break;
                    
                case 2:
                    parking = salirAparcamiento(parking);
                    break;
                    
                case 3:
                    int plaza = getPlazaAparcamiento();
                    boolean estado = buscarAparcamiento(parking, plaza);
                    System.out.println("El estado de la plaza (" + plaza + ") es: " + estado);
                    break;
                    
                case 4:
                    contabilizarAparcamiento(parking);
                    break;
                
                default:
                    System.out.println("Opcion no permitida, vuelva a introducir opcion");
                    break;
            }
                
        } while (opcion!=5);
    }
    public static void contabilizarAparcamiento (String [] parking)
    {
        int aux = 0;
        for (int i = 0; i< parking.length; i++)
        {
            if (parking[i].equals("-")) aux++;
        }
        System.out.println("El número de plazas libres es: " + aux);
    }
    public static boolean buscarAparcamiento(String [] parking, int plaza)
    {
        if (parking[plaza].equals("-")) return true;
        else return false;
    }
    
    public static String [] registrarAparcamiento(String [] parking)
    {
        int plaza = getPlazaAparcamiento();
        boolean estado = buscarAparcamiento(parking, plaza);
        if(estado)
        {
            String matricula = getMatricula();
            parking[plaza] = matricula;
        }
        else {
            System.out.println("La plaza de garaje esta ocupada y no se puede registrar");
        }  
        return parking;
    }
    
    public static String [] salirAparcamiento(String [] parking)
    {
        int plaza = getPlazaAparcamiento();
        boolean estado = buscarAparcamiento(parking, plaza);
        if (estado == false){ // equivalente a if(!estado)
            parking[plaza] = "-";
        }
        else {
            System.out.println("La plaza de garaje ya se encuentra libre");
        }
        return parking;
    }
    
    public static int getPlazaAparcamiento ()
    {
        Scanner scan = new Scanner (System.in);
        System.out.print("Introduzca el numero de plaza que quiere consultar (0-14): ");
        int plaza = scan.nextInt();
        return plaza;
    }
    
    public static String getMatricula ()
    {
        Scanner scan = new Scanner (System.in);
        System.out.print("Introduzca el numero de matricula: ");
        String matricula = scan.nextLine();
        return matricula;
    }
            
}
