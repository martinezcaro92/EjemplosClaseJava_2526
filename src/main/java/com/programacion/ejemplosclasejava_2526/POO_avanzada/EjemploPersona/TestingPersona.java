/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada.EjemploPersona;

/**
 *
 * @author josem
 */
public class TestingPersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Persona p1 = new Persona ();
        Persona p2 = new Persona ("Juan", "Perez", "11111111A");
        
        Empleado em1 = new Empleado();
        Empleado em2 = new Empleado("Pedro","Martinez","22222222B",     // Atributos de la clase padre (Persona)
                                    "ES123456789123456","Carpintero");  // Atributos de la clase hija (Empleado)        
        Estudiante es1 = new Estudiante ();
        Estudiante es2 = new Estudiante ("Pepa", "Garcia", "33333333C", // Atributos de la clase padre (Persona)
                                         "FP", 1, 123456, "IES Ramon Arcas"); // Atributos de la clase hija (Estudiante) 
        
        Docente d1 = new Docente ();
        String [] modulos = {"Programacion", "BBDD"};
        Docente d2 = new Docente ("Daniela", "Lopez", "44444444D", // Atributos de la clase padre (Persona)
                                    modulos, 987654,"IES Ramon Arcas"); // Atributos de la clase hija (Docente) 
        
        System.out.println("Apellido: " + p2.getApellido());
        System.out.println("Apellido: " + em2.getApellido());
        System.out.println("Apellido: " + es2.getApellido());
        System.out.println("Apellido: " + d2.getApellido());
        System.out.println("");
        System.out.println("Numero Cuenta: " + em2.getNumeroCuenta());
        System.out.println("Nivel: " + es2.getNivel());
        System.out.println("Centro: " + d2.getCentro());
        System.out.println("");
        System.out.println("Nombre Completo (Persona): " + p2.getNombreCompleto());
        System.out.println("Nombre Completo (Empleado): " + em2.getNombreCompleto());
        System.out.println("Nombre Completo (Estudiante): " + es2.getNombreCompleto());
        System.out.println("Nombre Completo (Docente): " + d2.getNombreCompleto());
        
        System.out.println("");
        System.out.println("toString (Persona): " + p2.toString());
        System.out.println("toString (Empleado): " + em2.toString());
        System.out.println("toString (Estudiante): " + es2.toString());
        System.out.println("toString (Docente): " + d2.toString());
        
        Persona personas [] = new Persona [8];
        /* IMPORTANTE: Cuando se define un array Persona, NO SÓLO almacena objetos
        de tipo Persona, sino también objetos instanciados a partir de clases hijas (heredadas)
        */
        personas[0] = p1;
        personas[1] = p2;
        personas[2] = em1;
        personas[3] = em2;
        personas[4] = es1;
        personas[5] = es2;
        personas[6] = d1;
        personas[7] = d2;
        
        
        Persona p3 = new Persona ("Pepa", "Ortiz", "55555555E");
        Estudiante es3 = new Estudiante("Antonio", "Gimenez", "66666666F", 
                                        "Bachillerato", 2, 4567123, "IES Principe de Asturias");
        
        p3 = es3;
        
        Persona p4 = new Empleado ("Alejandra", "Fernandez", "77777777G", "ES09898883933033", "Ingeniera");
        Persona p5 = new Empleado ("Adriana", "Montoya", "88888888H", "ES887654654654", "Enfermera");
        
        Empleado em5 = (Empleado) p5;
                
        System.out.println("");
        System.out.println("toString (Persona - p3): " + p3.toString());
        System.out.println("toString (Persona - p4): " + p4.toString());
        System.out.println("toString (Persona - p5): " + p5.toString());
        System.out.println("toString (Persona - em5): " + em5.toString());
        
        
        /* Se recorre el array personas para ver que tipos de datos se tiene
            en cada una de las posiciones, haciendo uso de la palabra reservada
            instanceof */
        int countEstudiante=0, countEmpleado=0, countDocente=0, countPersona=0;
        for (int i = 0 ; i < personas.length; i++)
        {
            if (personas[i] instanceof Estudiante) countEstudiante++;
            if (personas[i] instanceof Empleado) countEmpleado++;
            if (personas[i] instanceof Docente) countDocente++;
            if (personas[i] instanceof Persona) countPersona++;
        }
        System.out.println("");
        System.out.println("Count Estudiante: " + countEstudiante);
        System.out.println("Count Docente: " + countEstudiante);
        System.out.println("Count Empleado: " + countEstudiante);
        System.out.println("Count Persona: " + countPersona);
    }
        
    
}
