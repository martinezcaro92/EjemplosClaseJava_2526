/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.BBDD.LecturaLigaBasquet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author josem
 */
public class Actividad1 {
    // ------------------------------------------------------------------
    // Constantes de conexión (ajusta usuario y contraseña si es necesario)
    // ------------------------------------------------------------------
    // Hay que definir constantes estáticas de tipo String para la URL, usuario y contraseña
    
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String URLBBDD = URL + "ligabasket";
    
    private static final String user = "root";
    private static final String password = "RootPass123!";
    
    
    // ==================================================================
    // MÉTODO MAIN
    // ==================================================================
    public static void main(String[] args) {
        mostrarEquipos();
        mostrarJugadores();
    }
    
    
    
    // ==================================================================
    // MÉTODO: mostrarEquipos
    // Consulta todos los equipos y los imprime en formato tabla
    // ==================================================================
    public static void mostrarEquipos()
    {
        // Se define la sentencia SQL para obtener los datos de los equipos
        String sql = "SELECT id, nombre, puntos FROM equipo;";
        Statement st = null;
        ResultSet rs = null;
        
        try (Connection con = DriverManager.getConnection(URLBBDD, user, password))
        {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            // Ahora los datos del SELECT los tengo en rs (ResultSet) y me toca 
            // imprimir la cabecera y los datos más tarde
            
            System.out.println("--- Equipos ---");
            System.out.println("=============================================================================================");
            System.out.printf("%-5s %-20s %-8s%n", "ID", "NOMBRE", "PUNTOS");
            System.out.println("=============================================================================================");
            
            while (rs.next())
            {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int puntos = rs.getInt("puntos");
                System.out.printf("%-5d %-20s %-8d%n", id, nombre, puntos);
            }
            System.out.println("=============================================================================================");
        } catch (SQLException e)
        {
            System.out.println("Error: " + e);
        }  
    }
    
    // ==================================================================
    // MÉTODO: mostrarJugadores
    // Consulta todos los jugadores y los imprime en formato tabla.
    // Los jugadores sin equipo se muestran como "Sin equipo".
    // ==================================================================
    public static void mostrarJugadores()
    {
        // Se define la sentencia SQL para obtener los datos de los equipos
        String sql = "SELECT id, nombre, fecha_nac, id_equipo FROM jugador;";
        Statement st = null;
        ResultSet rs = null;
        
        try (Connection con = DriverManager.getConnection(URLBBDD, user, password))
        {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            // Ahora los datos del SELECT los tengo en rs (ResultSet) y me toca 
            // imprimir la cabecera y los datos más tarde
            
            System.out.println("--- Jugadores ---");
            System.out.println("=============================================================================================");
            System.out.printf("%-5s %-30s %-15s %-10s%n", "ID", "NOMBRE", "F. NACIMIENTO", "ID. EQUIPO");
            System.out.println("=============================================================================================");
            
            while (rs.next())
            {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String fecha_nac = rs.getString("fecha_nac");
                String id_equipo = rs.getString("id_equipo");
                if (rs.wasNull())
                {
                    id_equipo = "Sin equipo";
                }
                System.out.printf("%-5d %-30s %-15s %-10s%n", id, nombre, fecha_nac, id_equipo);
            }
            System.out.println("=============================================================================================");
        } catch (SQLException e)
        {
            System.out.println("Error: " + e);
        }  
    }
    
    
    
}