/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Excepciones.EjercicioValidadorUsuarios;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author josem
 */
public class RegistroUsuariosApp {
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    private static String nombre = "";
    private static int edad = 0;
    private static String email = "";
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner (System.in);
        int opcion;
        do {
            System.out.println("********** Menu Registro usuarios **********");
            System.out.println("Escoga una opcion del siguiente menu: ");
            System.out.println("   1. Registrar usuario");
            System.out.println("   2. Registrar empleado");
            System.out.println("   3. Mostrar usuario por indice");
            System.out.println("   4. Mostrar todos los usuarios");
            System.out.println("   5. Salir");
            System.out.print("Seleccione opcion: ");
            opcion = scan.nextInt();
            
            try
            {
                switch (opcion) {
                    case 1:
                        registrarUsuario();
                        break;
                    case 2:
                        registrarEmpleado();
                        break;
                    case 3:
                        mostrarUsuario();
                        break;
                    case 4:
                        mostrarTodosUsuarios();
                        break;
                    case 5:
                        System.out.println("Hasta luego!");
                        break;
                    default:
                        throw new IllegalArgumentException("Se introduce una opcion invalida");
                }
            } catch (NumberFormatException e){
                System.out.println("Se ha producido un NumberFormatException");
                System.out.println(e);   
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Se ha producido un ArrayIndexOutOfBoundsException");
                System.out.println(e);   
            } catch (NullPointerException e){
                System.out.println("Se ha producido un NullPointerException");
                System.out.println(e);   
            } catch (IllegalArgumentException e){
                System.out.println("Se ha producido un IllegalArgumentException");
                System.out.println(e);   
            } catch (Exception e) {
                System.out.println("Se ha producido un Exception");
                System.out.println(e); 
            } finally {
                System.out.println("Volviendo al menu...");
            }
        } while (opcion !=5);
    }
    
    public static void registrarUsuario()
    {
        registrarDatosComunes();
        Usuario u1 = new Usuario(nombre, edad, email);
        listaUsuarios.add(u1);
    }
    
    public static void registrarDatosComunes()
    {
        Scanner scan = new Scanner (System.in);
        System.out.print("Introduzca nombre usuario: ");
        nombre = scan.nextLine();
        System.out.print("Introduzca edad usuario: ");
        String edad1 = scan.nextLine();
        edad = Integer.parseInt(edad1);
        System.out.print("Introduzca email usuario: ");
        email = scan.nextLine();
    }
    
    public static void mostrarUsuario()
    {
        Scanner scan = new Scanner (System.in);
        System.out.print("Introduzca el indice a consultar: ");
        int indice = scan.nextInt();
        if(listaUsuarios.get(indice) == null) throw new NullPointerException("La posicion " + indice + " esta inicializada a null");
        if(listaUsuarios.size()<=indice) throw new ArrayIndexOutOfBoundsException("La posicion (" + indice + ") no esta definida en el Array");
        
        System.out.println("Imprimiendo el usuario con indice: " +indice);
        Usuario u = listaUsuarios.get(indice);
        System.out.println(u.toString());
    }
    
    public static void mostrarTodosUsuarios()
    {
        
        if (listaUsuarios.isEmpty()) throw new NullPointerException("No hay usuarios definidos por el momento");
        listaUsuarios.forEach(System.out::println);
        //listaUsuarios.forEach(p-> System.out.println(p.toString()));
//        for (Usuario u : listaUsuarios)
//        {
//            System.out.println(u.toString());
//        }
    }
    
    public static void registrarEmpleado()
    {
        registrarDatosComunes();
        
        Scanner scan = new Scanner (System.in);
        System.out.print("Introduzca nombre de la empresa: ");
        String empresa = scan.nextLine();
        System.out.print("Introduzca NUSS usuario: ");
        int nuss = scan.nextInt();
        System.out.println("Introduzca fecha de inicio: ");
        System.out.print("   Introduzca el dia: ");
        int dia = scan.nextInt();
        System.out.print("   Introduzca el mes: ");
        int mes = scan.nextInt();
        System.out.print("   Introduzca el anio: ");
        int anio = scan.nextInt();
        
        Fecha fecha = new Fecha(dia, mes, anio);
        Empleado e = new Empleado(nombre, edad, email, empresa, nuss, fecha);
        listaUsuarios.add(e);
    }
    
    // Definir un método que imprima sólo los Usuarios (excluir los Empleados). 
    // Debe modificar también el switch-case si fuese necesario
    
    
    // Definir un método que imprima sólo los Empleados definidos. 
    // Debe modificar también el switch-case si fuese necesario
    
    
    
}
