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
        
        
        //String datos = ja_listacontactos.toString(1);
        //System.out.println(datos);
        
        // Ejemplo4 para imprimir el array 
        //Recorremos el array e imprimimos los objetos que tenga
//        JSONObject json;
//        for (int i = 0; i < ja_listacontactos.length(); i++) {
//            json = ja_listacontactos.getJSONObject(i);
//            //json = (JSONObject)ja_listacontactos.get(i);
//            System.out.println("Objeto numero "+i);
//            System.out.println("------------------");
//            System.out.println(json.toString(1));
//            System.out.println("");
//        }
        
        //Imprimos el nombre, la edad y la localidad si tiene
            String nombre;
            int edad;
            JSONObject direccion;
            JSONObject json;
            for (int i = 0; i < ja_listacontactos.length(); i++) {
                json = (JSONObject)ja_listacontactos.get(i);
                System.out.println("Objeto "+i+":");
                //Sacamos el nombre usando opt. Hay que controlar nulos
                nombre = (String)json.opt("nombre");
                if (nombre!=null) System.out.println(" -nombre:"+nombre);
                
                //Sacamos la edad usando has y get. Si estamos seguros de que
                //tiene edad, no es necesario el has
                if (json.has("edad")){
                    System.out.println(" -edad:"+json.getInt("edad"));
                }
                //Sacamos la localidad usando otra vez has y get
                if (json.has("direccion")){
                    direccion = (JSONObject)json.get("direccion");
                    if (direccion.has("localidad")){
                        System.out.println("-localidad:"+direccion.getString("localidad"));
                    }
                }
                else{
                    System.out.println(" -localidad:NO TIENE");
                }
            }
    }
    
}
