/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.JSON;
import org.json.JSONObject;
/**
 *
 * @author josem
 */
public class Ejemplo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JSONObject jsonObject;
        
        jsonObject = new JSONObject();
        jsonObject.put("nombre", "Juan");
        jsonObject.put("edad", 19);
        jsonObject.put("email", "juan@kk.com");

        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.toString(1));

        String jsonObjectString = jsonObject.toString(1);
        System.out.println(jsonObjectString);
    }
    
}
