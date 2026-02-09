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
public class Ejemplo3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JSONArray ja_listacontactos = new JSONArray();
        JSONObject jo_contacto;
        JSONObject json_direccion;
        
        //Primer contacto
        jo_contacto = new JSONObject();
        jo_contacto.put("nombre", "Juan");
        jo_contacto.put("edad", 19);
        jo_contacto.put("email", "juan@kk.com");
        
        json_direccion = new JSONObject();
        json_direccion.put("calle", "Avda. Juan Carlos I");
        json_direccion.put("numero", 25);
        json_direccion.put("cp", 30800);
        json_direccion.put("localidad", "Lorca");
        json_direccion.put("provincia", "Murcia");
        
        jo_contacto.put("direccion",json_direccion);
        
        ja_listacontactos.put(jo_contacto);
        

        //Segundo contacto
        jo_contacto = new JSONObject();
        jo_contacto.put("nombre", "Pepe");
        jo_contacto.put("edad", 66);
        jo_contacto.put("email", "pepe@kk.com");
        ja_listacontactos.put(jo_contacto);
        
        
        String datos = ja_listacontactos.toString(1);
        System.out.println(datos);
    }
    
}
