/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.JSON;
import org.json.JSONObject;
import org.json.JSONArray;
/**
 *
 * @author josem
 */
public class Ejemplo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JSONObject jo;
        JSONArray ja = new JSONArray();

        jo = new JSONObject();
        jo.put("nombre", "Juan");
        jo.put("edad", 19);
        jo.put("email", "juan@kk.com");
        ja.put(jo);

        jo = new JSONObject();
        jo.put("nombre", "Pepe");
        jo.put("edad", 66);
        jo.put("email", "pepe@kk.com");
        ja.put(jo);
        System.out.println(ja.toString(1));
    }
    
}
