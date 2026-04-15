/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.IO.texto;

import java.io.*;
import java.util.Scanner;

public class InformeCalificaciones {
    public static void main(String[] args) {
        // Inicializamos los objetos necesarios para la escritura
        Scanner scanner = new Scanner(System.in);
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        String path = "src\\main\\java\\com\\programacion\\ejemplosclasejava_2526\\IO\\texto\\";

        try {
            // Se abre el archivo en modo "append" para no sobrescribir los datos
            fileWriter = new FileWriter(path+"informe_calificaciones.txt", true);
            printWriter = new PrintWriter(fileWriter);

            // Ingreso de datos
            String nombreEstudiante;
            int calificacion;
            boolean continuar = true;

            while (continuar) {
                // Solicitar el nombre y la calificación
                System.out.print("Introduce el nombre del estudiante: ");
                nombreEstudiante = scanner.nextLine();

                System.out.print("Introduce la calificación de " + nombreEstudiante + ": ");
                calificacion = Integer.parseInt(scanner.nextLine());

                // Escribir en el archivo
                printWriter.println(nombreEstudiante + ": " + calificacion);

                // Preguntar si desean añadir otro estudiante
                System.out.print("¿Quieres añadir otro estudiante? (si/no): ");
                String respuesta = scanner.nextLine();
                if (respuesta.equalsIgnoreCase("no")) {
                    continuar = false;
                }
            }

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        } finally {
            // Cerrar los recursos
            if (printWriter != null) {
                printWriter.close();
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar el archivo: " + e.getMessage());
                }
            }
        }

        // Mensaje de confirmación
        System.out.println("Informe generado exitosamente.");
    }
}