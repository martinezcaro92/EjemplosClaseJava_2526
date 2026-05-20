/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.BBDD.LecturaLigaBasquet;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author josem
 */
public class Actividad2 {
    // ------------------------------------------------------------------
    // Constantes de conexión (ajusta usuario y contraseña si es necesario)
    // ------------------------------------------------------------------
    // Hay que definir constantes estáticas de tipo String para la URL, usuario y contraseña
    
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String nombreBBDD = "ligabasket";
    private static final String URLBBDD = URL + nombreBBDD;
    
    private static final String user = "root";
    private static final String password = "RootPass123!";
    
    // -------------------------------------------------------------------------
    // SQL de creación de tablas (puede ser copiado y pegado directamente del recurso)
    // -------------------------------------------------------------------------
    private static String tablaEquipos = "CREATE TABLE equipo("
            + "    id 			int UNSIGNED NOT NULL AUTO_INCREMENT,"
            + "    nombre		varchar(50),"
            + "    puntos		int UNSIGNED DEFAULT 0,"
            + "    PRIMARY KEY (id)"
            + ");";
    
    private static String tablaJugador = "CREATE TABLE jugador("
            + "    id			int UNSIGNED NOT NULL AUTO_INCREMENT,"
            + "    nombre		varchar(50),"
            + "    fecha_nac   date,"
            + "    id_equipo   int UNSIGNED DEFAULT NULL,"
            + "    PRIMARY KEY (id),"
            + "    CONSTRAINT id_equipofk FOREIGN KEY(id_equipo) REFERENCES equipo(id)"
            + ");";
    
    // -------------------------------------------------------------------------
    // Array estático de equipos  (2.5)
    // -------------------------------------------------------------------------
    private static final String[] EQUIPOS = {"Lorca", "Aguilas", "Pulpi"};
    
    
    // ==================================================================
    // MÉTODO MAIN
    // ==================================================================
    public static void main(String[] args) {
        eliminarBaseDeDatos(nombreBBDD);
        crearBaseDatos(nombreBBDD);
        crearTablas(tablaEquipos, "equipo");
        crearTablas(tablaJugador, "jugador");
        
        for (String equipo : EQUIPOS)
        {
            crearEquipo(equipo);
        }
        
        // Primero vamos a tomar el nombre del fichero en una variable que contiene el path relativo
        // desde el directorio del proyecto Java
        String fileName = "jugadores_exportados.csv";
        String path = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\BBDD\\LecturaLigaBasquet";
        String fullName = path + "\\" + fileName;
        
        crearJugadores(fullName);
        //crearJugadoresUnaConexion(fullName);

        
    }
    
    
    
    // =========================================================================
    // 2.1 · ELIMINAR BASE DE DATOS
    // =========================================================================
    public static void eliminarBaseDeDatos(String nombreBaseDeDatos)
    {
        String sql = "DROP DATABASE IF EXISTS " + nombreBaseDeDatos + ";";
        try(Connection con = DriverManager.getConnection(URL, user, password))
        {
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("La base de datos " + nombreBaseDeDatos + " ha sido eliminada");
        } catch (SQLException e){
            System.out.println("Error: " + e);
        }
    }
    
    // =========================================================================
    // 2.2 · CREAR Y USAR BASE DE DATOS
    // =========================================================================
    public static void crearBaseDatos(String nombreBaseDeDatos)
    {
        String sql = "CREATE DATABASE " + nombreBaseDeDatos + " CHARACTER SET utf8mb4;";
        try(Connection con = DriverManager.getConnection(URL, user, password))
        {
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("La base de datos " + nombreBaseDeDatos + " ha sido creada");
        } catch (SQLException e){
            System.out.println("Error: " + e);
        }
    }

    // =========================================================================
    // 2.3 · EJECUTAR SQL (creación de tablas)
    // =========================================================================
    public static void crearTablas (String sql, String nombreTabla)
    {
        try(Connection con = DriverManager.getConnection(URLBBDD, user, password))
        {
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("La tabla (" + nombreTabla + ") ha sido creada");
        } catch (SQLException e){
            System.out.println("Error: " + e);
        }
    }

