package com.programacion.examenes_2526.RecuperaciónExtraordinaria.UT3;

import java.util.Scanner;

public class GestionCadenas {
    public static void main(String[] args) {


        /** Salida esperada
         * 
         *  a) Acrónimo: DAW
         * b) Número de espacios: 8
         * c) Número de caracteres: 22
         * d) Número de palabras: 6
         * e) ¿Pertenece al dominio .es? true
         * f) Elementos:
         *      Producto = Teclado
         *      Precio = 45.99
         *      Stock = 12
         */

        // a) Acrónimo DAW a partir de "Desarrollo de Aplicaciones Web"
        String frase = "Desarrollo de Aplicaciones Web";
        String[] palabras = frase.split(" ");
        String acronimo = "";
        for (String p : palabras) {
            if (Character.isUpperCase(p.charAt(0))) {
                acronimo += p.charAt(0);
            }
        }
        System.out.println("a) Acrónimo: " + acronimo);

        // b) Contar espacios en blanco
        String cadenaB = "Java es un lenguaje de programación compilado e interpretado";
        int espacios = 0;
        for (int i = 0; i < cadenaB.length(); i++) {
            if (cadenaB.charAt(i) == ' ') espacios++;
        }
        System.out.println("b) Número de espacios: " + espacios);

        // c) Número de caracteres de "examen_programacion.pdf"
        String archivo = "examen_programacion.pdf";
        System.out.println("c) Número de caracteres: " + archivo.length());

        // d) Número de palabras de la frase
        String fraseD = "No me pises que llevo chanclas";
        String[] palabrasD = fraseD.split(" ");
        System.out.println("d) Número de palabras: " + palabrasD.length);

        // e) Comprobar si la URL pertenece al dominio .es
        String url = "http://iesramonarcas.es";
        boolean esEs = url.endsWith(".es");
        System.out.println("e) ¿Pertenece al dominio .es? " + esEs);

        // f) Sustituir : por = e imprimir los tres elementos en líneas independientes
        String cadenaF = "Producto: Teclado | Precio: 45.99 | Stock: 12";
        String sustituida = cadenaF.replace(":", " =");
        String[] elementos = sustituida.split("\\|");
        System.out.println("f) Elementos:");
        for (String elemento : elementos) {
            System.out.println(elemento.trim());
        }
    }
}