/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.POO_avanzada.Herencia.Ejercicio2;

import java.util.Scanner;

/**
 *
 * @author josem
 */
public class Ejercicio02_menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scan = new Scanner (System.in);
        
        UsuNormal u1 = new UsuNormal("zipi", "1234", "zipi@kk.com");
        UsuNormal u2 = new UsuNormal("zape", "4321", "zape@kk.com");
        UsuAdmin u3 = new UsuAdmin("root", "root", "root@kk.com");
        
        boolean verificado = false;
        
        // Como los métodos son estáticos se pueden llamar directamente desde cualquier lugar
        BdUsuarios.anadirUsuario(u1);
        BdUsuarios.anadirUsuario(u2);
        BdUsuarios.anadirUsuario(u3);

        
        String userAux, passAux;
        int intentosLogin = 2;
        do {
            System.out.println("Login");
            System.out.println("************");
            System.out.print("usuario: ");
            userAux = scan.nextLine();
            System.out.print("contrasena: ");
            passAux = scan.nextLine();
            
            if (BdUsuarios.verificarLogin(userAux, userAux))
            {
                verificado = true;
            }
            
            System.out.println();
            intentosLogin--;        
            
        } while (intentosLogin!=0);
        
        }
        
        
    }
    
}