    // =========================================================================
    // 2.4 · CREAR EQUIPO
    // =========================================================================
    private static void crearEquipo (String equipo){
        String sql = "INSERT INTO equipo (nombre) VALUES ('" + equipo +"');";
        try(Connection con = DriverManager.getConnection(URLBBDD, user, password))
        {
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("Equipo (" + equipo + ") ha sido creado");
        } catch (SQLException e){
            System.out.println("Error: " + e);
        }
    }
    
    
    // =========================================================================
    // 2.6 · TOMAR DATOS DESDE CSV y 2.7a · VARIANTE B - UNA CONEXIÓN POR JUGADOR
    // =========================================================================
    public static void crearJugadores (String fullName)
    {
        String sql = "";
        try {
            //Toma todo el fichero tras leerlo
            Scanner scan = new Scanner(new FileReader(fullName));

            // Toma la primera fila (cabecera), que es especial en todo el fichero
            String cabecera = scan.nextLine();
            //System.out.println(cabecera);

            //Separa los diferentes campos de la cabecera, poniendo cada uno en 
            // una posición del array generado
            String[] camposCabecera = cabecera.split(",");
            
            // Esta variable permitirá contar el número de usuarios en el fichero
            int numUsers = 0;

            // Mientras que existan líneas para leer, se meterá dentro del bucle while
            while (scan.hasNextLine()) {
                // Para cada línea de datos de usuarios, se lee la linea y se separan
                // los datos en diferentes posiciones en un array
                String linea = scan.nextLine();
                String[] camposJugador = linea.split(",");
                
                if (camposJugador.length==2)
                {
                    sql = String.format("INSERT INTO jugador (%s, %s, %s) VALUES ('%s','%s',NULL);",
                            camposCabecera[0], camposCabecera[1], camposCabecera[2],
                            camposJugador[0], camposJugador[1]);
                } else if (camposJugador.length == 3) {
                    sql = String.format("INSERT INTO jugador (%s, %s, %s) VALUES ('%s','%s',%s);", 
                                                camposCabecera[0],camposCabecera[1],camposCabecera[2],
                                                camposJugador[0],camposJugador[1], camposJugador[2]);
                }
                
                try(Connection con = DriverManager.getConnection(URLBBDD, user, password))
                {
                    Statement st = con.createStatement();
                    st.executeUpdate(sql);
                    System.out.println("El jugador "+ camposJugador[0] + " ha sido creado");
                } catch (SQLException e){
                    System.out.println("Error: " + e);
                }
                numUsers++;
            }
            System.out.println("Total de jugadores leidos: " + numUsers);
            
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
    }
// =========================================================================
    // 2.6 · TOMAR DATOS DESDE CSV y 2.7a · VARIANTE A - UNA CONEXIÓN E INSERT CON TODOS LOS JUGADORES
    // =========================================================================
    public static void crearJugadoresUnaConexion (String fullName)
    {
        String sql = "";
        try {
            //Toma todo el fichero tras leerlo
            Scanner scan = new Scanner(new FileReader(fullName));

            // Toma la primera fila (cabecera), que es especial en todo el fichero
            String cabecera = scan.nextLine();
            //System.out.println(cabecera);

            //Separa los diferentes campos de la cabecera, poniendo cada uno en 
            // una posición del array generado
            String[] camposCabecera = cabecera.split(",");
            
            // Esta variable permitirá contar el número de usuarios en el fichero
            int numUsers = 0;

            // Mientras que existan líneas para leer, se meterá dentro del bucle while
            while (scan.hasNextLine()) {
                // Para cada línea de datos de usuarios, se lee la linea y se separan
                // los datos en diferentes posiciones en un array
                String linea = scan.nextLine();
                String[] camposJugador = linea.split(",");
                
                if (camposJugador.length==2)
                {
                    sql += String.format("INSERT INTO jugador (%s, %s, %s) VALUES ('%s','%s',NULL); ",
                            camposCabecera[0], camposCabecera[1], camposCabecera[2],
                            camposJugador[0], camposJugador[1]);
                } else if (camposJugador.length == 3) {
                    sql += String.format("INSERT INTO jugador (%s, %s, %s) VALUES ('%s','%s',%s); ", 
                                                camposCabecera[0],camposCabecera[1],camposCabecera[2],
                                                camposJugador[0],camposJugador[1], camposJugador[2]);
                }
            }
            System.out.println("Total de jugadores leidos: " + numUsers);
            System.out.println("");
            
            System.out.println(sql);
            
            try(Connection con = DriverManager.getConnection(URLBBDD, user, password))
            {
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                System.out.println("Todos los jugadores han sido creados en una sóla conexión");
            } catch (SQLException e){
                System.out.println("Error: " + e);
            }
            numUsers++;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
        
}
