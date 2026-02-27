/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Excepciones;

import java.util.ArrayList;

/**
 *
 * @author josem
 */
public class Curso {
    //tipoDato nombreVariable = new tipoDato();
    //Alumno listAlumnos = new Alumno();
    //Alumno [] listaAlumnos = new Alumno [5];
    private static ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    private static int limit = 5;
    
    public static class Completo extends RuntimeException {
        public Completo() { super("El curso ha alcanzado su cupo máximo"); }
        public Completo(String msg){ super ("El curso ha alcanzado su cupo máximo. " + msg);}
    }

    
    public static boolean completo(ArrayList<Alumno> alumnos)
    {
        if (alumnos.size()>=limit) 
        {
            return true;
        }
        return false;

    }
    
    public static boolean completo()
    {
        return alumnos.size()>=limit;
    }
    
    public static void anadeAlumno(Alumno a) {
        System.out.println("Anadiendo nuevo alumno...");
        if (completo()) throw new Completo(a.getNombre());
        alumnos.add(a);
    }
    
    public static void main(String[] args) {
        Alumno a1 = new Alumno("Diego", 19, "SDAW1");
        Alumno a2 = new Alumno("Paola", 22, "1ESO");
        Alumno a3 = new Alumno("Josue", 20, "2Bach");
        Alumno a4 = new Alumno("Antonio", 21, "FPB1");
        Alumno a5 = new Alumno("Alexander", 19, "AyF1");
        Alumno a6 = new Alumno("Penarrieta", 25, "AyF2");
        
        try {
            anadeAlumno(a1);
            anadeAlumno(a2);
            anadeAlumno(a3);
            anadeAlumno(a4);
            anadeAlumno(a5);
            anadeAlumno(a6);
        } catch (Completo e) {
            System.out.println("Se ha producido un error (Completo)");
            System.out.println(e);
        } catch (Exception e) {
            System.out.println("Se ha producido un error (Exception)");
            System.out.println(e);
        } finally {
            System.out.println("Se ha completado el proceso...");
        }
        
        
        
    }
    
    
}