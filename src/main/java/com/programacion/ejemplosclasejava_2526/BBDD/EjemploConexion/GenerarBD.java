/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.BBDD.EjemploConexion;
import java.sql.*;

/**
 *
 * @author jacuela
 */
public class GenerarBD {
/**
* @param args the command line arguments
*/
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here


        //***********************************************************
        // NOS CONECTAMOS A LA BASE DE DATOS PERSONAS
        //***********************************************************

        String url = "jdbc:mysql://localhost:3306/personas";
        String username = "root";
        String password = "RootPass123!";

        Statement statement = null;
        ResultSet rs = null;

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Conexion exitosa a MySQL.");
            statement = conn.createStatement();

            String sql=String.format("DROP TABLE IF EXISTS empleados;\n "
                    +   "CREATE TABLE empleados (" +
                        "  `id` int(11) NOT NULL AUTO_INCREMENT," +
                        "  `Nombre` varchar(255) NOT NULL," +
                        "  `Apellidos` varchar(255) DEFAULT NULL," +
                        "  `Edad` int(11) DEFAULT NULL," +
                        "  PRIMARY KEY (`id`)" +");");
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error al conectar: " + ex.getMessage());
        } finally {
            if (rs!=null) rs.close();
            if (statement != null) statement.close();
        }
    }
}