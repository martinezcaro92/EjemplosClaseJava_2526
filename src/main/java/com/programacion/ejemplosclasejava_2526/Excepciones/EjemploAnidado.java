/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Excepciones;

/**
 *
 * @author josem
 */
public class EjemploAnidado {
    // El método más interno lanza la excepción
    public static void nivel3(int x, int y) throws Exception, IllegalArgumentException {
        if (x<y)
        {
            throw new Exception("Error crítico en nivel 3");
        }
        else if (x>y)
        {
            throw new IllegalArgumentException ("X es ahora mayor que Y");
        }
        System.out.println("Ambos valores son iguales, que es lo que se persigue");
    }

    // El intermedio no la trata, solo declara que la propaga
    public static void nivel2() throws Exception {
        nivel3(10, 10);
    }

    // El principal finalmente la captura
    public static void nivel1() {
        try {
            nivel2();
        } catch (Exception e) {
            System.out.println("Tratando el error de nivel 3: " + e.getMessage());
        }
    }
    
    public static void main (String [] args) {
        nivel1();
    }
}