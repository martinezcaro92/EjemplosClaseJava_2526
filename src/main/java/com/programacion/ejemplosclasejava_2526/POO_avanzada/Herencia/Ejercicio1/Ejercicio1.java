/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada.HerenciaEjercicio1;

/**
 *
 * @author josem
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creamos los tres objetos
        Empleado em1 = new Empleado ("11111111A", "Antonio");
        Contable co1 = new Contable ("22222222B", "Pedro");
        Director di1 = new Director ("33333333C", "Juan", 111);
        
        // Añadir 5 horas extra a cada uno. Aquí se sobreescribe si algún objeto
        // ya tiene un número de horas extras distinto a 0. No sería un método óptimo/válido
        //em1.setHorasExtra(5);
        //co1.setHorasExtra(5);
        //di1.setHorasExtra(5);
        
        // En este caso suma 5 horas al valor definido en horasExtra (independientemente
        // el valor que tome)
        em1.setHorasExtra(em1.getHorasExtra() + 5);
        co1.setHorasExtra(co1.getHorasExtra() + 5);
        di1.setHorasExtra(di1.getHorasExtra() + 5);
        
        System.out.println(em1.toString() + " - Sueldo: " + em1.calcularSueldo());
        System.out.println(co1.toString() + " - Sueldo: " + co1.calcularSueldo());
        System.out.println(di1.toString() + " - Sueldo: " + di1.calcularSueldo());
        
        System.out.println("");
        co1.contabilizar();
        di1.analizar();
    }
    
}
