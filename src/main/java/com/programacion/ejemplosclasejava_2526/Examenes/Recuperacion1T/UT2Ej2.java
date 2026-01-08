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
public class UT2Ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner (System.in);
        
        int dias = 7;
        int total = 0;
        double media = 0;
        double maxDia = 0;
        double minDia = 60;
        int distancia = 0;
        
        for (int i = 0; i<dias; i++)
        {
            System.out.print("Indique los km recorridos ("+(i+1)+"): ");
            distancia = scan.nextInt();
            
            if (i<5)
            {
                if (distancia < 40 && distancia >= 0)
                {
                    total += distancia;
                    if (distancia > maxDia) maxDia = distancia;
                    if (distancia < minDia) minDia = distancia;
                }else{
                    while (distancia > 40 || distancia <0){
                        System.out.print("Vuelva a introducir los km recorridos ("+(i+1)+"): ");
                        distancia = scan.nextInt();
                    }
                    total += distancia;
                    if (distancia > maxDia) maxDia = distancia;
                    if (distancia < minDia) minDia = distancia;
                }
            }
            else {
                if (distancia < 60 && distancia >= 0)
                {
                    total += distancia;
                    if (distancia > maxDia) maxDia = distancia;
                    if (distancia < minDia) minDia = distancia;
                }else{
                    while (distancia > 60 || distancia <0){
                        System.out.print("Vuelva a introducir los km recorridos ("+(i+1)+"): ");
                        distancia = scan.nextInt();
                    }
                    total += distancia;
                    if (distancia > maxDia) maxDia = distancia;
                    if (distancia < minDia) minDia = distancia;
                }
            }
        }
        media = (double) total/dias;
        
        System.out.println("El total de km recorridos ha sido: " + total);
        System.out.println("La media de km recorridos ha sido: " + media);
        System.out.println("El día que más km se han recorrido: " + maxDia + " km");
        System.out.println("El día que menos km se han recorrido: " + minDia + " km");
    }
    
}
