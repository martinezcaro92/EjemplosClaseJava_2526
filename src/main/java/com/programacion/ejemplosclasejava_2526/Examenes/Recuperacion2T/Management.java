/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Examenes.Recuperacion2T;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author josem
 */

public class Management {
    public static void main(String[] args) {
        try {
            // Platos
            Plato plato1 = new Plato("Ensalada César", 8.50);
            Plato plato2 = new Plato("Pizza Barbacoa", 12.00);
            Plato plato3 = new Plato("Pasta Carbonara", 10.50);
            Plato plato4 = new Plato("Tarta de Queso", 5.25);

            ArrayList<Plato> carta = new ArrayList<Plato>(List.of(plato1, plato2, plato3, plato4));

            // Camareros
            Camarero camarero1 = new Camarero("Lucía");
            Camarero camarero2 = new Camarero("Carlos");

            // Clientes mesa 1
            Cliente cliente1 = new Cliente("Ana", "600111111", "ana@email.com");
            Cliente cliente2 = new Cliente("Pepe", "600222222", "pepe@email.com");

            ArrayList<Cliente> clientesMesa1 = new ArrayList<Cliente>();
            clientesMesa1.add(cliente1);
            clientesMesa1.add(cliente2);

            // Clientes mesa 2
            Cliente cliente3 = new Cliente("María", "600333333", "maria@email.com");
            Cliente cliente4 = new Cliente("Jorge", "600444444", "jorge@email.com");
            Cliente cliente5 = new Cliente("Elena", "600555555", "elena@email.com");

            ArrayList<Cliente> clientesMesa2 = new ArrayList<Cliente>();
            clientesMesa2.add(cliente3);
            clientesMesa2.add(cliente4);
            clientesMesa2.add(cliente5);

            // Mesas
            Mesa mesa1 = new Mesa();
            Mesa mesa2 = new Mesa();

            // Asociar clientes a las mesas
            mesa1.anadirCliente(cliente1);
            mesa1.anadirCliente(cliente2);
            mesa2.anadirCliente(cliente3);
            mesa2.anadirCliente(cliente4);
            mesa2.anadirCliente(cliente5);

            // Platos consumidos en mesa 1
            mesa1.agregarPlato(plato1);
            mesa1.agregarPlato(plato2);
            mesa1.agregarPlato(plato4);

            // Platos consumidos en mesa 2
            mesa2.agregarPlato(plato3);
            mesa2.agregarPlato(plato4);

            // Añadir camarero a la mesa
            mesa1.setCamareroAsignado(camarero1);
            mesa2.setCamareroAsignado(camarero2);

            ArrayList<Mesa> mesas = new ArrayList<Mesa>(List.of(mesa1, mesa2));

            // Restaurante
            Restaurante restaurante = new Restaurante("Restaurante DAW", carta, mesas);


            // También puedes forzar la validación de existencia
            restaurante.buscarMesa(30);


            // Mostrar información
            System.out.println("=== INFORMACIÓN DEL RESTAURANTE ===");
            System.out.println("Nombre: " + restaurante.getNombre());
            System.out.println();

            restaurante.mostrarInformacionMesas();

        } catch (DatosNoValidosException e) {
            System.out.println("Error de datos: " + e.getMessage());
        } catch (MesaNoDisponibleException e) {
            System.out.println("Error de mesa: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}