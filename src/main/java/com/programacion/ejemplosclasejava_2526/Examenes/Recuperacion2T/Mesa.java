/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.ejemplosclasejava_2526.Examenes.Recuperacion2T;

import java.util.ArrayList;

/**
 *
 * @author josem
 */
public class Mesa implements IPedible, IPagable{
    private static int contadorMesas = 30;
    private int numeroMesa;
    private ArrayList<Cliente> clientes;
    private ArrayList<Plato> platos;
    private Camarero camarero;

    public Mesa() {
        numeroMesa = contadorMesas++;
        clientes = new ArrayList<Cliente>();
        platos = new ArrayList<Plato>();
        this.camarero = null;
    }
    public void anadirCliente(Cliente cliente)
    {
        if(cliente == null) throw new DatosNoValidosException("El cliente proporcionado no es válido");
        this.clientes.add(cliente);
    }
    public void setCamareroAsignado(Camarero camarero)
    {
        if(camarero == null) throw new DatosNoValidosException("El camarero proporcionado no es válido");
        this.camarero = camarero;
    }

    @Override
    public void agregarPlato(Plato plato) {
        if (plato == null) {
            throw new DatosNoValidosException("El plato proporcionado no es válido");
        }
        this.platos.add(plato);
    }

    @Override
    public double calcularTotal() {
        double aux = 0;
        for(Plato p : platos)
        {
            aux += p.getPrecio();
        }
        return aux;
    }

    public static int getContadorMesas() {
        return contadorMesas;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Plato> getPlatos() {
        return platos;
    }

    public Camarero getCamarero() {
        return camarero;
    }

    @Override
    public String toString() {
        return "Mesa - " + numeroMesa +
                "\n     clientes=" + clientes +
                "\n     platosConsumidos=" + platos +
                "\n     camareroAsignado=" + camarero +
                "\n     total=" + calcularTotal() +
                '}';
    
    }
}
