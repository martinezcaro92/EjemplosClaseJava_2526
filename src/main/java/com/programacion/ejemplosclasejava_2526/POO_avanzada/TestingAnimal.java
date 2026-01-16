/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada;

/**
 *
 * @author josem
 */
public class TestingAnimal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Animal granjaAnimales [] = new Animal [4];
        granjaAnimales[0] = new Animal ("Zipi");
        granjaAnimales[1] = new Perro ("Tobi");
        granjaAnimales[2] = new Animal ("Zape");
        granjaAnimales[3] = new Gato ("Michu");
        
        
        
        for (int i =0; i<granjaAnimales.length; i++)
        {
            /* Este if es "evitable" ya que todos las posiciones del Array
                almacenan un objeto Animal o derivado (hijos de la clase Animal).
                Por tanto, en las condiciones anteriores, todas las posiciones
                del array entrarían dentro de este if. */
//            if (granjaAnimales[i] instanceof Animal)
//            {
//                System.out.print(granjaAnimales[i].getNombre() + " - ");
//                granjaAnimales[i].comer();
//            }
            System.out.print(granjaAnimales[i].getNombre() + " - ");
            granjaAnimales[i].comer();
            
            if (granjaAnimales[i] instanceof Gato)
            {
                System.out.print(granjaAnimales[i].getNombre() + " - ");
                Gato g1 = (Gato) granjaAnimales[i];
                g1.maullar();
            }
            else if (granjaAnimales[i] instanceof Perro)
            {
                System.out.print(granjaAnimales[i].getNombre() + " - ");
                Perro p1 = (Perro) granjaAnimales[i];
                p1.ladrar();
            }
            
        }
    }
    
}
