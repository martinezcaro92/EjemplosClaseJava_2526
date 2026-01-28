/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada.Herencia.Ejercicio2;

import java.util.ArrayList;

/**
 *
 * @author josem
 */
public class BdUsuarios {
    /**
     * @param args the command line arguments
     */
    private static ArrayList<UsuNormal> bd = new ArrayList<UsuNormal>();
    
    public static void anadirUsuario(UsuNormal usuario)
    {
        bd.add(usuario);
    }
    
    public static ArrayList<UsuNormal> obtenerBD()
    {
        return bd;
    }
    
    public static UsuNormal obtenerUsuario (String usuario)
    {
        for (UsuNormal user: bd)
        {
            if(user.getNombre().equals(usuario))
            {
                return user;
            }
        }
        return null;
    }
    
    public static boolean verificarLogin (String usuario, String contrasena)
    {
        //Diferentes métodos de resolverlo, de más sencilla a más compleja
//        for (int i = 0; i<bd.size();i++)
//        {
//            if(bd.get(i).getNombre().equals(usuario) && bd.get(i).getPassword().equals(contrasena))
//            {
//                return true;
//            }
//        }
//        return false;
        
        //2º forma utilizando un for "corto" 
        for (UsuNormal user: bd)
        {
            if(user.getNombre().equals(usuario) && user.getPassword().equals(contrasena))
            {
                return true;
            }
        }
        return false;
        
        //3º forma utilizando stream() y filter() -- Hacer para prácticar en casa
        //bd.stream().filter();
    }
    
//    public static void main (String [] args)
//    {
//        
//    }
    
}
