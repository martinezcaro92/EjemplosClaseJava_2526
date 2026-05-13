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
public class EjemploAccesoBD {
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
        // Primera forma de añadir la información en un INSERT (toda la información en el String)
//         statement.executeUpdate("INSERT INTO Personas VALUES(NULL,'David','Costa',19)");
        
        // Segunda forma de añadir la información a un INSERT, utilizando variables y codificando con
        // el String.format
        String nombre="Martita";
        String apellido="Gris";
        int edad=20;
        
//        String sql=String.format("INSERT INTO Personas VALUES (NULL,'%s','%s',%d)",nombre,apellido,edad);
//        statement.executeUpdate(sql);

        // Tercera forma de añadir la información a un INSERT, es concatenando la información con +
//        statement.executeUpdate("INSERT INTO Personas VALUES (NULL,'" + nombre + "','" + apellido + "'," + edad + ")");

        // Cuarta forma de añadir informacióna un INSERT mediante la obtención de datos de un array
        
//        String nombres[]={"Alfredo","Dario", "Jose Manuel"};
//        String apellidos[]={"Perez","Olmos", null};
//        String edades[]={"19","56", null};
//        
//        //se insertan datos en la tabla
//        for (int i = 0; i < nombres.length; i++) {
//
//            if (apellidos[i] == null)
//            {
//                statement.executeUpdate("INSERT INTO Personas VALUES (NULL, '" + nombres[i] + "',"
//                        + apellidos[i] + "," + edades[i] + ")");
//            }
//            else {
//                statement.executeUpdate("INSERT INTO Personas VALUES (NULL, '" + nombres[i] + "','" 
//                                         + apellidos[i] + "'," + edades[i] + ")");
//            }
//        }
        //***********************************************************
        // HACEMOS UN SELECT
        //***********************************************************
// Primera forma de añadir la información en un SELECT (toda la información en el String)
//        ResultSet rs = statement.executeQuery("SELECT * FROM Personas");
        // System.out.println(rs); // ESTO NO FUNCIONA, HAY QUE DESGLOSARLO
// Segunda forma de añadir la información en un SELECT (pedir campos concretos)
        rs = statement.executeQuery("SELECT id, nombre,apellidos FROM Personas");
        while (rs.next()) {
            int id = rs.getInt("id");
            String nombreSelect = rs.getString("nombre");
            String apellidoSelect = rs.getString("apellidos");
//            int edadSelect = rs.getInt("edad");
            System.out.printf("%d : %s %s,\n", id, nombreSelect, apellidoSelect);            
//            System.out.printf("%d, %s %s, %d\n", id, nombre, apellido, edad);
        }
    } catch (SQLException ex) {
        System.out.println("Error al conectar: " + ex.getMessage());
    } finally {
        if (rs!=null) rs.close();
        if (statement != null) statement.close();
    }
    
    

//    try{


//        
//    } catch (SQLException ex) {
//    System.out.println(ex);
//    }
 }
}