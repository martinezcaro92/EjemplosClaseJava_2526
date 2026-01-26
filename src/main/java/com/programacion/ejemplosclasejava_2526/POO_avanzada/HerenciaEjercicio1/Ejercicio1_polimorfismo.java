/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada.HerenciaEjercicio1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josem
 */
public class Ejercicio1_polimorfismo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleado em1 = new Empleado ("11111111A", "Antonio");
        Contable co1 = new Contable ("22222222B", "Pedro");
        Director di1 = new Director ("33333333C", "Juan", 111);
        
        ArrayList<Empleado> empleados1 = new ArrayList<Empleado>(List.of(em1, co1, di1));
        ArrayList<Empleado> empleados2 = new ArrayList<Empleado>();
        empleados2.add(em1);
        empleados2.add(co1);
        empleados2.add(di1);
        
        // Forma de realizarlo más sencilla utilizando un bucle for tradicional
        for (int i = 0; i<empleados1.size(); i++)
        {
            empleados1.get(i).setHorasExtra(empleados1.get(i).getHorasExtra() + 5);
            System.out.println(empleados1.get(i).toString() + " - Sueldo: " + empleados1.get(i).calcularSueldo());
            
            if (empleados1.get(i) instanceof Contable)
            {
                Contable c = (Contable)empleados1.get(i);
                c.contabilizar();
            }
            if (empleados1.get(i) instanceof Director)
            {
                Director d = (Director)empleados1.get(i);
                d.analizar();
            }
        }
        
        // Trabajo de repaso: realizar el bucle for con la forma for (Empleado e : empleados1)
        
        
        // Trabajo de repaso: realizar las operaciones con stream() y forEach()
    }
    
}
